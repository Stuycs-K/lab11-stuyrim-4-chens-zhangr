
import java.util.*;
public class Mechanicus extends Adventurer{

    private int spiritBomb;
    private int machineEnergy, machineEnergyMax;

    public Mechanicus(String name, int hp, int machineEnergyMax, int machineEnergy){
        super(name,hp);
        this.machineEnergyMax = machineEnergyMax;
        this.machineEnergy = machineEnergy;
    }

    public Mechanicus(String name, int hp){
        this(name,hp, 5, 0);
    }
    
    public Mechanicus(String name){
        this(name,20);
    }
    
    public Mechanicus(){
        this("Paladius");
    }

    public String getSpecialName(){
        return "Machine Spirit Energy";
    }

    public int getSpecialMax(){
        return machineEnergyMax;
    }
    
    public int getSpecial(){
        return machineEnergy;
    }

    public void setSpecial(int n){
        this.machineEnergy = Math.min(n,machineEnergyMax);
    }

    public String attack(Adventurer other){
        if (this.getCorrupted()){
            Random rand = new Random();
            int damage = (int) (Math.random() * 2) + 3 + getDamageAffect() + getPermanentDamageAffect();
            this.applyDamage(damage); //self
            return this.getName() + " attacks themselves with Radium Barrage for " + damage + " points because they were corrupted";
        }
        if (this.getWeaponStatus()){
            Random rand = new Random();
            int damage = rand.nextInt(2)+3 + getDamageAffect() + getPermanentDamageAffect();
            other.applyDamage(damage);
            this.restoreSpecial(1);
            return this.getName() + " attacks " + other.getName() + " with Radium Barrage for " + damage + " points. They then charged their machine energy spirit by 1.";
        }
        else{
            super.changeWeaponStatus(true);
            return this + "'s attacks has been disabled for 1 round.";
        }
    }

    public String specialAttack(Adventurer other){
        if (this.getCorrupted()){
            Random rand = new Random();
            int damage = rand.nextInt(2)+3 + getDamageAffect() + getPermanentDamageAffect();
            this.applyDamage(damage);
            return this.getName() + "couldn't use their special because they were corrutped. Instead, they attack themselves with Radium Barrage for " + damage + " points";
        }
        if(this.getWeaponStatus()){
            int damage = (int) (Math.random()* 2) +3 + getDamageAffect()+ getPermanentDamageAffect();
            other.applyDamage(damage);
            restoreSpecial(1);
            return this.getName()+ " attacks " +other.getName() + " with Radium Barrage for " +damage+ " points. They have charged their machine energy by 1.";
        }else {
            super.changeWeaponStatus(true);
            return this.getName()+ "'s attacks have been disabled for 1 round.";
        }
        // if (spiritBomb<3){
        //     return this.getName() + " doesn't have enough MSE to use Omnissiah's Wrath. Instead "+attack(other);
        // }
        // else{
        //     this.setSpecial(0);
        //     other.changeWeaponStatus(false);
        //     return this.getName() + " used Omissiah's Wrath to disable " + other.getName() + "'s weapon for one turn.";
        // }
        // }
        // else{
        //     return this + "'s attacks has been disabled for 1 round";
        // }
    }

    public String specialAttack(Adventurer other, ArrayList<Adventurer> enemies){
        return this.specialAttack(other);
    }

    public String support(Adventurer other){
        if (this.getCorrupted()){
            return this.getName() + " is corrupted, can't help their teammates";
        }
        if (other.getPermanentDamageAffect() > 0){
            return this.getName()+" cannot update " +other.getSpecialName() + "'s weapon any further";
        }
        else{
            other.applyPermanentDamageAffect(3);
            return this.getName() + " upgrades " + other.getSpecialName()+ "'s weapon by +3";
        }
    }

    public String support(){
        if (this.getCorrupted()){
            return this.getName() + " is corrupted, can't help themself";
        }
        if (this.getPermanentDamageAffect() > 0){
            return this.getName()+" cannot update their weapon any further";
        }
        else{
            this.applyPermanentDamageAffect(3);
            return this.getName() + " uses self-maintenence boosting their damage by +3";
        }
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
