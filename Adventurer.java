import java.util.*;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP, damageEffect, permanentDamageEffect;
  private boolean weaponStatus, corrupted;

  //Abstract methods are meant to be implemented in child classes.
  /*
  all adventurers must have a custom special
  consumable resource (mana/rage/money/witts etc)
  */

  //give it a short name (fewer than 13 characters)
  public abstract String getSpecialName();
  //accessor methods
  public abstract int getSpecial();
  public abstract int getSpecialMax();
  public abstract void setSpecial(int n);

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()
  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
    return n;
  }

  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(Adventurer other);


  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public abstract String support(Adventurer other);

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);

  public abstract String specialAttack(Adventurer other, ArrayList<Adventurer> enemies);


  /*
  standard methods
  */

  public void applyDamage(int amount){
    this.HP -= amount;
  }

  public void applyDamageAffect(int n){
    this.damageEffect = n;
  }

  public void applyPermanentDamageAffect(int n){
    this.permanentDamageEffect = n;
  }

  public void changeWeaponStatus(boolean status){
    this.weaponStatus = status;
  }

  //You did it wrong if this happens.
  public Adventurer(){
    this("Lester-the-noArg-constructor-string");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
    this.damageEffect = 0;
    this.permanentDamageEffect = 0;
    this.weaponStatus = true;
    this.corrupted = false;
  }

  //toString method
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }

  public int getDamageAffect(){
    int temp = this.damageEffect;
    this.damageEffect = 0;
    return temp;
    
  }

  public int getPermanentDamageAffect(){
    return permanentDamageEffect;
  }

  public boolean getWeaponStatus(){
    boolean temp = weaponStatus;
    weaponStatus = true;
    return temp;
  }

  public boolean getCorrupted(){
    boolean temp = corrupted;
    corrupted = false;
    return temp;
  }

  public void setmaxHP(int newMax){
    maxHP = newMax;
  }

  //Set Methods
  public void setHP(int health){
    //make sure hp doesn't go over max hp
    this.HP = Math.min(health,getmaxHP());
  }

  public void setName(String s){
    this.name = s;
  }

  public void setCorrupted(boolean status){
    this.corrupted = status;
  }
}
