/**
 * Created by blake on 8/22/16.
 */
public class Creature {
    private stats stat = new stats();
    private String name = "";
    private String kind = "";

    public Creature() {
        name = "Johnny";
        this.stat.health   = 5;
        this.stat.healthpoints = this.stat.health;
        this.stat.attack   = 1;
        this.stat.defense  = 1;
        this.stat.intel    = 1;
        this.stat.strength = 1;

    }

    //copy type constructor
    public Creature(Creature old_c) {
        this.name = old_c.name;
        this.stat.health = old_c.stat.health;
        this.stat.attack = old_c.stat.attack;
        this.stat.defense = old_c.stat.defense;
        this.stat.intel = old_c.stat.intel;
        this.stat.strength = old_c.stat.strength;
        this.reset();
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

    //This will be correct, and updated later.  Used currently for a sanity check.
    public void level_up() {
        this.stat.defense++;
    }
    public int get_defence() {
        return this.stat.defense;
    }
}
