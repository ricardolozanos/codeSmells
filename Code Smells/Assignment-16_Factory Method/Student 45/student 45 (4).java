package balloon;

import java.awt.*;
/**
 *
 */

public class GrowingShrinkingBalloon extends GrowingBalloon{
    protected boolean hit = true;

    /**
     *
     */
    public GrowingShrinkingBalloon(){}
    /**
     * @param params inherits supers parameters from GrowingBalloon.
     */
    public GrowingShrinkingBalloon(String[] params) {
        super(params);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(color);
        g.fillOval((dim.width / 2) - (size / 2), (dim.height / 2) - (size / 2), size, size);
        if (hit) {
            grow();
        } else {
            shrink();
        }
        if (size == dim.width || size == 10) {
            hit = !hit;
        }
    }
    /**
     * Shrinks the Balloon.
     */
    public void shrink() {
        size = size - 3;
    }
    /**
     * Grows the Balloon.
     */
    public void grow() {
        size = size + 3;
    }
    /**
     *
     * @param params standard parameter for main.
     */
    public static void main(String[] params) {
        new GrowingShrinkingBalloon(params).run();
    }

}
