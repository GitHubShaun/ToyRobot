package toyrobot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/*
    Aim is to test methods that would POST,PUT,UPDATE,DELETE in hopes of creating a usable REST API
 */
public class ToyRobotRESTTest {

    private ToyRobot robot = new ToyRobot(0,0,"NORTH");

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void init(){
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testset(){
        robot.set(1,1,"SOUTH");
        robot.report();
        assertEquals("Output: 1,1,SOUTH\n", out.toString());
    }

    @Test
    public void testgetX(){
        assertEquals(0, robot.getX());
    }

    @Test
    public void testgetY(){
        assertEquals(0, robot.getY());
    }

    @Test
    public void testgetDirection(){
        assertEquals("NORTH", robot.getDirection());
    }

    @Test
    public void testdelete(){
        robot.delete();
        robot.report();
        assertEquals("Cannot report on an invalid toy robot.\n", out.toString());
    }
}