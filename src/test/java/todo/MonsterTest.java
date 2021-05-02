package todo;

import env.GameMap;
import env.Sprite;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MonsterTest {

    static Sprite monster;

    @BeforeAll
    static void setUp() {
        monster = new Monster();
    }

    @Test
    void Should_Be_At_Starting_When_Created() {
        assertEquals(GameMap.XMAX, monster.getX());
        assertEquals(GameMap.YMAX, monster.getY());
    }

    @Test
    void Should_Set_Icon_When_Created() {
        assertEquals('M', monster.getIcon());
    }

    @Nested
    class MonsterMovingTest {
        int beforeX, beforeY;

        @BeforeEach
        void setUpBeforeCoordinate() {
            beforeX = monster.getX();
            beforeY = monster.getY();
        }

        @Test
        void Should_Move_RightAndLeft_When_Command_Is_UpDown() {
            monster.move('w');
            assertEquals(beforeY, monster.getY());
            assertNotEquals(beforeX, monster.getX());

            beforeX = monster.getX();
            monster.move('s');
            assertEquals(beforeY, monster.getY());
            assertNotEquals(beforeX, monster.getX());
        }

        @Test
        void Should_Move_UpAndDown_When_Command_Is_LeftRight() {
            monster.move('a');
            assertEquals(beforeX, monster.getX());
            assertNotEquals(beforeY, monster.getY());

            beforeY = monster.getY();
            monster.move('d');
            assertEquals(beforeX, monster.getX());
            assertNotEquals(beforeY, monster.getY());
        }

        @Test
        void Should_Move_Left_When_Command_Is_UpDown_And_In_RightEnd() {
            monster.setX(GameMap.XMAX);
            monster.move('w');
            assertEquals(GameMap.XMAX - 1, monster.getX());
            assertEquals(beforeY, monster.getY());

            monster.setX(GameMap.XMAX);
            monster.move('s');
            assertEquals(GameMap.XMAX - 1, monster.getX());
            assertEquals(beforeY, monster.getY());
        }

        @Test
        void Should_Move_Right_When_Command_Is_UpDown_And_In_LeftEnd() {
            monster.setX(GameMap.XMIN);
            monster.move('w');
            assertEquals(GameMap.XMIN + 1, monster.getX());
            assertEquals(beforeY, monster.getY());

            monster.setX(GameMap.XMIN);
            monster.move('s');
            assertEquals(GameMap.XMIN + 1, monster.getX());
            assertEquals(beforeY, monster.getY());
        }

        @Test
        void Should_Move_Up_When_Command_Is_LeftRight_And_In_Bottom() {
            monster.setY(GameMap.YMAX);
            monster.move('a');
            assertEquals(GameMap.YMAX - 1, monster.getY());
            assertEquals(beforeX, monster.getX());

            monster.setY(GameMap.YMAX);
            monster.move('d');
            assertEquals(GameMap.YMAX - 1, monster.getY());
            assertEquals(beforeX, monster.getX());
        }

        @Test
        void Should_Move_Down_When_Command_Is_LeftRight_And_In_Up() {
            monster.setY(GameMap.YMIN);
            monster.move('a');
            assertEquals(GameMap.YMIN + 1, monster.getY());
            assertEquals(beforeX, monster.getX());

            monster.setY(GameMap.YMIN);
            monster.move('d');
            assertEquals(GameMap.YMIN + 1, monster.getY());
            assertEquals(beforeX, monster.getX());
        }
    }
}