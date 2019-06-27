package toyrobot;

/*
TODO: Validate X,Y,Direction is within range/enum
TODO: REST API
TODO: JavaDoc
TODO: try/catch/throw error handling
TODO: variable board size (Currently fixed on 5x5 - hardcoded)
*/

public class ToyRobot {

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private int X;
    private int Y;
    private Direction DIRECTION;

    public ToyRobot(int X, int Y, String direction){
        this.X = X;
        this.Y = Y;
        if (contains(direction)) this.DIRECTION = toDirection(direction);
    }

    public ToyRobot(int X, int Y, Direction DIRECTION){
        this.X = X;
        this.Y = Y;
        this.DIRECTION = DIRECTION;
    }

    public ToyRobot(String position){
        if(validPlaceCommand(position)){
            this.X = Integer.parseInt(position.substring(0,position.indexOf(",")));
            this.Y = Integer.parseInt(position.substring(position.indexOf(",") + 1, position.lastIndexOf(",")));
            this.DIRECTION = toDirection(position.toUpperCase().substring(position.lastIndexOf(",")+1));
        }
    }

    public int getX(){ return this.X; }

    public int getY(){ return this.Y; }

    public Direction getDirection(){ return this.DIRECTION; }

    public void move(){
        //System.out.println("MOVE COMMAND.");
        switch(this.DIRECTION){
            case NORTH:
                if (this.Y + 1 <= 4 && this.Y + 1 >= 0) { this.Y = this.Y + 1; }
                break;
            case SOUTH:
                if (this.Y - 1 <= 4 && this.Y - 1 >= 0) { this.Y = this.Y - 1; }
                break;
            case EAST:
                if (this.X + 1 <= 4 && this.X + 1 >= 0) { this.X = this.X + 1; }
                break;
            case WEST:
                if (this.X - 1 <= 4 && this.X - 1 >= 0) { this.X = this.X - 1; }
                break;
        }
    }

    public void left(){
        //System.out.println("LEFT COMMAND.");
        switch(this.DIRECTION){
            case NORTH:
                this.DIRECTION = Direction.WEST;
                break;
            case SOUTH:
                this.DIRECTION = Direction.EAST;
                break;
            case EAST:
                this.DIRECTION = Direction.NORTH;
                break;
            case WEST:
                this.DIRECTION = Direction.SOUTH;
                break;
        }
    }

    public void right(){
        //System.out.println("RIGHT COMMAND.");
        switch(this.DIRECTION){
            case NORTH:
                this.DIRECTION = Direction.EAST;
                break;
            case SOUTH:
                this.DIRECTION = Direction.WEST;
                break;
            case EAST:
                this.DIRECTION = Direction.SOUTH;
                break;
            case WEST:
                this.DIRECTION = Direction.NORTH;
                break;
        }
    }

    public void report(){
        //System.out.println("REPORT COMMAND.");
        System.out.println("Output: " + this.X + "," + this.Y + "," + this.DIRECTION);
    }

    private boolean validPlaceCommand(String str){
        return str.toUpperCase().replaceAll("\\s","").matches("([0-4]),([0-4]),(NORTH|SOUTH|EAST|WEST)");
    }

    private Direction toDirection(String string){
        assert string != null : "Invalid direction facing, options: [NORTH,SOUTH,EAST,WEST].";
        Direction tmp = null;
        try {
            switch (string) {
                case "NORTH":
                    tmp = Direction.NORTH;
                    break;
                case "SOUTH":
                    tmp = Direction.SOUTH;
                    break;
                case "EAST":
                    tmp = Direction.EAST;
                    break;
                case "WEST":
                    tmp = Direction.WEST;
                    break;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            tmp = null;
        }
        return tmp;
    }

    private boolean contains(String string){
        for (Direction dir : Direction.values()){
            if (dir.name().equals(string)){
                return true;
            }
        }
        return false;
    }
}
