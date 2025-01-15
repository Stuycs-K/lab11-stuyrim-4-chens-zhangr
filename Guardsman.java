public class Guardsman extends Adventurer{
    private int grit;
    private int morale;

    public Guardsman(String name){
        super(name, 12);
        this.grit=0;
        this.morale=0;
    }

    public String getSpecialName(){
        return "Morale and Grit";
    }

    public int getSpecial(){
        return morale + grit;
    }

    public int getMorale(){
        return morale;
    }

    public int getGrit(){
        return grit;
    }

    public void setMorale(int morale){
        this.morale=morale;
    }
    
    public void setGrit(int grit){
        this.grit=grit;
    }

    public void setSpecial(int n){
        n= this.morale=this.grit;
    }

    public int getSpecialMax(){
        return 7;
    
    }    
    public String attack(Adventurer other){
        int damage = (int)(Math.random()*2)+1;
        other.applyDamage(damage);
        return this.getName()+ " fires a plasma rifle at " +other.getName()+ " for " + damage + " damage.";
    }

    public String specialAttack(Adventurer other){
        if (morale >= 4){
            morale = morale - 4;
            int damage = 10;
            int splashDamage = 3;

            other.applyDamage(damage);

            return this.getName() + " tosses a Grenade, dealing " + damage + " damage to " + other.getName() + " and " + splashDamage + " splash damage.";
        } else {
            return this.getName()+ " doesn't have enough morale.";
        }
    }
    
    public String support(){
        if (getHP() <= 0 && grit < 4){
            grit++;
            return this.getName() + " is calling reinforcements! " + grit;
        } else if (getHP()<=0){
            return this.getName() + " cannot call more reinforcements.";
        } else {
            return this.getName() + " is still alive, no need for reinforcements";
        }
    }

    public String support(Adventurer other){
        return "A guardsman won't support others, they shall die a glorious death";
    }

    public void incrementMorale(){
        morale++;
    }

    public int restoreSpecial(int n){
        int restore = Math.min(n,4-morale);
        morale += restore;
        return restore;
    }
// ### Death Korps Guardsman (12 HP)
// **Normal Attack**: Lasgun Shot (1-2 dmg)
// - Guardsman fires a single shot from their lasgun due to their inferior physical abilities. 

// **Special**: Fragment Grenade - (6 dmg + 2 splash dmg)
// - Guardsman tosses a grenade, dealing 10 damage to a target and 3 splash damage to adjacent enemies.

// **Support**: Call Reinforcements
// - Summons another Guardsman upon defeat. Each reinforcement arrives with same health and same abilities. Maximum of 4 reinforcements per match.

// **Special Resource**: Morale and Grit (4 for each special) 
// -make 2 seperate variables then add them, make grit how many times reinforcements have been called nad morale how many turns that particular guardsman has survived (don't make this copy to the reinforcement).

}