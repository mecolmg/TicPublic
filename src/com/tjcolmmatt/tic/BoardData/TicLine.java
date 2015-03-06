package com.tjcolmmatt.tic.BoardData;

import android.graphics.RectF;
import sofia.graphics.RectangleShape;
// import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 * The line used to draw the large grid.
 *
 * @author Matthew Wong (mttwong)
 * @author Colm Gallagher(mecolmg)
 * @version Nov 22, 2014
 */
public class TicLine
    extends RectangleShape
{
    // ----------------------------------------------------------
    /**
     * Create a new ThickLineShape object.
     *
     * @param x1
     *            the x coordinate of the starting point of the line.
     * @param y1
     *            the y coordinate of the starting point of the line.
     * @param x2
     *            the x coordinate of the ending point of the line.
     * @param y2
     *            the y coordinate of the ending point of the line.
     */
    public TicLine(float x1, float y1, float x2, float y2)
    {
        super(x1, y1, x2, y2);
        if (x2 - x1 > y2 - y1)
        {
            this.setBounds(new RectF(x1, y1 - 5.0f, x2, y2 + 5.0f));
            setImage("horizontal");
        }
        else
        {
            this.setBounds(new RectF(x1 - 5.0f, y1, x2 + 5.0f, y2));
            setImage("vertical");
        }
    }
}
