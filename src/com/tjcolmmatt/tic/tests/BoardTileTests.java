package com.tjcolmmatt.tic.tests;

import com.tjcolmmatt.tic.BoardData.BoardTile;
import com.tjcolmmatt.tic.BoardData.GamePiece;
import java.util.Arrays;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the BoardTile tests.
 *
 * @author TJ Corley (tjcorley)
 * @version Dec 3, 2014
 */

public class BoardTileTests
    extends TestCase
{

    private BoardTile tile;


    // ----------------------------------------------------------
    /*
     * Sets up the class for testing
     */
    @Override
    protected void setUp()
        throws Exception
    {
        tile = new BoardTile(GamePiece.X, 0, 0, 10, new int[] { 0, 0, 0, 0 });
        super.setUp();
    }


    // ----------------------------------------------------------
    /**
     * tests the setType method
     */
    public void testSetType()
    {
        tile.setType(GamePiece.O);
        assertEquals(GamePiece.O, tile.getType());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getPos method.
     */
    public void testGetPos()
    {

        assertEquals(
            true,
            Arrays.equals(new int[] { 0, 0, 0, 0 }, tile.getPos()));
    }


    // ----------------------------------------------------------
    /**
     * tests the setPos method
     */
    public void testSetPos()
    {
        tile.setPos(new int[] { 0, 0, 1, 1 });
        assertEquals(
            true,
            Arrays.equals(new int[] { 0, 0, 1, 1 }, tile.getPos()));
    }


    // ----------------------------------------------------------
    /**
     * tests the getType method
     */
    public void testGetType()
    {
        assertEquals(GamePiece.X, tile.getType());
    }


    // ----------------------------------------------------------
    /**
     * tests the toString method
     */
    public void testToString()
    {
        assertEquals("X", tile.toString());
    }


    // ----------------------------------------------------------
    /**
     * tests the resize method
     */
    public void testResize()
    {
        tile.resize(5, 5, 90);
        assertEquals(5.0, tile.getTop(), .1);
        assertEquals(5.0, tile.getLeft(), .1);
    }


    // ----------------------------------------------------------
    /**
     * tests the invalidate method
     */
    public void testInvalidate()
    {
        tile.invalidate();
        assertEquals(false, tile.isValid());
    }


    // ----------------------------------------------------------
    /**
     * tests the validate method
     */
    public void testValidate()
    {
        tile.invalidate();
        assertEquals(false, tile.isValid());
        tile.validate();
        assertEquals(true, tile.isValid());
    }

}
