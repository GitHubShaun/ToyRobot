package toyrobot;

import java.io.*;

//TODO: Documenting/commenting
public class ToyRobotSim {

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
                    System.out.println(args[i] + ": File not found.");
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
