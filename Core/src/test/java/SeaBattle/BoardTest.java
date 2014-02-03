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
        board = new Board(10,10);
    }

    @Test
    public void testShot() throws Exception {

    }

    @Test
    public void testAddShip() throws Exception {
        Ship ship = new Ship(2, Orientation.HORIZONTAL, new Point(2, 3));
        board.addShip(ship);

        assertEquals(ship, board.getShipList().get(0));
    }

    @Ignore
    @Test
    public void testIsAShip() throws Exception {
        board.addShip(new Ship(2, Orientation.HORIZONTAL, new Point(2, 3)));

        assertTrue(board.isAShip(2,3));
        assertTrue(board.isAShip(3,3));
    }

    @Test
    public void testBoardConstructor() throws Exception {
        assertThat(board.getHeight(), equalTo(10));
        assertThat(board.getWidth(), equalTo(10));
    }
}
