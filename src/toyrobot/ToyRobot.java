package toyrobot;

/*
TODO: more test cases
*/

/**
 * Java Class Library to simulate a toy robot on a 5x5 board.
 *
 * @author Shaun Chua
 */
public class ToyRobot {

    /**
     * Possible directions the toy robot can face.
     */
    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private int X;
    private int Y;
    private Direction DIRECTION;
    // Represents toy robot's parameters

    //Constructors

    /**
     * Constructs a null <code>ToyRobot</code> that can be used manually.
     */
    public ToyRobot(){}

    /**
     * Constructs a new <code>ToyRobot</code> object.
     * @param X An integer indicating X position on the board.
     * @param Y An integer indicating Y position on the board.
     * @param direction A string indicating the direction the <code>ToyRobot</code> is facing on the board.
     * @throws IllegalArgumentException if inputs are not recognized.
     */
    public ToyRobot(int X, int Y, String direction) {
        try {
            if (isValidX(X) && isValidY(Y) && contains(direction)) {
                this.X = X;
                this.Y = Y;
                this.DIRECTION = toDirection(direction);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Constructor Failed. \'" +  X + "," + Y + "," + direction +"\' not recognized. Check PLACE command and try again.");
        }
    }

    /**
     * Constructs a new <code>ToyRobot</code> object.
     * @param X An integer indicating X position on the board.
     * @param Y An integer indicating Y position on the board.
     * @param DIRECTION A direction data-type indicating the direction the <code>ToyRobot</code> is facing on the board.
     * @throws IllegalArgumentException if inputs are not recognized.
     */
    public ToyRobot(int X, int Y, Direction DIRECTION){
        try {
            if (isValidX(X) && isValidY(Y) && contains(DIRECTION)) {
                this.X = X;
                this.Y = Y;
                this.DIRECTION = DIRECTION;
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Constructor Failed. \'" +  X + "," + Y + "," + DIRECTION +"\' not recognized. Check PLACE command and try again.");
        }
    }

    /**
     * Constructs a new <code>ToyRobot</code> object.
     * @param position A string of information of the form X,Y,Direction to place the <code>ToyRobot</code>.
     * @throws IllegalArgumentException if inputs are not recognized.
     */
    public ToyRobot(String position){
        try {
            if(validPlaceCommand(position)){
                this.X = Integer.parseInt(position.substring(0,position.indexOf(",")));
                this.Y = Integer.parseInt(position.substring(position.indexOf(",") + 1, position.lastIndexOf(",")));
                this.DIRECTION = toDirection(position.toUpperCase().substring(position.lastIndexOf(",")+1));
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Constructor Failed. \'" +  position +"\' not recognized. Check PLACE command and try again.");
        }
    }

    /**
     * Set the parameters for a <code>ToyRobot</code> object.
     * @param X An integer indicating X position on the board.
     * @param Y An integer indicating Y position on the board.
     * @param DIRECTION A string indicating the direction the <code>ToyRobot</code> is facing on the board.
     * @throws IllegalArgumentException if inputs are not recognized.
     */
    public void set(int X, int Y, String DIRECTION){
        try {
            if (isValidX(X) && isValidY(Y) && contains(DIRECTION)) {
                this.X = X;
                this.Y = Y;
                this.DIRECTION = toDirection(DIRECTION);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid parameters.");
        }
    }

    /**
     * Get the X position of the <code>ToyRobot</code>.
     * @return Integer indicating the X value.
     */
    public int getX(){ return this.X; }

    /**
     * Get the Y position of the <code>ToyRobot</code>.
     * @return Integer incidating the Y value.
     */
    public int getY(){ return this.Y; }

    /**
     * Get the Direction which the <code>ToyRobot</code> is currently facing.
     * @return String indicating the direction facing.
     */
    public String getDirection(){ return this.DIRECTION.toString(); }

    /**
     * Delete the parameter information of this <code>ToyRobot</code>.
     * Results in <code>ToyRobot</code> with information 0,0,null.
     */
    public void delete(){
        this.X = 0;
        this.Y = 0;
        this.DIRECTION = null;
    }

    /**
     * MOVE command. Moves the <code>ToyRobot</code> forward 1 space in the direction it is facing.
     * NORTH = Y++
     * SOUTH = Y--
     * EAST  = X++
     * WEST  = X--
     * @throws NullPointerException if robot is not valid.
     */
    public void move(){
//      System.out.println("MOVE COMMAND.");
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

    /**
     * LEFT command. Rotates the <code>ToyRobot</code> anti-clockwise (left) from the current direction.
     * NORTH = WEST
     * SOUTH = EAST
     * EAST  = NORTH
     * WEST  = SOUTH
     * @throws NullPointerException if robot is not valid.
     */
    public void left(){
        //System.out.println("LEFT COMMAND.");
        try {
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
            else{
                throw new NullPointerException();
            }
        }
        catch(NullPointerException e){
            System.out.println("Cannot rotate an invalid toy robot.");
        }
    }

    /**
     * RIGHT command. Rotates the <code>ToyRobot</code> clockwise (RIGHT) from the current direction.
     * NORTH = EAST
     * SOUTH = WEST
     * EAST  = SOUTH
     * WEST  = NORTH
     * @throws NullPointerException if robot is not valid.
     */
    public void right() {
        //System.out.println("RIGHT COMMAND.");
        try {
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
            else{
                throw new NullPointerException();
            }
        }
        catch(NullPointerException e){
            System.out.println("Cannot rotate an invalid toy robot.");
        }
    }

    /**
     * REPORT command. Returns a printed statement to the terminal providing information on this <code>ToyRobot</code>.
     * Output: X,Y,Direction is expected.
     * @throws NullPointerException if robot is not valid.
     */
    public void report(){
        //System.out.println("REPORT COMMAND.");
        try {
            if (validPlaceCommand()) {
                System.out.println("Output: " + this.X + "," + this.Y + "," + this.DIRECTION);
            }
            else{
                throw new NullPointerException();
            }
        }
        catch(NullPointerException e){
            System.out.println("Cannot report on an invalid toy robot.");
        }
    }

    //Convert String to Direction for processing.
    private Direction toDirection(String string){
        assert string != null : "Invalid direction, options: [NORTH,SOUTH,EAST,WEST].";
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
            System.out.println("Invalid direction: \'" + string + "\' available options: [NORTH,SOUTH,EAST,WEST].");
            tmp = null;
        }
        return tmp;
    }

    //Boolean checkers

    //Ensures robot parameters has been initialized.
    //If robot hasn't been initialized, parameters are 0,0,null.
    private boolean validPlaceCommand(){
        return (this.DIRECTION != null);
    }

    //Ensure the string parsed to the constructor is valid parameters for placing the Toy Robot.
    //Only valid is X,Y is within the 5x5 board and Direction is North,South,East,West.
    private boolean validPlaceCommand(String str){
        return str.toUpperCase().replaceAll("\\s","").matches("([0-4]),([0-4]),(NORTH|SOUTH|EAST|WEST)");
    }

    //Checks if parsed string is in the Direction enum type.
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
            if (dir.equals(DIRECTION)){
                return true;
            }
        }
        return false;
    }

    //Checks if the @param value is within the range of 0-4 (5x5 board).
    private boolean isValidX(int value){
        return (value <= 4 && value >= 0);
    }

    //Checks if the @param value is within the range of 0-4 (5x5 board).
    private boolean isValidY(int value){
        return (value <= 4 && value >= 0);
    }
}