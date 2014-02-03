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
}
