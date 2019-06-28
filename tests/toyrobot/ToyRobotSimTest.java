package toyrobot;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ToyRobotSimTest {

    @Test
    public void main() {
        String[] args = {"testfiles/testcase1.txt", "testfiles/testcase2.txt", "testfiles/testcase3.txt"};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ToyRobotSim.main(args);
        assertEquals("Output: 0,1,NORTH\nOutput: 0,0,WEST\nOutput: 3,3,NORTH\n", out.toString());
//        assertEquals("Output: 0,1,WEST\n", out.toString());
//        assertEquals("Output: 3,3,NORTH\n", out.toString());
    }
}