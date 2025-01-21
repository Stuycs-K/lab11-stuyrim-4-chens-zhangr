import java.util.*;
public class Boss extends Adventurer {
    
    private int warpCorruptionMax, warCorruption;
    private boolean statusImmunity;

    public Boss(String name, int hp, int warpCorruptionMax, int warCorruption){
        super(name,hp);
        this.warpCorruptionMax = warpCorruptionMax;
        this.warCorruption = warCorruption;
        this.statusImmunity = false;
    }

    public Boss(String name, int hp){
        this(name,hp, 10, 0);
    }
    
    public Boss(String name){
        this(name,100);
    }
    
    public Boss(){
        this("Horus");
    }

    public String getSpecialName(){
        return "Chaos Points";
      }
    
      public int getSpecial(){
        return warCorruption;
      }
    
      public void setSpecial(int n){
        warCorruption = n;
      }
    
      public int getSpecialMax(){
        return warpCorruptionMax;
      }

      public boolean getStatusImmunity(){
        return statusImmunity;
      }

      public void setStatusImmunity(boolean status){
        this.statusImmunity = status;
      }
    
      public String attack(Adventurer other){
        if (this.getWeaponStatus() && this.getStatusImmunity()){
          int damage = (int)(Math.random()*3)+ 7;
          other.applyDamage(damage);
          restoreSpecial(10);
          this.setStatusImmunity(false);
          return this + " attacked "+ other + " and dealt "+ damage +
          " points of damage. They then charged their warp corruption by 1";
        }
        else if (this.getWeaponStatus()){
          int damage = (int)(Math.random()*3)+ 7 + this.getDamageAffect();
          other.applyDamage(damage); //once
          restoreSpecial(10);
          return this + " attacked "+ other + " and dealt "+ damage +
          " points of damage. They then charged their warp corruption by 1";
        }
        else{
          super.changeWeaponStatus(true);
          return this + "'s weapons has been disabled for 1 round. Couldn't attack.";
        }
      }
    
    
      public String specialAttack(Adventurer other){
        if(getSpecial() >= 7){
          setSpecial(0);
          //todo: figure out corruption system
          int damage = 25;
          other.applyDamage(damage); //once
          return this + " used Eye of Terror and dealt " + damage + " damage to "+  other + ".";
        }else{
          return "Not enough corruption points to use Eye of Terror. Instead "+attack(other);
        }
    
      }

      public String specialAttack(Adventurer other, ArrayList<Adventurer> enemies){
        return this.specialAttack(other);
      }

      public String support(){
        this.setHP(this.getHP() + 10);
        this.setStatusImmunity(true);
        return this + " heals for 10 HP and grants himself immunity to all status effects for 1 turn.";
      }

      public String support(Adventurer other){
        return this.support();
      }

}
