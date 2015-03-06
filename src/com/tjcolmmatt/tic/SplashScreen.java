package com.tjcolmmatt.tic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import com.tjcolmmatt.tic.BoardData.BigBoard;
import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 * The splash screen that the application launches into.
 *
 * @author Matthew Wong (mttwong)
 * @author TJ Corley (tjcorley)
 * @author Colm Gallagher (mecolmg)
 * @version Dec 3, 2014
 */
public class SplashScreen
    extends Screen
{
    private Button          newGame;
    private static BigBoard board;


    /**
     * Initializes the screen
     */
    @Override
    public void initialize()
    {
        setBoard(new BigBoard());
        System.out.println("SplashScreen Started!");
    }


    // ----------------------------------------------------------
    /**
     * Event handling for when the twoPlayer button is clicked
     */
    public void twoPlayerClicked()
    {
        presentScreen(GameScreen.class);
        newGame.setVisibility(View.VISIBLE);
    }


    // ----------------------------------------------------------
    /**
     * Event handling for when the onePlayer button is clicked
     */
    public void onePlayerClicked()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Not Quite There Yet...").setMessage(
            "Trust us, it is on our to-do list, but we have "
                + "to get the game up and running smoothly before "
                + "we can even think about programming a computer player.");
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    // ----------------------------------------------------------
    /**
     * Returns the board
     *
     * @return the board
     */
    public static BigBoard getBoard()
    {
        return board;
    }


    // ----------------------------------------------------------
    /**
     * Sets the board
     *
     * @param board
     *            the board to set
     */
    public static void setBoard(BigBoard board)
    {
        SplashScreen.board = board;
    }


    // ----------------------------------------------------------
    /**
     * Resets the board when New Game is clicked
     */
    public void newGameClicked()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Start A New Game?")
            .setMessage("This will delete data from the current game.")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface inter, int which)
                {
                    setBoard(new BigBoard());
                    presentScreen(GameScreen.class);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface inter, int which)
                {
                    // Blank
                }
            }).setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
