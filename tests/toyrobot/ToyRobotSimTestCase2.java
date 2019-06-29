package toyrobot;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/*
    PLACE 0,0,NORTH
    LEFT
    REPORT
 */
public class ToyRobotSimTestCase2 {

    private String[] args = {"testfiles/testcase2.txt"};

    @Test
    public void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ToyRobotSim.main(args);
        assertEquals("Output: 0,0,WEST\n", out.toString());
    }
}