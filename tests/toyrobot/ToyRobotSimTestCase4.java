package toyrobot;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/*
    MOVE
    REPORT
    PLACE 0,0,SOUTH
    LEFT
    REPORT

    Additional: highlights the 'ignore commands until PLACE' requirement.
 */
public class ToyRobotSimTestCase4 {

    private String[] args = {"testfiles/testcase4.txt"};

    @Test
    public void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ToyRobotSim.main(args);
        assertEquals("Output: 0,0,EAST\n", out.toString());
    }
}