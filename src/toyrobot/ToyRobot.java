package toyrobot;

/*
TODO: REST API design, .setID("name")(?) [GET POST PUT DELETE]
TODO: JavaDoc
TODO: try/catch/throw error handling
TODO: variable board size (Currently fixed on 5x5 - hardcoded) board.java -> add to .jar file
TODO: more test cases
*/

public class ToyRobot {

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private int X;
    private int Y;
    private Direction DIRECTION;

    public ToyRobot(){}

    public ToyRobot(int X, int Y, String direction) {
        try {
            if (isValidX(X) && isValidY(Y) && contains(direction)) {
                this.X = X;
                this.Y = Y;
                this.DIRECTION = toDirection(direction);
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Constructor Failed. Check PLACE command and try again.");
        }
    }

    public ToyRobot(int X, int Y, Direction DIRECTION){
        try {
            if (isValidX(X) && isValidY(Y) && contains(DIRECTION)) {
                this.X = X;
                this.Y = Y;
                this.DIRECTION = DIRECTION;
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Constructor Failed. Check PLACE command and try again.");
        }
    }

    public ToyRobot(String position){
        try {
            if(validPlaceCommand(position)){
                this.X = Integer.parseInt(position.substring(0,position.indexOf(",")));
                this.Y = Integer.parseInt(position.substring(position.indexOf(",") + 1, position.lastIndexOf(",")));
                this.DIRECTION = toDirection(position.toUpperCase().substring(position.lastIndexOf(",")+1));
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Constructor Failed. Check PLACE command and try again.");
        }
    }

    public void set(int X, int Y, String DIRECTION){
        if (isValidX(X) && isValidY(Y) && contains(DIRECTION)) {
            this.X = X;
            this.Y = Y;
            this.DIRECTION = toDirection(DIRECTION);
        }
    }

    public int getX(){ return this.X; }

    public int getY(){ return this.Y; }

    public Direction getDirection(){ return this.DIRECTION; }

    public void delete(){
        this.X = 0;
        this.Y = 0;
        this.DIRECTION = null;
    }

    public void move(){
//        System.out.println("MOVE COMMAND.");
        try {
            switch (this.DIRECTION) {
                case NORTH:
                    if (isValidY(Y + 1)) {
                        this.Y = this.Y + 1;
                    }
                    break;
                case SOUTH:
                    if (isValidY(Y - 1)) {
                        this.Y = this.Y - 1;
                    }
                    break;
                case EAST:
                    if (isValidX(X + 1)) {
                        this.X = this.X + 1;
                    }
                    break;
                case WEST:
                    if (isValidX(X - 1)) {
                        this.X = this.X - 1;
                    }
                    break;
            }
        }
        catch(NullPointerException e){
            System.out.println("Cannot move an invalid toy robot.");
        }
    }

    public void left(){
        //System.out.println("LEFT COMMAND.");
        if (validPlaceCommand()) {
            switch (this.DIRECTION) {
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
    }

    public void right() {
        //System.out.println("RIGHT COMMAND.");
        if (validPlaceCommand()) {
            switch (this.DIRECTION) {
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
    }

    public void report(){
        //System.out.println("REPORT COMMAND.");
        if (validPlaceCommand()) {
            System.out.println("Output: " + this.X + "," + this.Y + "," + this.DIRECTION);
        }
    }

    //Convert String to Direction

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
            System.out.println("\'" + string + "\'" + " not recognised. Try again.");
            tmp = null;
        }
        return tmp;
    }

    //Boolean checkers

    private boolean validPlaceCommand(){
        return (this.DIRECTION != null);
    }

    private boolean validPlaceCommand(String str){
        return str.toUpperCase().replaceAll("\\s","").matches("([0-4]),([0-4]),(NORTH|SOUTH|EAST|WEST)");
    }

    private boolean contains(String string){
        for (Direction dir : Direction.values()){
            if (dir.name().equals(string)){
                return true;
            }
        }
        return false;
    }

    private boolean contains(Direction DIRECTION){
        for (Direction dir : Direction.values()){
            if (dir.name().equals(DIRECTION.toString())){
                return true;
            }
        }
        return false;
    }

    private boolean isValidX(int value){
        return (value <= 4 && value >= 0);
    }

    private boolean isValidY(int value){
        return (value <= 4 && value >= 0);
    }
}