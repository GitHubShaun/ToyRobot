package toyrobot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ToyRobotCommandsTest {

    private ToyRobot robot = new ToyRobot(0,0,"NORTH");

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void init(){
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testMOVE(){
        robot.move();
        robot.report();
        assertEquals("Output: 0,1,NORTH\n", out.toString());
    }

    @Test
    public void testMOVEInvalid(){
        robot.set(0,4,"NORTH");
        robot.move();  //Moving off the board, out of bounds northwards.
        robot.report();
        robot.set(0,0,"SOUTH");
        robot.move();  //Moving off the board, out of bounds southwards.
        robot.report();
        robot.set(4,0,"EAST");
        robot.move();  //Moving off the board, out of bounds eastwards.
        robot.report();
        robot.set(0,0,"WEST");
        robot.move();  //Moving off the board, out of bounds westwards.
        robot.report();

        //Any invalid moves (ie. out of bounds) is ignored and not registered. Therefore previous parameters should remain.
        assertEquals("Output: 0,4,NORTH\n" +
                        "Output: 0,0,SOUTH\n" +
                        "Output: 4,0,EAST\n" +
                        "Output: 0,0,WEST\n"
                , out.toString());
    }

    @Test
    public void testLEFT(){
        robot.left();
        robot.report();
        assertEquals("Output: 0,0,WEST\n", out.toString());
    }

    @Test
    public void testLEFTInvalid(){
        robot.delete(); //Creating an invalid toy robot.
        robot.left();
        assertEquals("Cannot rotate an invalid toy robot.\n", out.toString());
    }

    @Test
    public void testRIGHT(){
        robot.right();
        robot.report();
        assertEquals("Output: 0,0,EAST\n", out.toString());
    }

    @Test
    public void testRIGHTInvalid(){
        robot.delete(); //Creating an invalid toy robot.
        robot.right();
        assertEquals("Cannot rotate an invalid toy robot.\n", out.toString());
    }

    @Test
    public void testREPORT(){
        robot.report();
        assertEquals("Output: 0,0,NORTH\n", out.toString());
    }

    @Test
    public void testREPORTInvalid(){
        robot.delete(); //Creating an invalid toy robot.
        robot.report();
        assertEquals("Cannot report on an invalid toy robot.\n", out.toString());
    }
}