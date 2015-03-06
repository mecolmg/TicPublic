package com.tjcolmmatt.tic.tests;

import com.tjcolmmatt.tic.BoardData.GamePiece;
import com.tjcolmmatt.tic.BoardData.WinCover;
import junit.framework.TestCase;
import sofia.graphics.Image;

// -------------------------------------------------------------------------
/**
 * Test cases for WinCover
 *
 * @author TJ Corley (tjcorley)
 * @version Dec 3, 2014
 */

public class WinCoverTest
    extends TestCase
{

    private WinCover cover;


    // ----------------------------------------------------------
    /**
     * Sets up the BigBoard object for the rest of the tests
     */
    @Override
    protected void setUp()
        throws Exception
    {
        cover = new WinCover(GamePiece.X, 0, 0, 5);
        super.setUp();
    }


    // ----------------------------------------------------------
    /**
     * tests the refreshImage method
     */
    public void testRefreshImage()
    {
        Image orig = cover.getImage();
        cover.setType(GamePiece.O);
        cover.refreshImage();
        assertEquals(false, orig.equals(cover.getImage()));
    }


    // ----------------------------------------------------------
    /**
     * tests setType method
     */
    public void testSetType()
    {
        cover.setType(GamePiece.O);
        assertEquals(GamePiece.O, cover.getType());
    }


    // ----------------------------------------------------------
    /**
     * tests getType method
     */
    public void testGetType()
    {
        assertEquals(GamePiece.X, cover.getType());
    }


    // ----------------------------------------------------------
    /**
     * tests the resize method
     */
    public void testResize()
    {
        cover.resize(5, 5, 90);
        assertEquals(5.0, cover.getTop(), .1);
        assertEquals(5.0, cover.getLeft(), .1);
    }

}
