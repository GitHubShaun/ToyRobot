package toyrobot;

import java.io.File;

public class ToyRobotSim {


    //test.txt - open file, scan lines
    //PLACE 0,0,NORTH - input args one by one
    //(empty) - interactive sim..., reply with dialogue("Enter PLACE X,Y,DIRECTION")
    public static void inputHandler(String[] args){
        ToyRobot robot = null;

        if (args.length > 0){
            for (int i=0; i<args.length; i++){
                String command = args[i];
                if(command.matches("(.*).txt")){
                    System.out.println("Read file: " + command);
                    //processFile(File command);
                }else{
                    System.out.println(i + ": Execute: " + command);
                    if (command.matches("PLACE")){
                        command = command + " " + args[i+1];
                        executeActions(robot, command);
                        i++;
                        continue;
                    }
                    executeActions(robot, command);
                }
            }
        }else{
            doStuff();
        }
    }

    public void processFile(File file){
        //executeActions();
    }

    public static void executeActions(ToyRobot robot, String command){
        System.out.println("executeAction(" + command + ")");
        if(command.toUpperCase().startsWith("PLACE")) {

        }
        if(robot != null){

        }
    }

    public static void doStuff(){
        //ToyRobot robot = new ToyRobot(1,2, ToyRobot.Direction.valueOf("WEST"));
        ToyRobot robot = new ToyRobot("1,2,WEST");
        robot.move();
        robot.move();
        robot.left();
        robot.move();
        robot.report();
    }

    public static void main(String[] args){
        inputHandler(args);
    }

}
