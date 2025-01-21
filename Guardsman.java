import java.util.*;

public class Guardsman extends Adventurer{
    private int morale, moraleMax, counter;

    public Guardsman(String name, int hp, int moraleMax, int morale){
        super(name,hp);
        this.moraleMax = moraleMax;
        this.morale = morale;
        this.counter = 0;
    }

    public Guardsman(String name, int hp){
        this(name,hp, 4, 0);
    }
    
    public Guardsman(String name){
        this(name,12);
    }
    
    public Guardsman(){
        this("Colonel Jurten");
    }

    public int getSpecial(){
        return morale;
    }

    public String getSpecialName(){
        return "Morale";
    }

    public void setSpecial(int n){
        this.morale = Math.min(n,moraleMax);
    }

    public int getSpecialMax(){
        return moraleMax;
    
    }    
    public boolean canSupport(){
        return getHP>0 || counter<4;
    }
    public String attack(Adventurer other){
        // if (this.getCorrupted()){
        //     int damage = (int)(Math.random()*2)+1;
        //     this.applyDamage(damage); //self
        //     restoreSpecial(1);
        //     return this.getName()+ " fires a plasma rifle at themselves for " + damage + " damage because they were corrupted";
        // }
        if (this.getWeaponStatus()){
            int damage = (int)(Math.random()*2)+1;
            other.applyDamage(damage); //once
            restoreSpecial(1);
            return this.getName()+ " fires a plasma rifle at " +other.getName()+ " for " + damage + " damage.";
        }
        else{
           super.changeWeaponStatus(true);
          return this + "'s attacks has been disabled for 1 round.";
        }
    }

    public String specialAttack(Adventurer other,ArrayList<Adventurer> enemies){
        // if (this.getCorrupted()){
        //     int damage = (int)(Math.random()*2)+1;
        //     this.applyDamage(damage); //self
        //     restoreSpecial(1);
        //     return this.getName()+ "couldn't use their special because they were corrupted. Instead, they fires a plasma rifle at themselves for " + damage + " damage.";
        // }
        if (this.getWeaponStatus()){
            if(morale >=4){
                setSpecial(morale-4);
                int damage = 10;
                int splashDamage = 3;

                other.applyDamage(damage); //main damage
                for(Adventurer enemy: enemies){
                    if(enemy != other){
                        enemy.applyDamage(splashDamage);
                    }
                } 
                return this.getName() + " also tosses a Grenade, dealing " + damage + " damage to " + other.getName() + " and " + splashDamage + " splash damage.";
            } else {
                return this.getName()+ " doesn't have enough morale.";
            }
        }else{
            super.changeWeaponStatus(true);
            return this.getName() + "'s weapons has been disabled for 1 round. Couldn't attack.";
        }
    }

    public String specialAttack(Adventurer others){
        return "Special attack requires a list of enemies.";
    }
    
    public String support(){
        if (getHP()>0){
            return this.getName() + " is still alive, no need for reinforcements.";
        }
        if (counter<4){
            counter++;
            this.setHP(12);
            this.morale=0;
            return this.getName() + " is calling reinforcements! ";
        } 
        return this.getName() + " cannot call more reinforcements";
        }

    public String support(ArrayList<Adventurer> party){
        if (getHP() <= 0 && counter < 4){
            counter++;
            this.moraleMax = 6;
            this.morale = 0;
            this.setHP(12);
            for(Adventurer ally: party){
                ally.restoreSpecial(1);
            }
            return this.getName() + " is calling reinforcements, restoring themselves, and boosts morale";
        } else if (getHP()<=0){
            return this.getName() + " cannot call more reinforcements.";
        } else {
            return this.getName() + " is still alive, no need for reinforcements";
        }
    }

    public String support(Adventurer other){
        other.restoreSpecial(1);
        return this.getName() + " boosts " + other.getName() + "'s morale by 1";
    }

// ### Death Korps Guardsman (12 HP)
// **Normal Attack**: Lasgun Shot (1-2 dmg)
// - Guardsman fires a single shot from their lasgun due to their inferior physical abilities. 

// **Special**: Fragment Grenade - (6 dmg + 2 splash dmg)
// - Guardsman tosses a grenade, dealing 10 damage to a target and 3 splash damage to adjacent enemies.

// **Support**: Call Reinforcements
// - Summons another Guardsman. Each added reinforcement adds 8HP and 4 damage to the Guardsmen. Maximum of 4 reinforcements per match.

// **Special Resource**: Morale and Grit (4 for each special) 
// -make a variable named morale how many turns that particular guardsman has survived this is directly proportional to how many reinforcements have been called with a maximum of +4.

}
