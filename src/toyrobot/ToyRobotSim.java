package toyrobot;

public class ToyRobotSim {

    public static void inputHandler(){

    }



    public static void main(String[] args){
        ToyRobot robot = new ToyRobot(0,0,"NORTH");
        robot.move();
        robot.left();
        robot.right();
        robot.report();
    }

}
