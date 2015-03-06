package com.tjcolmmatt.tic.tests;

import com.tjcolmmatt.tic.GameScreen;
import com.tjcolmmatt.tic.BoardData.BigBoard;
import com.tjcolmmatt.tic.BoardData.BoardTile;
import com.tjcolmmatt.tic.BoardData.GamePiece;

// -------------------------------------------------------------------------
/**
 * Class that holds the test for the GameScreen class
 *
 * @author Colm Gallagher (mecolmg)
 * @author TJ Corley (tjcorley)
 * @version Dec 3, 2014
 */

public class GameScreenTests
    extends student.AndroidTestCase<GameScreen>
{

    // ----------------------------------------------------------
    /**
     * Create a new SplashScreenTests object.
     */
    public GameScreenTests()
    {
        super(GameScreen.class);
    }


    // ----------------------------------------------------------
    /**
     * Initializer for the tests
     */
    public void initialize()
    {
        getScreen().setBigBoard(new BigBoard());
        getScreen().addTiles();
        getScreen().addTurnDisplay();
        getScreen().addCovers();
    }


    // ----------------------------------------------------------
    /**
     * Test trying to play and invalid tile in the middle of the map
     */
    public void testPlayInvalidTile()
    {
        initialize();
        float middle = getScreen().getWidth() / 2.0f;
        getScreen().processTouch(middle, middle);
        BoardTile tile =
            getScreen().getShapes().locatedAt(middle, middle)
                .withClass(BoardTile.class).front();
        int[] pos = tile.getPos();
        GamePiece pie =
            getScreen().getBigBoard().getCellType(
                pos[0],
                pos[1],
                pos[2],
                pos[3]);
        assertFalse(tile.isValid());
        assertEquals(GamePiece.BLANK, pie);
    }


    // ----------------------------------------------------------
    /**
     * Tests playing a tile at a spot
     */
    public void testPlayTile()
    {
        initialize();
        float tileWidth = (getScreen().getWidth() - 20.0f) / 9.0f;
        float middle = getScreen().getWidth() / 2.0f;
        getScreen().processTouch(middle - tileWidth, middle - tileWidth);
        BoardTile tile =
            getScreen().getShapes()
                .locatedAt(middle - tileWidth, middle - tileWidth)
                .withClass(BoardTile.class).front();
        int[] pos = tile.getPos();
        GamePiece pie =
            getScreen().getBigBoard().getCellType(
                pos[0],
                pos[1],
                pos[2],
                pos[3]);
        getScreen().getBigBoard().turner().switchTurns();
        assertEquals(getScreen().getBigBoard().turner().getTurn(), pie);
        assertFalse(tile.isValid());
    }


    // ----------------------------------------------------------
    /**
     * Tests getBigBoard method
     */
    public void testGetBigBoard()
    {
        initialize();
        BigBoard b = new BigBoard();
        b.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        getScreen().setBigBoard(b);
        assertEquals(b, getScreen().getBigBoard());
        getScreen().addTiles();
    }


    // ----------------------------------------------------------
    /**
     * Tests setBigBoard method
     */
    public void testSetBigBoard()
    {
        initialize();
        BigBoard b = new BigBoard();
        b.getBoard(0, 0).setCellType(0, 0, GamePiece.X);
        getScreen().setBigBoard(b);
        assertEquals(b, getScreen().getBigBoard());
    }


    // ----------------------------------------------------------
    /**
     * Tests the addTiles() method
     */
    public void testAddTiles()
    {
        initialize();
        int length = getScreen().getShapes().withClass(BoardTile.class).count();
        assertEquals(82, length);
    }
}
