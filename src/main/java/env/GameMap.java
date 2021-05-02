package env;

public final class GameMap {
    private static final char[][] map = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };

    /**
     * The Minimum value of the x-coordinate of the map that sprite objects can exist.
     */
    public static final int XMIN = 1;
    /**
     * The maximum value of the x-coordinate of the map that sprite objects can exist.
     */
    public static final int XMAX = map[0].length - 2;
    /**
     * The Minimum value of the y-coordinate of the map that sprite objects can exist.
     */
    public static final int YMIN = 1;
    /**
     * The maximum value of the y-coordinate of the map that sprite objects can exist.
     */
    public static final int YMAX = map.length - 2;

    /**
     * Draw a map with sprite objects on the console.
     *
     * @param sprites Objects of one or more sprite types.
     */
    public static void drawMapWith(Sprite... sprites) {
        if (sprites.length != 0) {
            for (var sprite : sprites) {
                int x = sprite.getX();
                int y = sprite.getY();
                map[y][x] = sprite.getIcon();
            }
        }
        drawMap();
    }

    private static void drawMap() {
        for (var line : map) {
            for (int i = 0; i < line.length; i++) {
                System.out.print(line[i]);
                if (line[i] != ' ' && line[i] != '#') {
                    line[i] = ' ';
                }
            }
            System.out.println();
        }
    }

}
