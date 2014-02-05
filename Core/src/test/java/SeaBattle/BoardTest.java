package SeaBattle;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.junit.matchers.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;



/**
 * Created by Igor on 03.02.14.
 */
public class BoardTest {
    Board board;
    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void testAddShip() throws Exception {
        assertTrue(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 5))));
        assertTrue(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 3))));
        assertFalse(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 4))));
        assertFalse(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 6))));
        assertTrue(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 8))));
        assertFalse(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(7, 3))));
        assertFalse(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(5, 6))));
    }

    @Test
    public void testIsAShip() throws Exception {
        assertTrue(board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 3))));
        assertTrue(board.isAShip(new Point(2, 3)));
        assertTrue(board.isAShip(new Point(3, 3)));
        assertFalse(board.isAShip(new Point(4, 5)));
    }

    @Test
    public void testShot() throws Exception {
        board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 3)));
        assertEquals(board.shot(new Point(2, 3)), ShotResult.HIT);
        assertEquals(board.shot(new Point(3, 3)), ShotResult.SINKED);
        assertEquals(board.shot(new Point(2, 3)), ShotResult.REPEAT);
        assertEquals(board.shot(new Point(3, 3)), ShotResult.REPEAT);
        assertEquals(board.shot(new Point(5, 3)), ShotResult.MISS);
        assertEquals(board.shot(new Point(4, 3)), ShotResult.MISS);
    }

    @Test
    public void testPlayerAddShips() throws Exception {
        Player p = new Player();
        assertTrue(p.addShip(new Ship(1, Orientation.HORIZONTAL, new Point(0, 9))));
        assertTrue(p.addShip(new Ship(1, Orientation.HORIZONTAL, new Point(1, 1))));
        assertTrue(p.addShip(new Ship(1, Orientation.HORIZONTAL, new Point(5, 8))));
        assertTrue(p.addShip(new Ship(1, Orientation.HORIZONTAL, new Point(8, 4))));

        assertTrue(p.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(5, 4))));
        assertTrue(p.addShip(new Ship(2, Orientation.VERTICAL, new Point(3, 1))));
        assertTrue(p.addShip(new Ship(2, Orientation.VERTICAL, new Point(8, 7))));

        assertTrue(p.addShip(new Ship(3, Orientation.VERTICAL, new Point(1, 5))));
        assertTrue(p.addShip(new Ship(3, Orientation.HORIZONTAL, new Point(5, 1))));

        assertTrue(p.addShip(new Ship(4, Orientation.VERTICAL, new Point(3, 4))));
        assertFalse(p.isDefeated());
    }
    @Test
    public void testDefeatBattle() {
        Player p = new Player();
        assertTrue(p.addShip(new Ship(1,Orientation.HORIZONTAL, new Point(0, 9))));
        assertTrue(p.addShip(new Ship(1,Orientation.HORIZONTAL, new Point(1, 1))));
        assertTrue(p.addShip(new Ship(1,Orientation.HORIZONTAL, new Point(5, 8))));
        assertTrue(p.addShip(new Ship(1,Orientation.HORIZONTAL, new Point(8, 4))));

        assertTrue(p.addShip(new Ship(2,Orientation.HORIZONTAL, new Point(5, 4))));
        assertTrue(p.addShip(new Ship(2,Orientation.VERTICAL, new Point(3, 1))));
        assertTrue(p.addShip(new Ship(2,Orientation.VERTICAL, new Point(8, 7))));

        assertTrue(p.addShip(new Ship(3,Orientation.VERTICAL, new Point(1, 5))));
        assertTrue(p.addShip(new Ship(3,Orientation.HORIZONTAL, new Point(5, 1))));

        assertTrue(p.addShip(new Ship(4,Orientation.VERTICAL, new Point(3, 4))));


        assertEquals(p.enemyShot(new Point(0, 9)), ShotResult.SINKED);
        assertEquals(p.enemyShot(new Point(0, 9)), ShotResult.REPEAT);

        assertEquals(p.enemyShot(new Point(5, 8)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(8, 4)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(1, 1)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(5, 4)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(6, 4)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(8, 8)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(8, 7)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(3, 1)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(3, 2)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(5, 1)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(6, 1)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(7, 1)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(1, 5)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(1, 6)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(1, 7)), ShotResult.SINKED);

        assertEquals(p.enemyShot(new Point(3, 5)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(3, 6)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(3, 4)), ShotResult.HIT);
        assertEquals(p.enemyShot(new Point(3, 7)), ShotResult.SINKED);

        assertTrue(p.isDefeated());
    }
}
