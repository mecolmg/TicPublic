package com.tjcolmmatt.tic.BoardData;

import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 * Handles who's turn it is.
 * 
 * @author Colm Gallagher (mecolmg)
 * @version Dec 2, 2014
 */

public class Turner
{
    private GamePiece turn;


    // ----------------------------------------------------------
    /**
     * Create a new Turner object.
     */
    public Turner()
    {
        // Represents a coin-flip for who starts
        int choose = Random.generator().nextInt(2);
        if (choose == 0)
        {
            turn = GamePiece.X;
        }
        else
        {
            turn = GamePiece.O;
        }
    }


    // ----------------------------------------------------------
    /**
     * Create a new Turner object starting with player
     * 
     * @param player
     *            First player
     */
    public Turner(GamePiece player)
    {
        this.turn = player;
    }


    // ----------------------------------------------------------
    /**
     * Returns who's turn it is.
     * 
     * @return Who's turn it is.
     */
    public GamePiece getTurn()
    {
        return turn;
    }


    // ----------------------------------------------------------
    /**
     * Set's who's turn it is.
     * 
     * @param whos
     *            Who's turn to set it to.
     */
    public void setTurn(GamePiece whos)
    {
        turn = whos;
    }


    // ----------------------------------------------------------
    /**
     * Switches turn between X and O.
     * 
     * @return New turn
     */
    public GamePiece switchTurns()
    {
        if (turn.equals(GamePiece.X))
        {
            setTurn(GamePiece.O);
        }
        else
        {
            setTurn(GamePiece.X);
        }
        return getTurn();
    }
}
