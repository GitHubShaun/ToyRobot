package toyrobot;

public class ToyRobotSim {

    public static void inputHandler(){

    }



    public static void main(String[] args){
        ToyRobot robot = new ToyRobot(1,2,"EAST");
        robot.move();
        robot.move();
        robot.left();
        robot.move();
        robot.report();
    }

}
