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
        this(name,hp, 0, 5);
    }
    
    public Boss(String name){
        this(name,30);
    }
    
    public Boss(){
        this("Horus");
    }

    public String getSpecialName(){
        return "Eye of Terror";
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
        int damage = (int)(Math.random()*3)+ 7 + super.getDamageAffect();
        other.applyDamage(damage);
        restoreSpecial(1);
        return this + " attacked "+ other + " and dealt "+ damage +
        " points of damage. They then charged their warp corruption by 1";
      }
    
    
      public String specialAttack(Adventurer other){
        if(getSpecial() == 5){
          setSpecial(0);
          //todo: figure out corruption system
          return this + "";
        }else{
          return "Not enough corruption points to use Eye of Terror. Instead "+attack(other);
        }
    
      }
      /*Restores 6 special and 1 hp to self.*/
      public String support(){
        this.setHP(this.getHP() + 10);
        //todo: figure out corruption system
        return this + " heals for 10 HP and grants himself immunity to all status effects for 1 turn.";
      }

      public String support(Adventurer other){
        return this.support();
      };

      
}
