public class Ultramarine extends Adventurer{

    private int commandPointMax, commandPoint;

    public Ultramarine(String name, int hp, int commandPointMax, int commandPoint){
        super(name,hp);
        this.commandPointMax = commandPointMax;
        this.commandPoint = commandPoint;
    }

    public Ultramarine(String name, int hp){
        this(name,hp, 0, 5);
    }
    
    public Ultramarine(String name){
        this(name,30);
    }
    
    public Ultramarine(){
        this("Titus");
    }

    public String getSpecialName(){
        return "Bolt Barrage";
      }
    
      public int getSpecial(){
        return commandPoint;
      }
    
      public void setSpecial(int n){
        commandPoint = n;
      }
    
      public int getSpecialMax(){
        return commandPointMax;
      }
    
      public String attack(Adventurer other){
        int damage = (int)(Math.random()*3)+ 4 + super.getDamageAffect();
        other.applyDamage(damage);
        restoreSpecial(1);
        return this + " attacked "+ other + " and dealt "+ damage +
        " points of damage. They then charged their command authority by 1";
      }
    
    
      public String specialAttack(Adventurer other){
        if(getSpecial() == 5){
          setSpecial(0);
          int damage = (int)(Math.random()*5+Math.random()*5)+3;
          other.applyDamage(damage);
          return this + "called in a precision orbital bombardment, dealing 15 damage to " + other + " and 5 splash damage to adjacent enemies";
        }else{
          return "Not enough command points to use Orbital Strike. Instead "+attack(other);
        }
    
      }
      /*Restores 5 special to other*/
      public String support(Adventurer other){
        //implement way to change damage for only 1 round
        other.applyDamageAffect(4);
        return this + "uses his superior logistical skills to bring extra supplies to " + other + ", boosting their damage by 4";
      }
      /*Restores 6 special and 1 hp to self.*/
      public String support(){
        this.applyDamageAffect(4);
        return this + "uses his superior logistical skills to bring extra supplies to himself, boosting his damage by 4";
      }
      
}