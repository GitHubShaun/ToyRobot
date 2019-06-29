package toyrobot;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/*
    PLACE 0,0,NORTH
    MOVE
    REPORT
 */
public class ToyRobotSimTestCase1 {

    private String[] args = {"testfiles/testcase1.txt"};

    @Test
    public void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ToyRobotSim.main(args);
        assertEquals("Output: 0,1,NORTH\n", out.toString());
    }
}