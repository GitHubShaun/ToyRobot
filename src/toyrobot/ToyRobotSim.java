package toyrobot;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

//TODO: Documenting/commenting
public class ToyRobotSim {

    static TimerTask execute = new TimerTask(){

        public void run() {
            System.out.println("Time ran out, Bye bye.");
            System.exit(0);
        }
    };

    public static void main(String[] args) {

        ToyRobot robot = null;

        for (int i=0; i<args.length; i++) {
            if (args[i].matches("(.*).txt")) {
                try {
                    File file = new File(args[i]);

                    if (file != null) { //unnecessary but useful validator.
                        BufferedReader buf = new BufferedReader(new FileReader(file));
                        String line;
                        try {
                            while ((line = buf.readLine()) != null) {
                                if (line.toUpperCase().startsWith("PLACE")) {
                                    //check if this command is valid
                                    try {
                                        robot = new ToyRobot(line.substring(line.indexOf(' ') + 1));
                                    } catch (Exception ex) {
                                        System.out.println("Invalid PLACE command");
                                    }
                                } else if (robot != null) {
                                    switch (line) {
                                        case "MOVE":
                                            robot.move();
                                            break;
                                        case "LEFT":
                                            robot.left();
                                            break;
                                        case "RIGHT":
                                            robot.right();
                                            break;
                                        case "REPORT":
                                            robot.report();
                                            break;
                                    }
                                }
                            }
                            buf.close();
                        } catch (IOException e) {
                            System.out.println("Hello here.");
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                }
            } else if (args.length > 1) {
                //get commandline arguments
                if (args[i].toUpperCase().startsWith("PLACE")) {
                    try {
                        robot = new ToyRobot(args[i+1]);
                    } catch (Exception ex) {
                        System.out.println("Invalid PLACE command");
                    }
                } else if (robot != null) {
                    switch (args[i]) {
                        case "MOVE":
                            robot.move();
                            break;
                        case "LEFT":
                            robot.left();
                            break;
                        case "RIGHT":
                            robot.right();
                            break;
                        case "REPORT":
                            robot.report();
                            break;
                    }
                }
            }
        }
    }
}
