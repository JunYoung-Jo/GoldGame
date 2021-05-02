package env;

/**
 * Do not modify this class.
 */
public class Sprite {
    /**
     * Sprite's x coordinates.
     */
    protected int x;
    /**
     * Sprite's y coordinates.
     */
    protected int y;
    /**
     * Sprite's icon.
     */
    protected char icon;

    /**
     *
     * Important!!<br>
     * Sprite objects cannot move out of bounds.<br>
     * this method should use GameMap::YMAX, YMIN, ....<br>
     *
     * @param command 'a' moves the sprite to the left, 'd' moves the sprite to the right.<br>
     *                'w' moves the sprite up, 's' moves the sprite down.
     */
    public void moveAccordingTo(char command) {
        // do nothing here.
    }

    /**
     * @return Returns the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @return Returns the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * @return Returns the character's icon.
     */
    public char getIcon() {
        return icon;
    }
}
