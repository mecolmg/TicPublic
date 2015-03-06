package com.tjcolmmatt.tic.BoardData;

import android.graphics.RectF;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Tiles that will be used for the game.
 *
 * @author Colm Gallagher (mecolmg)
 * @author Matthew Wong (mttwong)
 * @version Dec 3, 2014
 */

public class BoardTile
    extends RectangleShape
{
    private GamePiece tile;
    private int[]     pos;
    private String    name;
    private boolean   valid;


    // ----------------------------------------------------------
    /**
     * Create a new BoardTile object.
     *
     * @param type
     *            The type of BoardTile to return
     * @param left
     *            The left position of the tile
     * @param top
     *            The top position of the tile
     * @param size
     *            Size of tile
     * @param position
     *            Position of tile
     */
    public BoardTile(
        GamePiece type,
        float left,
        float top,
        float size,
        int[] position)
    {
        super(left, top, left + size, top + size);
        pos = position;
        tile = type;
        valid = true;
        refreshImage();
    }


    // ----------------------------------------------------------
    /**
     * Refreshes the image of a tile
     */
    public void refreshImage()
    {
        System.out.println("Switch");
        switch (tile)
        {
            case BLANK:
                name = "_";
                if (!valid)
                {
                    this.setImage("invalid");
                }
                else
                {
                    this.setImage("blank");
                }
                break;
            case O:
                name = "O";
                if (!valid)
                {
                    this.setImage("invalido");
                }
                else
                {
                    this.setImage("o");
                }
                break;
            case X:
                name = "X";
                if (!valid)
                {
                    this.setImage("invalidx");
                }
                else
                {
                    this.setImage("x");
                }
                break;
            default:
                name = "_";
                this.setImage("invalid");
                break;
        }
    }


    // ----------------------------------------------------------
    /**
     * Changes the type of tile
     *
     * @param type
     */
    public void setType(GamePiece type)
    {
        tile = type;
        refreshImage();
    }


    // ----------------------------------------------------------
    /**
     * Returns the position int the form [bigI, bigJ, smallI, smallJ]
     *
     * @return position
     */
    public int[] getPos()
    {
        return pos;
    }


    // ----------------------------------------------------------
    /**
     * Sets the position
     *
     * @param newPos
     *            Position
     */
    public void setPos(int[] newPos)
    {
        pos = newPos;
    }


    // ----------------------------------------------------------
    /**
     * Gets the type of tile
     *
     * @return The type
     */
    public GamePiece getType()
    {
        return tile;
    }


    /**
     * Returns the type of tile
     *
     * @return String tile
     */
    @Override
    public String toString()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Resizes/repositions the covers
     *
     * @param left
     *            Left position
     * @param top
     *            Top position
     * @param size
     *            New size
     */
    public void resize(float left, float top, float size)
    {
        this.setBounds(new RectF(left, top, left + size, top + size));
    }


    // ----------------------------------------------------------
    /**
     * Makes the tile invalid
     */
    public void invalidate()
    {
        valid = false;
        refreshImage();
    }


    // ----------------------------------------------------------
    /**
     * Makes the tile valid
     */
    public void validate()
    {
        valid = true;
        refreshImage();
    }


    // ----------------------------------------------------------
    /**
     * Returns if the tile is valid
     *
     * @return True if the tile is valid
     */
    public boolean isValid()
    {
        return valid;
    }
}
