/**
 * Created by blake on 8/22/16.
 */
public class creature {
    private stats stat = new stats();
    private String name = "";
    private String kind = "";

    public creature() {
        name = "Johnny";
        this.stat.health   = 5;
        this.stat.healthpoints = this.stat.health;
        this.stat.attack   = 1;
        this.stat.defense  = 1;
        this.stat.intel    = 1;
        this.stat.strength = 1;

    }
    public void set_name(String input) { name = input; }
    public String get_name() {
        String toReturn;
        if ( this.name.equals("Johnny") ) {
            toReturn = "Here is ";
            toReturn = toReturn + name;
        }
        else { toReturn = this.name; }
        return toReturn;
    }
    public boolean has_weapon() {return false;}
    public int attack() {
        if ( this.has_weapon() ) { return this.stat.attack; }
        else { return this.stat.attack; }
    }
    public void defend(int attack_value) {
        this.stat.healthpoints -= ( attack_value/this.stat.defense );
        if ( this.stat.healthpoints == 0 ) { this.stat.healthpoints = 0; }
    }
    public void reset() {this.stat.healthpoints = this.stat.health; }
}
