package toyrobot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ToyRobotTest {

    private ToyRobot validRobot = new ToyRobot();
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void init(){
        validRobot.set(0,0,"NORTH");
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testset() {
        validRobot.report();
        assertEquals("Output: 0,0,NORTH\n", out.toString());
    }

    @Test
    public void testgetX() {
        assertEquals(0, validRobot.getX());
    }

    @Test
    public void testgetY() {
        assertEquals(0, validRobot.getY());

    }

//    @Test
//    public void testgetDirection() {
//        assertEquals(ToyRobot.Direction.NORTH, validRobot.getDirection());
//
//    }

    @Test
    public void testgetDirection() {
        assertEquals("NORTH", validRobot.getDirection());

    }

    @Test
    public void testreport() {
        validRobot.report();
        assertEquals("Output: 0,0,NORTH\n", out.toString());
    }

    @Test
    public void testdelete() {
        validRobot.delete();
        validRobot.report();
        assertEquals("Cannot report on an invalid toy robot.\n", out.toString());
    }

    @Test
    public void testmove() {
        validRobot.move();
        validRobot.report();
        assertEquals("Output: 0,1,NORTH\n", out.toString());
    }

    @Test
    public void testleft() {
        validRobot.left();
        validRobot.report();
        assertEquals("Output: 0,0,WEST\n", out.toString());
    }

    @Test
    public void testright() {
        validRobot.right();
        validRobot.report();
        assertEquals("Output: 0,0,EAST\n", out.toString());
    }
}