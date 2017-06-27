/**
 * Created by blake on 11/12/16.
 * The maps that are created should be read in a left to right, bottom to top
 * array grid.  0,0 is bottom left, currently only square grids are supported.
 * CURRENTLY: water is acting for the boundaries of the map
 *
 */
public class map {
    private class Location {
        public String type = "";
        public Object occupied = null;
        public Location() {
            this.type = "default";
        }
        public Location(String name) { this.type = name; }
        public Location(Location old) {
            type = old.type;
            occupied = old.occupied;
        }
    }
    private Location[][] grid_one;
    private int x,y, x_bounds, y_bounds;

    //cons tructor class for building a map.  Only builds a square map
    //with water as the boundaries ATM.
    public map( int one ) {
        x_bounds = one;
        y_bounds = one;
        int start_number = one/2;
        x = start_number;
        y = start_number;
        Location water = new Location("Water");
        Location land = new Location("Land");
        Location home = new Location("Home");

        grid_one = new Location[10][10];
        for( int i = 0; i < x_bounds; i++ ) {
            for( int j = 0; j < y_bounds; j++)  {
                grid_one[i][j] = new Location(water);
            }
        }
        for( int i = start_number-1; i <= start_number+1; i++ ) {
            for( int j = start_number-1; j <= start_number+1; j++ ) {
                grid_one[i][j] = new Location(land);
            }
        }
        grid_one[start_number][start_number] = new Location(home);

        Creature c_test00 = new Creature();
        Creature c_test01 = new Creature();
        c_test01.set_name("John Cena");
        c_test01.level_up();
        grid_one[start_number][start_number+1].occupied = c_test00;
        grid_one[start_number][start_number-1].occupied = c_test01;
    }

    //Need up update to include information for the occupied type.
    //
    public String at_loc (int inputX, int inputY) { return grid_one[inputX][inputY].type; }

    //Function that will handle the 'moving' logic for the game map
    //ALSO: Will add a function that will intemperate if the Location is a valid move
    // instead of dealing with this in a HardCode
    //
    public boolean move(String dir) {
        if( dir.equals("up") ) {
            if ( grid_one[x][y+1].type.equals("Water") ) {
                return false;
            } else { y++; return true; }
        }
        else if( dir.equals("down") ) {
            if ( grid_one[x][y-1].type.equals("Water") ) {
                return false;
            } else { y--; return true; }
        }
        else if( dir.equals("left") ) {
            if ( grid_one[x-1][y].type.equals("Water") ) {
                return false;
            } else { x--; return true; }
        }
        else if( dir.equals("right") ) {
            if ( grid_one[x+1][y].type.equals("Water") ) {
                return false;
            } else { x++; return true; }
        }
        else { return false; }
    }
    /**
     * --A cheater method that can force a Location move without stepping
     * though the step functions.
     * --One overrides the X coordinate, Two overrides the Y coordinate
     **/
    public void update_loc( int one, int two ) {
        //one is the x coordinate, two is the y coordinate
        if ( one < x_bounds) {
            x = one;
        } else { System.out.println("Error updating x Location"); }
        if ( two < y_bounds ) {
            y = two;
        } else { System.out.println("Error upading y Location"); }
    }

    public void battle(){
        Object o = grid_one[x][y].occupied;
        if( o != null) {
            if( o instanceof Creature) {
                Creature carrot = (Creature) o;
                System.out.println(carrot.get_name()+" D: "+carrot.get_defence());
            }
        }
        else { System.out.println("Noooope!");
        }
    }
    /**
     * --builds a string of the resulting spaces around the current Location,
     * --width must be a odd number, (width-1)/2 gives the number of sides that
     * it will show
     * --row_up is the row that it will calculated on.  positive is up (north),
     * negative is down (south)
     **/
    public String build_line(int width, int row_up) {
        //checks the bounds
        int offset = ( width -1) /2;
        if ( x_bounds < (x + offset ) || y_bounds < (y + row_up ) ||
                0 > (x - offset ) || 0 > (y + row_up )   ) {
            return "";
        }
        String to_return = "";
        for (int i = x-offset; i <= x+offset; i++) {
            to_return = to_return +
                    grid_one[i][y+row_up].type.charAt(0)+ " ";
        }
        return to_return;
    }
    public int get_x() { return x; }
    public int get_y() { return y; }
}