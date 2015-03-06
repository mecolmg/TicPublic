package com.tjcolmmatt.tic.BoardData;

import android.graphics.RectF;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Cover to shadow who won.
 *
 * @author Colm Gallagher (mecolmg)
 * @version Dec 3, 2014
 */

public class WinCover
    extends RectangleShape
{
    private GamePiece tile;


    // ----------------------------------------------------------
    /**
     * Create a new WinCover object.
     *
     * @param type
     *            The type of BoardTile to return
     * @param left
     *            The left position of the tile
     * @param top
     *            The top position of the tile
     * @param size
     *            Size of tile
     */
    public WinCover(GamePiece type, float left, float top, float size)
    {
        super(left, top, left + size, top + size);
        tile = type;
        refreshImage();
    }


    // ----------------------------------------------------------
    /**
     * Refreshes the image
     */
    public void refreshImage()
    {
        switch (tile)
        {
            case X:
                this.setImage("redwon");
                this.setVisible(true);
                break;
            case O:
                this.setImage("bluewon");
                this.setVisible(true);
                break;
            default:
                this.setVisible(false);
                break;
        }
    }


    // ----------------------------------------------------------
    /**
     * Sets the type of tile
     *
     * @param type
     *            New type of tile
     */
    public void setType(GamePiece type)
    {
        tile = type;
        refreshImage();
    }


    // ----------------------------------------------------------
    /**
     * Returns the type of cover
     *
     * @return Type of cover
     */
    public GamePiece getType()
    {
        return tile;
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
}
