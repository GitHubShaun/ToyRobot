package toyrobot;

/*
TODO: REST API design, .setID("name")(?) [GET POST PUT DELETE]
TODO: JavaDoc
TODO: try/catch/throw error handling
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
    /** Represents toy robot's parameters
     */

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
     */
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
            System.out.println("Constructor Failed. \'" +  X + "," + Y + "," + direction +"\' not recognised. Check PLACE command and try again.");
        }
    }

    /**
     * Constructs a new <code>ToyRobot</code> object.
     * @param X An integer indicating X position on the board.
     * @param Y An integer indicating Y position on the board.
     * @param DIRECTION A direction data-type indicating the direction the <code>ToyRobot</code> is facing on the board.
     */
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
            System.out.println("Constructor Failed. \'" +  X + "," + Y + "," + DIRECTION +"\' not recognised.  Check PLACE command and try again.");
        }
    }

    /**
     * Constructs a new <code>ToyRobot</code> object.
     * @param position A string of information of the form X,Y,Direction.
     */
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
//            System.out.println("Constructor Failed. Check PLACE command and try again.");
            System.out.println("Constructor Failed. \'" +  position +"\' not recognised. Check PLACE command and try again.");

        }
    }

    /**
     * Set the parameters for a <code>ToyRobot</code> object.
     * @param X An integer indicating X position on the board.
     * @param Y An integer indicating Y position on the board.
     * @param DIRECTION A string indicating the direction the <code>ToyRobot</code> is facing on the board.
     */
    public void set(int X, int Y, String DIRECTION){
        try {
            if (isValidX(X) && isValidY(Y) && contains(DIRECTION)) {
                this.X = X;
                this.Y = Y;
                this.DIRECTION = toDirection(DIRECTION);
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
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
     * Get the direction the <code>ToyRobot</code> is currently facing on the board.
     * @return Direction date-type
     */
    public Direction getDirection(){ return this.DIRECTION; }

    //TODO: Replace Direction getDirection with String getDirection for user usablility.
    public String getDirection(){ return this.DIRECTION.toString(); }

    public void delete(){
        this.X = 0;
        this.Y = 0;
        this.DIRECTION = null;
    }

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
                throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("Cannot rotate an invalid toy robot.");
        }
    }

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
                throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("Cannot rotate an invalid toy robot.");
        }
    }

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

    //Convert String to Direction

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