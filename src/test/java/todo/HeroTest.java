package todo;

import env.GameMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {
    static Hero hero;
    static char icon;

    @BeforeAll
    static void setUp() {
        icon = '@';
        hero = new Hero(icon);
    }

    @Test
    void Should_Be_At_Starting_When_Created() {
        assertEquals(GameMap.XMIN, hero.getX());
        assertEquals(GameMap.YMIN, hero.getY());
    }

    @Test
    void Should_Set_Icon_When_Created() {
        assertEquals(icon, hero.getIcon());
    }

    @Nested
    class HeroMovingTest {
        int beforeX, beforeY;

        @BeforeEach
        void setUpBeforeCoordinate() {
            hero.setY(3);
            hero.setX(3);
            beforeX = hero.getX();
            beforeY = hero.getY();
        }

        @Test
        void Should_MoveUp_When_Command_Is_Up() {
            hero.move('w');
            assertEquals(beforeY - 1, hero.getY());
            assertEquals(beforeX, hero.getX());
        }

        @Test
        void Should_MoveDown_When_Command_Is_Down() {
            hero.move('s');
            assertEquals(beforeY + 1, hero.getY());
            assertEquals(beforeX, hero.getX());
        }

        @Test
        void Should_MoveLeft_When_Command_Is_Left() {
            hero.move('a');
            assertEquals(beforeX - 1, hero.getX());
            assertEquals(beforeY, hero.getY());
        }

        @Test
        void Should_MoveRight_When_Command_Is_Right() {
            hero.move('d');
            assertEquals(beforeX + 1, hero.getX());
            assertEquals(beforeY, hero.getY());
        }

        @Test
        void Should_Not_Move_When_Command_Is_Up_And_In_Top() {
            hero.setY(GameMap.YMIN);
            hero.move('w');
            assertEquals(GameMap.YMIN, hero.getY());
            assertEquals(beforeX, hero.getX());
        }

        @Test
        void Should_Not_Move_When_Command_Is_Down_And_In_Bottom() {
            hero.setY(GameMap.YMAX);
            hero.move('s');
            assertEquals(GameMap.YMAX, hero.getY());
            assertEquals(beforeX, hero.getX());
        }

        @Test
        void Should_Not_Move_When_Command_Is_Up_And_In_LeftEnd() {
            hero.setX(GameMap.XMIN);
            hero.move('a');
            assertEquals(GameMap.XMIN, hero.getX());
            assertEquals(beforeY, hero.getY());
        }

        @Test
        void Should_Not_Move_When_Command_Is_Up_And_In_RightEnd() {
            hero.setX(GameMap.XMAX);
            hero.move('d');
            assertEquals(GameMap.XMAX, hero.getX());
            assertEquals(beforeY, hero.getY());
        }
    }
}