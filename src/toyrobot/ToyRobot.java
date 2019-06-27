package toyrobot;

public class ToyRobot {

    private int X;
    private int Y;
    private String DIRECTION;

    public ToyRobot(int X, int Y, String DIRECTION){
        this.X = X;
        this.Y = Y;
        this.DIRECTION = DIRECTION;
    }

    public void move(){
        System.out.println("MOVE COMMAND.");
        switch (this.DIRECTION){
            case "NORTH":
                this.DIRECTION = "EAST";
                break;
            case "SOUTH" :
                this.DIRECTION = "WEST";
                break;
            case "EAST" :
                this.DIRECTION = "SOUTH";
                break;
            case "WEST" :
                this.DIRECTION = "NORTH";
                break;
        }
    }

    public void left(){
        System.out.println("LEFT COMMAND.");
        switch (this.DIRECTION){
            case "NORTH":
                this.DIRECTION = "EAST";
                break;
            case "SOUTH" :
                this.DIRECTION = "WEST";
                break;
            case "EAST" :
                this.DIRECTION = "SOUTH";
                break;
            case "WEST" :
                this.DIRECTION = "NORTH";
                break;
        }
    }

    public void right(){
        System.out.println("RIGHT COMMAND.");
        switch (this.DIRECTION){
            case "NORTH":
                this.DIRECTION = "EAST";
                break;
            case "SOUTH" :
                this.DIRECTION = "WEST";
                break;
            case "EAST" :
                this.DIRECTION = "SOUTH";
                break;
            case "WEST" :
                this.DIRECTION = "NORTH";
                break;
        }
    }

    public void report(){
        System.out.println("REPORT COMMAND.");
        System.out.println("Output: " + this.X + "," + this.Y + "," + this.DIRECTION);
    }
}
