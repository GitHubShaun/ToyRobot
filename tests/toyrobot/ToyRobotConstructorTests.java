package toyrobot;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ToyRobotConstructorTests {

    private ToyRobot robot = null;

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void init(){
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testNullConstructor(){
        robot = new ToyRobot();
        robot.report();
        assertEquals("Cannot report on an invalid toy robot.\n", out.toString());
    }

    @Test
    public void testIntIntStringConstructor(){
        robot = new ToyRobot(0,0,"NORTH");
        robot.report();
        assertEquals("Output: 0,0,NORTH\n", out.toString());
    }

    @Test
    public void testIntIntStringConstructorInvalids(){
        robot = new ToyRobot(-1,0,"NORTH"); //Out of bounds, 5x5 board.
        robot = new ToyRobot(0,-1,"NORTH"); //Out of bounds, 5x5 board.
        robot = new ToyRobot(0,0,"test"); //Unrecognized direction.
        assertEquals(
                "Constructor Failed. '-1,0,NORTH' not recognized. Check PLACE command and try again.\n" +
                "Constructor Failed. '0,-1,NORTH' not recognized. Check PLACE command and try again.\n" +
                "Constructor Failed. '0,0,test' not recognized. Check PLACE command and try again.\n"
                , out.toString());
    }

    @Test
    public void testIntIntDirectionConstructor(){
        robot = new ToyRobot(0,0, ToyRobot.Direction.NORTH);
        robot.report();
        assertEquals("Output: 0,0,NORTH\n", out.toString());
    }

    @Test
    public void testIntIntDirectionConstructorInvalids(){
        robot = new ToyRobot(-1,0, ToyRobot.Direction.NORTH); //Out of bounds, 5x5 board.
        robot = new ToyRobot(0,-1, ToyRobot.Direction.NORTH); //Out of bounds, 5x5 board.
        robot = new ToyRobot(0,0,"test"); //Unrecognized direction.
        assertEquals(
                "Constructor Failed. '-1,0,NORTH' not recognized. Check PLACE command and try again.\n" +
                        "Constructor Failed. '0,-1,NORTH' not recognized. Check PLACE command and try again.\n" +
                        "Constructor Failed. '0,0,test' not recognized. Check PLACE command and try again.\n"
                , out.toString());
    }

    @Test
    public void testStringConstructor(){
        robot = new ToyRobot("0,0,NORTH");
        robot.report();
        assertEquals("Output: 0,0,NORTH\n", out.toString());
    }

    @Test
    public void testStringConstructorInvalids(){
        robot = new ToyRobot("failtest"); //Unrecognized string, not of the form X,Y,Direction.
        robot = new ToyRobot("-1,0,NORTH"); //Out of bounds, 5x5 board.
        robot = new ToyRobot("0,-1,NORTH"); //Out of bounds, 5x5 board.
        robot = new ToyRobot("0,0,test"); //Unrecognized direction.
        assertEquals(
                "Constructor Failed. 'failtest' not recognized. Check PLACE command and try again.\n" +
                        "Constructor Failed. '-1,0,NORTH' not recognized. Check PLACE command and try again.\n" +
                        "Constructor Failed. '0,-1,NORTH' not recognized. Check PLACE command and try again.\n" +
                        "Constructor Failed. '0,0,test' not recognized. Check PLACE command and try again.\n"
                , out.toString());
    }
}