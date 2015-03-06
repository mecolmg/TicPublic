package com.tjcolmmatt.tic.tests;

import com.tjcolmmatt.tic.BoardData.GamePiece;
import com.tjcolmmatt.tic.BoardData.Turner;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for the Turner class
 * 
 * @author Colm Gallagher (mecolmg)
 * @version Dec 3, 2014
 */

public class TurnerTest
    extends TestCase
{
    private Turner test1;


    // ----------------------------------------------------------
    /**
     * Sets up the Turner object that we are testing
     */
    @Override
    protected void setUp()
        throws Exception
    {
        test1 = new Turner(GamePiece.X);
        super.setUp();
    }


    /**
     * Test method for {@link com.tjcolmmatt.tic.BoardData.Turner#getTurn()}.
     */
    public void testGetTurn()
    {
        assertEquals(GamePiece.X, test1.getTurn());
        test1.switchTurns();
        assertEquals(GamePiece.O, test1.getTurn());
    }


    /**
     * Test method for
     * {@link com.tjcolmmatt.tic.BoardData.Turner#setTurn(com.tjcolmmatt.tic.BoardData.GamePiece)}
     * .
     */
    public void testSetTurn()
    {
        assertEquals(GamePiece.X, test1.getTurn());
        test1.setTurn(GamePiece.O);
        assertEquals(GamePiece.O, test1.getTurn());
    }
}
