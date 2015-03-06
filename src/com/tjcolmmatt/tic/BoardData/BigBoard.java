package com.tjcolmmatt.tic.BoardData;

// -------------------------------------------------------------------------
/**
 * The data for the big tic-tac-toe board.
 *
 * @author Matthew Wong (mttwong)
 * @author Colm Gallagher (mecolmg)
 * @version Dec 3, 2014
 */
public class BigBoard
{
    // === Instance Variables ===

    private SmallBoard[][] smallBoards;
    private Turner         turner;
    private WinCover[][]   covers;


    // === Constructor ===

    // ----------------------------------------------------------
    /**
     * Create a new BigBoard object.
     */
    public BigBoard()
    {
        smallBoards = new SmallBoard[3][3];
        turner = new Turner();
        covers = new WinCover[3][3];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                smallBoards[i][j] = new SmallBoard();
            }
        }
    }


    // === Methods ===

    // ----------------------------------------------------------
    /**
     * Return the small board at (row,column).
     *
     * @param row
     *            the row of the board.
     * @param column
     *            the column of the board.
     * @return the board at (row,column).
     */
    public SmallBoard getBoard(int row, int column)
    {
        return smallBoards[row][column];
    }


    // ----------------------------------------------------------
    /**
     * Check to see if the player has won the game.
     *
     * @param player
     *            the player in question.
     * @return true if the player has won, false otherwise.
     */
    public boolean hasWon(GamePiece player)
    {
        for (int row = 0; row < 3; row++)
        {
            if (getBoard(row, 0).hasWon(player)
                && getBoard(row, 1).hasWon(player)
                && getBoard(row, 2).hasWon(player))
            {
                return true;
            }
        }
        for (int column = 0; column < 3; column++)
        {
            if (getBoard(0, column).hasWon(player)
                && getBoard(1, column).hasWon(player)
                && getBoard(2, column).hasWon(player))
            {
                return true;
            }
        }
        if (getBoard(0, 0).hasWon(player) && getBoard(1, 1).hasWon(player)
            && getBoard(2, 2).hasWon(player))
        {
            return true;
        }
        if (getBoard(2, 0).hasWon(player) && getBoard(1, 1).hasWon(player)
            && getBoard(0, 2).hasWon(player))
        {
            return true;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Gets the cell of a specific SmallBoard
     *
     * @param bigX
     *            X-Location of board on BigBoard
     * @param bigY
     *            Y-Location of board on BigBoard
     * @param smallX
     *            X-Location of cell on SmallBoard
     * @param smallY
     *            Y-Location of cell on SmallBoard
     * @return The gamepiece
     */
    public GamePiece getCellType(int bigX, int bigY, int smallX, int smallY)
    {
        return getBoard(bigX, bigY).getCellType(smallX, smallY);
    }


    // ----------------------------------------------------------
    /**
     * Gets the cell of a specific SmallBoard
     *
     * @param bigX
     *            X-Location of board on BigBoard
     * @param bigY
     *            Y-Location of board on BigBoard
     * @param smallX
     *            X-Location of cell on SmallBoard
     * @param smallY
     *            Y-Location of cell on SmallBoard
     * @return The tile
     */
    public BoardTile getCell(int bigX, int bigY, int smallX, int smallY)
    {
        return getBoard(bigX, bigY).getCell(smallX, smallY);
    }


    // ----------------------------------------------------------
    /**
     * Returns if the board is empty
     *
     * @return Whether the board is empty or not
     */
    public boolean isEmpty()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (!smallBoards[i][j].isEmpty())
                {
                    return false;
                }
            }
        }
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Returns the turner
     *
     * @return The turner
     */
    public Turner turner()
    {
        return turner;
    }


    // ----------------------------------------------------------
    /**
     * Invalidates the tiles that need to be invalidated
     *
     * @param keepI
     *            Tiles to keep
     * @param keepJ
     *            Tiles to keep
     * @param oldI
     *            Tile to block
     * @param oldJ
     *            Tile to block
     */
    public void invalidate(int keepI, int keepJ, int oldI, int oldJ)
    {
        for (int bigI = 0; bigI < 3; bigI++)
        {
            for (int bigJ = 0; bigJ < 3; bigJ++)
            {
                for (int smallI = 0; smallI < 3; smallI++)
                {
                    for (int smallJ = 0; smallJ < 3; smallJ++)
                    {
                        BoardTile tile = getCell(bigI, bigJ, smallI, smallJ);
                        if (!(bigI == keepI && bigJ == keepJ))
                        {
                            tile.invalidate();
                        }
                        else if (smallI == oldI && smallJ == oldJ)
                        {
                            tile.invalidate();
                        }
                        else
                        {
                            tile.validate();
                        }
                    }
                }
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Gets the covers
     *
     * @return the covers
     */
    public WinCover[][] getCovers()
    {
        return covers;
    }


    // ----------------------------------------------------------
    /**
     * Makes a move at a given spot
     *
     * @param tile
     *            Spot
     */
    public void makeMove(BoardTile tile)
    {
        GamePiece current = turner().getTurn();
        int[] pos = tile.getPos();

        getBoard(pos[0], pos[1]).setCellType(pos[2], pos[3], current);

        if (covers[pos[0]][pos[1]].getType().equals(GamePiece.BLANK)
            && getBoard(pos[0], pos[1]).hasWon(current))
        {
            covers[pos[0]][pos[1]].setType(current);
        }

        invalidate(pos[2], pos[3], pos[0], pos[1]);
        turner.switchTurns();
    }

}
