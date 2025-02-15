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
        this(name,40);
    }
    
    public Ultramarine(){
        this("Titus");
    }

    public String getSpecialName(){
        return "Rule";
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
        if (this.getWeaponStatus()){
          if(getSpecial() >= 5){
            setSpecial(getSpecial()-5);
            int totalDamage = 10 + this.getDamageAffect() + this.getPermanentDamageAffect();
            other.applyDamage(totalDamage);
            other.applyDamageAffect(-2);
            return this + " unleashed a Orbital Strike on " + other + ", dealing " + totalDamage +" points of damage and reducing their damage output for the next round.";
        }else{
            return "Not enough command points to use Orbital Strike (You need 5). Instead "+attack(other);
          }
        }else{
          super.changeWeaponStatus(true);
          return this + "'s attacks has been disabled for 1 round";
          }
        }

      public String specialAttack(Adventurer other, ArrayList<Adventurer> enemies){
        if (this.getWeaponStatus()){
          if(getSpecial() >= 5){
            setSpecial(0);
            for(Adventurer enemy: enemies){
              int totalDamage= (5 + this.getDamageAffect() + this.getPermanentDamageAffect());
              enemy.applyDamage(totalDamage);
              enemy.applyDamageAffect(-2);
            }
            return this + " called in a precision orbital bombardment, weakening all enemies. They will deal 4 less damage next round. Also, deals 5 splash damage to all enemies";
          }else{
            return "Not enough command points to use Orbital Strike (You need 5). Instead "+attack(other);
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