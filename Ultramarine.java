import java.util.*;

public class Ultramarine extends Adventurer{

    private int commandPointMax, commandPoint;

    public Ultramarine(String name, int hp, int commandPointMax, int commandPoint){
        super(name,hp);
        this.commandPointMax = commandPointMax;
        this.commandPoint = commandPoint;
    }

    public Ultramarine(String name, int hp){
        this(name,hp, 5, 0);
    }
    
    public Ultramarine(String name){
        this(name,30);
    }
    
    public Ultramarine(){
        this("Titus");
    }

    public String getSpecialName(){
        return "Command Points";
      }
    
      public int getSpecial(){
        return commandPoint;
      }
    
      public void setSpecial(int n){
        this.commandPoint= Math.min(n,commandPointMax);
      }
    
      public int getSpecialMax(){
        return commandPointMax;
      }
    
      public String attack(Adventurer other){
        if (this.getCorrupted()){
          int damage = (int)(Math.random()*3)+ 4 + this.getDamageAffect() + this.getPermanentDamageAffect();
          this.applyDamage(damage);
          return this + " attacked themselves and dealt "+ damage +
          " points of damage because they were corrupted";
      }
        if (this.getWeaponStatus()){
          int damage = (int)(Math.random()*3)+ 4 + this.getDamageAffect() + this.getPermanentDamageAffect();
          other.applyDamage(damage);
          restoreSpecial(1);
          return this + " attacked "+ other + " and dealt "+ damage +
          " points of damage. They then charged their command authority by 1";
        }
        else{
          this.changeWeaponStatus(true);
          return this + "'s attacks has been disabled for 1 round.";
        }
        
      }
    
    
      public String specialAttack(Adventurer other){
        return " ";
      }

      public String specialAttack(Adventurer other, ArrayList<Adventurer> enemies){
        if (this.getCorrupted()){
          int damage = (int)(Math.random()*3)+ 4 + this.getDamageAffect() + this.getPermanentDamageAffect();
          this.applyDamage(damage);
          return this + " couldn't use their special because they were corrutped. Instead, they attacked themselves and dealt "+ damage;
      }
        if (this.getWeaponStatus()){
          if(getSpecial() == 5){
            setSpecial(0);
            for(Adventurer enemy: enemies){
              enemy.applyDamage(5 + this.getDamageAffect() + this.getPermanentDamageAffect());
              enemy.applyDamageAffect(-2);
            }
            return this + " called in a precision orbital bombardment, weakening all enemies. They will deal 4 less damage next round. Also, deals 5 splash damage to all enemies";
          }else{
            return "Not enough command points to use Orbital Strike. Instead "+attack(other);
          }
        }
        else{
          super.changeWeaponStatus(true);
          return this + "'s attacks has been disabled for 1 round";
          }
        }
        
      /*Restores 5 special to other*/
      public String support(Adventurer other){
        //implement way to change damage for only 1 round
        if (this.getCorrupted()){
          return this + " is corrupted, can't help their teammates";
      }
        other.setHP(other.getHP() + 4);
        return this + " uses his superior logistical skills to bring extra supplies to " + other + ", boosting their health by 4";
      }
      /*Restores 6 special and 1 hp to self.*/
      public String support(){
        if (this.getCorrupted()){
          return this + " is corrupted, can't help themself";
      }
        this.setHP(this.getHP() + 4);
        return this + " uses his superior logistical skills to bring extra supplies to himself, boosting his health by 4";
      }
      
    }