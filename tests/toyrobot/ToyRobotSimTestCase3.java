package toyrobot;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/*
    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT
 */
public class ToyRobotSimTestCase3 {

    private String[] args = {"testfiles/testcase3.txt"};

    @Test
    public void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ToyRobotSim.main(args);
        assertEquals("Output: 3,3,NORTH\n", out.toString());
    }
}