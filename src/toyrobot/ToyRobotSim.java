package toyrobot;

public class ToyRobotSim {

    //test.txt - open file, scan lines
    //PLACE 0,0,NORTH - input args one by one
    //(empty) - interactive sim..., reply with dialogue("Enter PLACE X,Y,DIRECTION")
    public static void inputHandler(String[] args){
        if (args.length > 0){

        }else{
            doStuff();
        }
    }

    public static void doStuff(){
        //ToyRobot robot = new ToyRobot(1,2, ToyRobot.Direction.valueOf("WEST"));
        ToyRobot robot = new ToyRobot("1,2,east");
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
