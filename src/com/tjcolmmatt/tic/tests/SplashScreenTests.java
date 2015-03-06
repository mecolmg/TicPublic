package com.tjcolmmatt.tic.tests;

import android.view.View;
import android.widget.Button;
import com.tjcolmmatt.tic.SplashScreen;

// -------------------------------------------------------------------------
/**
 * Class that holds the test for the SplashScreen class
 *
 * @author TJ Corley (tjcorley)
 * @version Dec 3, 2014
 */

public class SplashScreenTests
    extends student.AndroidTestCase<SplashScreen>
{

    private Button twoPlayer;
    private Button onePlayer;
    private Button newGame;


    // ----------------------------------------------------------
    /**
     * Create a new SplashScreenTests object.
     */
    public SplashScreenTests()
    {
        super(SplashScreen.class);
    }


    // ----------------------------------------------------------
    /**
     * Tests when the one player button is clicked
     */
    public void testOnePlayerClicked()
    {
        click(onePlayer);
        assertEquals(newGame.getVisibility(), View.GONE);

    }


    // ----------------------------------------------------------
    /**
     * Tests when the two player button is clicked
     */
    public void testTwoPlayerClicked()
    {
        assertEquals(newGame.getVisibility(), View.GONE);
        click(twoPlayer);
        assertEquals(newGame.getVisibility(), View.VISIBLE);
    }

}
