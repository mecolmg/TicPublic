package com.tjcolmmatt.tic.BoardData;

// -------------------------------------------------------------------------
/**
 * The tiles for the small tic-tac-toe boards.
 *
 * @author Matthew Wong (mttwong)
 * @author Colm Gallagher (mecolmg)
 * @version Dec 3, 2014
 */
public class SmallBoard
{
    // === Instance Variables ===

    private BoardTile[][] tiles;
    private GamePiece     winner;


    // === Constructor ===

    // ----------------------------------------------------------
    /**
     * Create a new SmallBoard object.
     */
    public SmallBoard()
    {
        winner = null;
        tiles = new BoardTile[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                tiles[i][j] =
                    new BoardTile(GamePiece.BLANK, 0, 0, 0, new int[4]);
            }
        }
    }


    // === Methods ===

    // ----------------------------------------------------------
    /**
     * Set the (row,column) cell to the value specified.
     *
     * @param row
     *            the row of the cell.
     * @param column
     *            the column of the cell.
     * @param type
     *            the value to set the cell to.
     */
    public void setCellType(int row, int column, GamePiece type)
    {
        tiles[row][column].setType(type);

        if (checkWin(type) && winner == null)
        {
            winner = type;
        }
    }


    private boolean checkWin(GamePiece player)
    {
        for (int row = 0; row < 3; row++)
        {
            if (getCellType(row, 0).equals(player)
                && getCellType(row, 1).equals(player)
                && getCellType(row, 2).equals(player))
            {
                return true;
            }
        }
        for (int col = 0; col < 3; col++)
        {
            if (getCellType(0, col).equals(player)
                && getCellType(1, col).equals(player)
                && getCellType(2, col).equals(player))
            {
                return true;
            }
        }
        if (getCellType(0, 0).equals(player)
            && getCellType(1, 1).equals(player)
            && getCellType(2, 2).equals(player))
        {
            return true;
        }
        if (getCellType(0, 2).equals(player)
            && getCellType(1, 1).equals(player)
            && getCellType(2, 0).equals(player))
        {
            return true;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Adds the tile at (row,column).
     *
     * @param row
     *            The row
     * @param column
     *            The column
     * @param tile
     *            The tile
     */
    public void addCell(int row, int column, BoardTile tile)
    {
        tiles[row][column] = tile;
    }


    // ----------------------------------------------------------
    /**
     * Return the tile at (row,column).
     *
     * @param row
     *            the row of the cell.
     * @param column
     *            the column of the cell.
     * @return BoardTile at row, column.
     */
    public BoardTile getCell(int row, int column)
    {
        return tiles[row][column];
    }


    // ----------------------------------------------------------
    /**
     * Return the state of the cell at (row,column).
     *
     * @param row
     *            the row of the cell.
     * @param column
     *            the column of the cell.
     * @return State at row, column.
     */
    public GamePiece getCellType(int row, int column)
    {
        return tiles[row][column].getType();
    }


    // ----------------------------------------------------------
    /**
     * Check to see if the player has won the small board.
     *
     * @param player
     *            the player in question.
     * @return true if the player has won, false otherwise.
     */
    public boolean hasWon(GamePiece player)
    {
        return winner == player;
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
                if (!tiles[i][j].getType().equals(GamePiece.BLANK))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
