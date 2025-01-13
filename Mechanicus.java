public class Mechanicus extends Adventurer{

    private int spiritBomb;
    private static final int spiritBombMax = 3;

    public Mechanicus(String name){
        super(name,20);
        this.spiritBomb= spiritBombMax;
    }

    public String getSpecialName(){
        return "Machine Spirit Energy";
    }

    public int getSpecialMax(){
        return spiritBombMax;
    }

    public void setSpecial(int n){
        this.spiritBomb= Math.min(n,spiritBombMax);
    }
// ### Adeptus Mechanicus (20 HP)
// **Normal Attack**: Radium Barrage (3-4 dmg)
// - Adeptus Mechanicus fires a burst of radioactive rounds at their enemy.

// **Special**: Omnissiah's Wrath 
// - Adeptus Mechanicus calls on the power of the machine god to disable the weapon of one of the opponents for 1 round.  Additionally, deals 3 damage to that opponent if they attempt any action during this time.

// **Support**: Upgrade Agreement 
// - Adeptus Mechanicals uses its technical skills to upgrade the weapon of either themself or a single ally, providing a boost of +3 dmg for the rest of the game. Can only be used once per person.

// **Special Resource**: Machine Spirit Energy (3 for each special)
    
}