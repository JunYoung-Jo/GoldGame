package todo;

import env.GameMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldTest {
    static Gold gold;

    @BeforeAll
    static void setUp() {
        gold = new Gold();
    }

    @Test
    void Should_Be_In_Middle_Of_Y_When_Created() {
        assertEquals((GameMap.YMAX / 2), gold.getY());
        assertTrue(gold.getX() > GameMap.XMIN && gold.getX() < GameMap.XMAX);
    }

    @Test
    void Should_Set_Icon_When_Created() {
        assertEquals('G', gold.getIcon());
    }

    @Nested
    class GoldMovingTest {
        int beforeX, beforeY;

        @BeforeEach
        void setUpBeforeCoordinate() {
            beforeX = gold.getX();
            beforeY = gold.getY();
        }

        @Test
        void Should_Move_RightAndLeft_When_Command_Is_UpDown() {
            gold.move('w');
            assertEquals(beforeY, gold.getY());
            assertNotEquals(beforeX, gold.getX());

            beforeX = gold.getX();
            gold.move('s');
            assertEquals(beforeY, gold.getY());
            assertNotEquals(beforeX, gold.getX());
        }

        @Test
        void Should_Not_Move_When_Command_Is_LeftRight() {
            gold.move('a');
            assertEquals(beforeX, gold.getX());
            assertEquals(beforeY, gold.getY());

            gold.move('d');
            assertEquals(beforeX, gold.getX());
            assertEquals(beforeY, gold.getY());
        }

        @Test
        void Should_Move_Right_When_LeftEdge() {
            gold.setX(GameMap.XMIN);
            gold.move('w');
            assertEquals(GameMap.XMIN + 1, gold.getX());

            gold.setX(GameMap.XMIN);
            gold.move('s');
            assertEquals(GameMap.XMIN + 1, gold.getX());
        }

        @Test
        void Should_Move_Left_When_In_RightEdge() {
            gold.setX(GameMap.XMAX);
            gold.move('w');
            assertEquals(GameMap.XMAX - 1, gold.getX());

            gold.setX(GameMap.XMAX);
            gold.move('s');
            assertEquals(GameMap.XMAX - 1, gold.getX());
        }
    }
}
