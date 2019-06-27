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
        switch(this.DIRECTION){
            case "NORTH":
                if (this.Y + 1 <= 4 && this.Y + 1 >= 0) { this.Y = this.Y + 1; }
                break;
            case "SOUTH" :
                if (this.Y - 1 <= 4 && this.Y - 1 >= 0) { this.Y = this.Y - 1; }
                break;
            case "EAST" :
                if (this.X + 1 <= 4 && this.X + 1 >= 0) { this.X = this.X + 1; }
                break;
            case "WEST" :
                if (this.X - 1 <= 4 && this.X - 1 >= 0) { this.X = this.X - 1; }
                break;
        }
    }

    public void left(){
        System.out.println("LEFT COMMAND.");
        switch(this.DIRECTION){
            case "NORTH":
                this.DIRECTION = "WEST";
                break;
            case "SOUTH" :
                this.DIRECTION = "EAST";
                break;
            case "EAST" :
                this.DIRECTION = "NORTH";
                break;
            case "WEST" :
                this.DIRECTION = "SOUTH";
                break;
        }

    }

    public void right(){
        System.out.println("RIGHT COMMAND.");
        switch(this.DIRECTION){
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
        //System.out.println("REPORT COMMAND.");
        System.out.println("Output: " + this.X + "," + this.Y + "," + this.DIRECTION);
    }
}
