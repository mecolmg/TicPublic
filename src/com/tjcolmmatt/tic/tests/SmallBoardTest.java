package com.tjcolmmatt.tic.tests;

import com.tjcolmmatt.tic.BoardData.BoardTile;
import com.tjcolmmatt.tic.BoardData.GamePiece;
import com.tjcolmmatt.tic.BoardData.SmallBoard;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for SmallBoard
 *
 * @author TJ Corley (tjcorley)
 * @author Colm Gallagher (mecolmg)
 * @version Dec 3, 2014
 */

public class SmallBoardTest
    extends TestCase
{

    private SmallBoard board;


    // ----------------------------------------------------------
    /**
     * Sets up the SmallBoard object that we are testing
     */
    @Override
    protected void setUp()
        throws Exception
    {
        board = new SmallBoard();
        super.setUp();
    }


    // ----------------------------------------------------------
    /**
     * tests the getCell method
     */
    public void testGetandSetCell()
    {
        assertEquals(GamePiece.BLANK, board.getCell(0, 0).getType());
        board.setCellType(0, 0, GamePiece.X);
        assertEquals(GamePiece.X, board.getCell(0, 0).getType());
        board.setCellType(0, 0, GamePiece.O);
        assertEquals(GamePiece.O, board.getCell(0, 0).getType());
    }


    // ----------------------------------------------------------
    /**
     * Tests the hasWon method
     */
    public void testHasWon()
    {
        assertEquals(false, board.hasWon(GamePiece.X));

        board.setCellType(0, 0, GamePiece.X);
        board.setCellType(0, 1, GamePiece.X);
        board.setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(true, board.hasWon(GamePiece.X));

        board = new SmallBoard();

        board.setCellType(0, 0, GamePiece.O);
        board.setCellType(1, 0, GamePiece.O);
        board.setCellType(2, 0, GamePiece.O);
        assertEquals(false, board.hasWon(GamePiece.X));
        assertEquals(true, board.hasWon(GamePiece.O));

        board = new SmallBoard();

        board.setCellType(0, 0, GamePiece.O);
        board.setCellType(1, 1, GamePiece.O);
        board.setCellType(2, 2, GamePiece.O);
        assertEquals(false, board.hasWon(GamePiece.X));
        assertEquals(true, board.hasWon(GamePiece.O));

        board = new SmallBoard();

        board.setCellType(2, 0, GamePiece.O);
        board.setCellType(1, 1, GamePiece.O);
        board.setCellType(0, 2, GamePiece.O);
        assertEquals(false, board.hasWon(GamePiece.X));
        assertEquals(true, board.hasWon(GamePiece.O));

    }


    // ----------------------------------------------------------
    /**
     * tests the getCellType method
     */
    public void testGetCellType()
    {
        board.setCellType(0, 0, GamePiece.X);
        assertEquals(GamePiece.X, board.getCellType(0, 0));
    }


    // ----------------------------------------------------------
    /**
     * Tests the setCellType method
     */
    public void testSetCellType()
    {
        board.setCellType(0, 0, GamePiece.X);
        assertEquals(GamePiece.X, board.getCellType(0, 0));

        board.setCellType(2, 0, GamePiece.O);
        board.setCellType(1, 1, GamePiece.O);
        board.setCellType(0, 2, GamePiece.O);

        assertEquals(GamePiece.O, board.getCellType(0, 2));

        board.setCellType(1, 0, GamePiece.X);
        board.setCellType(1, 1, GamePiece.X);
        board.setCellType(1, 2, GamePiece.X);

        assertEquals(false, board.hasWon(GamePiece.X));
    }


    // ----------------------------------------------------------
    /**
     * Tests isEmpty method
     */
    public void testIsEmpty()
    {
        assertEquals(true, board.isEmpty());
        board.setCellType(1, 0, GamePiece.X);
        board.setCellType(1, 1, GamePiece.X);
        board.setCellType(1, 2, GamePiece.X);
        assertEquals(false, board.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Tests the addCell() method
     */
    public void testAddCell()
    {
        BoardTile test1 = new BoardTile(GamePiece.X, 0, 0, 1, new int[4]);
        board.addCell(0, 0, test1);
        assertEquals(test1, board.getCell(0, 0));
    }
}
