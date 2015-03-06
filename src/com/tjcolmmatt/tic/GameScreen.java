package com.tjcolmmatt.tic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.tjcolmmatt.tic.BoardData.BigBoard;
import com.tjcolmmatt.tic.BoardData.BoardTile;
import com.tjcolmmatt.tic.BoardData.GamePiece;
import com.tjcolmmatt.tic.BoardData.TicLine;
import com.tjcolmmatt.tic.BoardData.WinCover;
import sofia.app.ShapeScreen;
import sofia.graphics.ShapeFilter;

// -------------------------------------------------------------------------
/**
 * The screen that is shown when the game runs.
 *
 * @author TJ Corley (tjcorley)
 * @author Matthew Wong (mttwong)
 * @author Colm Gallagher (mecolmg)
 * @version Dec 3, 2014
 */

public class GameScreen
    extends ShapeScreen
{

    // === Private Variables ===

    private BigBoard     board;
    private float        largeCellSize;
    private float        boardSize;
    private float        maxBoard;
    private int          orientation;
    private float        smallCellSize;
    private BoardTile    turner;
    private AlertDialog  dialog;
    private WinCover[][] covers;


    // ----------------------------------------------------------
    /**
     * Initializes the screen
     */
    @Override
    public void initialize()
    {
        orientation = getResources().getConfiguration().orientation;
        board = SplashScreen.getBoard();
        // Check is for test cases
        if (board == null)
        {
            board = new BigBoard();
            SplashScreen.setBoard(board);
        }
        addLines();
        addTiles();
        addTurnDisplay();
        addCovers();
    }


    // ----------------------------------------------------------
    /**
     * Helper method to add covers
     */
    public void addCovers()
    {
        ShapeFilter<WinCover> old = getShapes().withClass(WinCover.class);
        for (WinCover oldCover : old)
        {
            oldCover.remove();
        }
        covers = board.getCovers();
        if (covers[0][0] == null)
        {
            for (int bigI = 0; bigI < 3; bigI++)
            {
                for (int bigJ = 0; bigJ < 3; bigJ++)
                {
                    float leftPadding = bigI * (10.0f + 3.0f * smallCellSize);
                    float topPadding = bigJ * (10.0f + 3.0f * smallCellSize);
                    covers[bigI][bigJ] =
                        new WinCover(
                            GamePiece.BLANK,
                            leftPadding,
                            topPadding,
                            smallCellSize * 3.0f);
                    add(covers[bigI][bigJ]);
                }
            }
        }
        else
        {
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    float leftPadding = i * (10.0f + 3.0f * smallCellSize);
                    float topPadding = j * (10.0f + 3.0f * smallCellSize);
                    covers[i][j].resize(
                        leftPadding,
                        topPadding,
                        smallCellSize * 3.0f);
                    add(covers[i][j]);
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Helper method to add tiles.
     */
    public void addTiles()
    {
        ShapeFilter<BoardTile> old = getShapes().withClass(BoardTile.class);
        for (BoardTile oldTile : old)
        {
            oldTile.remove();
        }
        smallCellSize = (boardSize - 20.0f) / 9.0f;
        for (int bigI = 0; bigI < 3; bigI++)
        {
            for (int bigJ = 0; bigJ < 3; bigJ++)
            {
                for (int smallI = 0; smallI < 3; smallI++)
                {
                    for (int smallJ = 0; smallJ < 3; smallJ++)
                    {
                        float leftPadding =
                            bigI * (10.0f + 3.0f * smallCellSize) + smallI
                                * smallCellSize;
                        float topPadding =
                            bigJ * (10.0f + 3.0f * smallCellSize) + smallJ
                                * smallCellSize;
                        int[] position = { bigI, bigJ, smallI, smallJ };
                        BoardTile temp =
                            board.getBoard(bigI, bigJ).getCell(smallI, smallJ);
                        temp.resize(leftPadding, topPadding, smallCellSize);
                        temp.setPos(position);
                        add(temp);
                    }
                }
            }
        }
        if (board.isEmpty())
        {
            board.invalidate(1, 1, 1, 1);
        }
    }


    // ----------------------------------------------------------
    /**
     * Helper method to add turn display
     */
    public void addTurnDisplay()
    {
        maxBoard = Math.max(getWidth(), getHeight());
        float turnSize = maxBoard - boardSize - 100;
        if (orientation == 1)
        {
            turnSize = Math.min(turnSize, getWidth());
            float left = (getWidth() - turnSize) / 2.0f;
            turner =
                new BoardTile(
                    board.turner().getTurn(),
                    left,
                    boardSize + 50,
                    turnSize,
                    new int[2]);
            add(turner);
        }
        else
        {
            turnSize = Math.min(turnSize, getHeight());
            float top = (getHeight() - turnSize) / 2.0f;
            turner =
                new BoardTile(
                    board.turner().getTurn(),
                    boardSize + 50,
                    top,
                    turnSize,
                    new int[2]);
            add(turner);

        }
    }


    // ----------------------------------------------------------
    /**
     * Helper method to add lines and clean up initialize().
     */
    public void addLines()
    {
        ShapeFilter<TicLine> old = getShapes().withClass(TicLine.class);
        for (TicLine oldLine : old)
        {
            oldLine.remove();
        }
        boardSize = Math.min(getWidth(), getHeight());
        largeCellSize = boardSize / 3.0f;
        add(new TicLine(0, largeCellSize, boardSize, largeCellSize));
        add(new TicLine(
            0,
            2.0f * largeCellSize,
            boardSize,
            2.0f * largeCellSize));
        add(new TicLine(largeCellSize, 0, largeCellSize, boardSize));
        add(new TicLine(
            2.0f * largeCellSize,
            0,
            2.0f * largeCellSize,
            boardSize));
    }


    // ----------------------------------------------------------
    /**
     * Event handler for when the screen is pressed.
     *
     * @param x
     *            the x coordinate of the touch.
     * @param y
     *            the y coordinate of the touch.
     */
    public void onTouchDown(float x, float y)
    {
        processTouch(x, y);
    }


    // ----------------------------------------------------------
    /**
     * Processes the touch of a position.
     *
     * @param x
     *            x position
     * @param y
     *            y position
     */
    public void processTouch(float x, float y)
    {
        BoardTile tile =
            getShapes().locatedAt(x, y).withClass(BoardTile.class).front();
        if (tile != null && tile.getType().equals(GamePiece.BLANK)
            && tile.isValid())
        {
            board.makeMove(tile);
            if (board.hasWon(turner.getType()))
            {
                displayGameWonMessage();
                SplashScreen.setBoard(new BigBoard());
                return;
            }
            turner.setType(board.turner().getTurn());
        }
    }


    // ----------------------------------------------------------
    /**
     * Displays that a game is won
     */
    public void displayGameWonMessage()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over!").setMessage("The game has been won!")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface inter, int which)
                {
                    GameScreen.this.finish();
                }
            }).setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }


    // ----------------------------------------------------------
    /**
     * Returns the BigBoard object that is being used
     *
     * @return the BigBoard that is being used
     */
    public BigBoard getBigBoard()
    {
        return board;
    }


    // ----------------------------------------------------------
    /**
     * Sets the board to a state
     *
     * @param board
     *            Board state
     */
    public void setBigBoard(BigBoard board)
    {
        SplashScreen.setBoard(board);
        initialize();
    }

}
