package com.tjcolmmatt.tic.tests;

import com.tjcolmmatt.tic.BoardData.BigBoard;
import com.tjcolmmatt.tic.BoardData.BoardTile;
import com.tjcolmmatt.tic.BoardData.GamePiece;
import com.tjcolmmatt.tic.BoardData.SmallBoard;
import com.tjcolmmatt.tic.BoardData.WinCover;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for BigBoard
 *
 * @author TJ Corley (tjcorley)
 * @version Dec 3, 2014
 */

public class BigBoardTest
    extends TestCase
{

    private BigBoard board;


    // ----------------------------------------------------------
    /**
     * Sets up the BigBoard object for the rest of the tests
     */
    @Override
    protected void setUp()
        throws Exception
    {
        board = new BigBoard();
        super.setUp();
    }


    // ----------------------------------------------------------
    /**
     * tests the selectBoard method
     */
    public void testSelectBoard()
    {
        SmallBoard sBoard = board.getBoard(0, 0);
        sBoard.setCellType(0, 0, GamePiece.X);
        assertEquals(sBoard, board.getBoard(0, 0));
    }


    // ----------------------------------------------------------
    /**
     * tests the getBoard method
     */
    public void testGetBoard()
    {
        // Not sure what to test here...?
        SmallBoard b1 = board.getBoard(0, 0);
        SmallBoard b2 = board.getBoard(1, 1);
        assertNotSame(b1, b2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the hasWon method
     */
    public void testHasWon()
    {

        assertEquals(false, board.hasWon(GamePiece.X));
        assertEquals(false, board.hasWon(GamePiece.O));

        // First we are testing across a row
        board.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        board.getBoard(0, 0).setCellType(0, 1, GamePiece.X);
        board.getBoard(0, 0).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(0, 1).setCellType(0, 0, GamePiece.X);
        board.getBoard(0, 1).setCellType(0, 1, GamePiece.X);
        board.getBoard(0, 1).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(0, 2).setCellType(0, 0, GamePiece.X);
        board.getBoard(0, 2).setCellType(0, 1, GamePiece.X);
        board.getBoard(0, 2).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(true, board.hasWon(GamePiece.X));

        board = new BigBoard();

        // Now we are testing down a column
        board.getBoard(0, 0);
        board.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        board.getBoard(0, 0).setCellType(0, 1, GamePiece.X);
        board.getBoard(0, 0).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(1, 0);
        board.getBoard(1, 0).setCellType(0, 0, GamePiece.X);
        board.getBoard(1, 0).setCellType(0, 1, GamePiece.X);
        board.getBoard(1, 0).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(2, 0);
        board.getBoard(2, 0).setCellType(0, 0, GamePiece.X);
        board.getBoard(2, 0).setCellType(0, 1, GamePiece.X);
        board.getBoard(2, 0).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(true, board.hasWon(GamePiece.X));

        board = new BigBoard();

        // Now we are testing diagnol starting from the top left
        board.getBoard(0, 0);
        board.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        board.getBoard(0, 0).setCellType(0, 1, GamePiece.X);
        board.getBoard(0, 0).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(1, 1);
        board.getBoard(1, 1).setCellType(0, 0, GamePiece.X);
        board.getBoard(1, 1).setCellType(0, 1, GamePiece.X);
        board.getBoard(1, 1).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(2, 2);
        board.getBoard(2, 2).setCellType(0, 0, GamePiece.X);
        board.getBoard(2, 2).setCellType(0, 1, GamePiece.X);
        board.getBoard(2, 2).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(true, board.hasWon(GamePiece.X));

        board = new BigBoard();

        // Now we are testing diagnol starting from the top right
        board.getBoard(2, 0);
        board.getBoard(2, 0).setCellType(0, 0, GamePiece.X);
        board.getBoard(2, 0).setCellType(0, 1, GamePiece.X);
        board.getBoard(2, 0).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(1, 1);
        board.getBoard(1, 1).setCellType(0, 0, GamePiece.X);
        board.getBoard(1, 1).setCellType(0, 1, GamePiece.X);
        board.getBoard(1, 1).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(false, board.hasWon(GamePiece.X));

        board.getBoard(0, 2);
        board.getBoard(0, 2).setCellType(0, 0, GamePiece.X);
        board.getBoard(0, 2).setCellType(0, 1, GamePiece.X);
        board.getBoard(0, 2).setCellType(0, 2, GamePiece.X);
        assertEquals(false, board.hasWon(GamePiece.O));
        assertEquals(true, board.hasWon(GamePiece.X));

    }


    // ----------------------------------------------------------
    /**
     * Test getCellType method
     */
    public void testGetCellType()
    {
        assertEquals(GamePiece.BLANK, board.getCellType(0, 0, 0, 0));
        board.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        assertEquals(GamePiece.X, board.getCellType(0, 0, 0, 0));
    }


    // ----------------------------------------------------------
    /**
     * Test getCell method
     */
    public void testGetCell()
    {
        assertEquals(GamePiece.BLANK, board.getCell(0, 0, 0, 0).getType());
        board.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        assertEquals(GamePiece.X, board.getCell(0, 0, 0, 0).getType());
    }


    // ----------------------------------------------------------
    /**
     * tests the isEmpty method
     */
    public void testIsEmpty()
    {
        assertEquals(true, board.isEmpty());
        board.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        assertEquals(false, board.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * tests the invalidate method
     */
    public void testInvalidate()
    {
        board.invalidate(0, 0, 2, 2);
        assertEquals(true, board.getCell(0, 0, 0, 0).isValid());
        assertEquals(false, board.getCell(2, 2, 2, 2).isValid());
        board.invalidate(2, 2, 0, 0);
        assertEquals(false, board.getCell(0, 0, 0, 0).isValid());
        assertEquals(true, board.getCell(2, 2, 2, 2).isValid());
    }


    // ----------------------------------------------------------
    /**
     * tests the makemove method
     */
    public void testMakeMove()
    {
        WinCover[][] covers = board.getCovers();
        covers[0][0] = new WinCover(GamePiece.BLANK, 0, 10, 4 * 3.0f);
        covers[1][1] = new WinCover(GamePiece.BLANK, 0, 10, 4 * 3.0f);

        board.makeMove(new BoardTile(GamePiece.X, 90, 100, 50, new int[] { 0,
            0, 0, 0 }));
        assertEquals(false, board.getCell(0, 0, 0, 0).isValid());
        board.makeMove(new BoardTile(GamePiece.X, 90, 100, 50, new int[] { 1,
            1, 0, 0 }));
        assertEquals(true, board.getCell(0, 0, 0, 0).isValid());
    }

}
