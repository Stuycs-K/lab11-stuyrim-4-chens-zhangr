[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Required Features ## 

:white_check_mark: Play with a group of 3 different types adventurers.

:white_check_mark: Play against 1-3 randomly chosen adventurer opponents (You can play with up to 4!).

:white_check_mark: Use attack/special operations on your opponents.

:white_check_mark: Use support operations on your team.

:white_check_mark: Program ends when the user choosed to quit, or all enemies is defeated, or the entire party is defeated. A win/lose screen is useful here.

:white_check_mark: Display the results of the attack/special/support inside your border. Do not print things at the bottom of the screen or it will scroll.

:white_check_mark: Have a special boss class adventurer for when a single opponent is selected.

## Adventurer Subclasses

### Ultramarines (40 HP)
**Normal Attack**: Bolt Barrage (5-6 dmg)
- Ultramarine fires a volley from their boltgun at the enemy
  
:white_check_mark: Normal Attack functions hits targeted enemy for 5-6 dmg

**Special**: Orbital Strike (-4 dmg next round + 3 splash dmg)
- Ultramarine calls in a precision orbital bombardment, dealing either 10 damage or 5 splash damage of dmg to all enemies and weakening them making them do 2 less damage next round.

**Special Resource**: Rule (5 for each special)

  - :white_check_mark: is correctly added when using a normal attack 
        
  - :white_check_mark: is correcly used, then disappears when using special
        
:white_check_mark: Single-Target Orbital Strike

  - :white_check_mark: Uses and checks for 5 resource 
        
  - :white_check_mark: Deals 10 damage to the targeted enemy 

  - :white_check_mark: Lowers Enemy damage by 2 next round 
        
  - :white_check_mark: If you can't use it you're forced to use a normal attack

:question: Multi-Target Orbital Strike 

  - :white_check_mark: Uses and checks for 5 resource 
        
  - :white_check_mark: coded to deal 5 damage to all enemies
        
  - :white_check_mark: coded to lower enemy damage by 2 
        
  - :beetle: can't be called within the game


**Support**: Logistics Wins Wars
- Ultramarine uses its superior logistical and management skills to bring extra supplies either to themself or a single ally, providing a boost of +4 hp. 

  :white_check_mark: Self Heals the UltraMarine by +4 HP
  
  :white_check_mark: Ally Heals for +4 HP
  
### Adeptus Mechanicus (30 HP)
**Normal Attack**: Radium Barrage (3-4 dmg)
- Adeptus Mechanicus fires a burst of radioactive rounds at their enemy.
  
  :white_check_mark: Deals 3-4 damage to the selected target
  
  :white_check_mark: Gains 1 MSE when attacking

**Special**: Omnissiah's Wrath 
- Adeptus Mechanicus calls on the power of the machine god to deal 6 to 7 damage and will disable the weapon of one of the opponents for the next attack/special attack. (ie, effect only gets removed on their next attack. If they support on their next move, then it still be there.)

  :white_check_mark: deals 6 to 7 damage to the targeted enemy
  
  :question: outputs a line that tells you if your weapon is disabled or enabled but doesn't actually enable or disable them

  
**Support**: Upgrade Agreement 
- Adeptus Mechanicals uses its technical skills to upgrade the weapon of either themself or a single ally, providing a boost of +3 dmg for the rest of the game. Can only be used once per person.

  :white_check_mark: provides a permanent +3 damage boost
  
  :white_check_mark: can only be given once per game
  

**Special Resource**: Machine Spirit Energy (3 for each special max of 5)

  :white_check_mark: you need 3 resource to use a special attack
  
  :white_check_mark: max of 5 energy 
  
  :white_check_mark: restore +1 on each normal or special attack

### Death Korps Guardsman (20 HP)
**Normal Attack**: lasgun Shot (1-2 dmg)
- Guardsman fires a single shot from their lasgun due to their inferior physical abilities.
  
  :white_check_mark: damages targeted enemy for 1 to 2 damage 

**Special**: Fragment Grenade - (10 dmg + 3 splash dmg)
- Guardsman tosses a grenade, dealing 10 damage to a target and 3 splash damage to adjacent enemies.
  
  :white_check_mark: deals 10 damage to the main target
  
  :white_check_mark: deals 3 splash damage to any other enemies present

**Support**: Call Reinforcements
- Summons another Guardsman upon defeat. Each reinforcement arrives with same health and same abilities (resurrects), restore the entire party's special by 1 or target's special by 1 if it's alive. Maximum of 4 reinforcements per match.
  
  :white_check_mark: when used on others it restores 1 resource

  :white_check_mark: self-resurrection with 20 HP
  

**Special Resource**: Morale (4 for each special) 

  :white_check_mark: need 4 morale to be able to use your special

  :white_check_mark: gain a morale though attacking


### BOSS - Horus Lupercal (100 HP)
**Normal Attack**: Worldbreaker Strike (7-9 dmg)
- Horus delivers a hard strike, dealing damage to a single target.

  :white_check_mark: deals 7 to 9 damage to the targeted adventurer 
  

**Special**: Eye of Terror 
- Horus releases a wave of warp energy, corrupting the mind of one enemy so that they leave themselves open, causing 25 damage to be dealt.

  :white_check_mark: damages selected adventurer for 18 damage


**Support**: Dark Corruption 
- Horus heals for 10 HP and grants himself immunity to all status effects for 1 turn.

  :white_check_mark: heals Horus for 10 HP

  :white_check_mark: immune to all status effects for 1 turn

**Special Resource**: Warp Corruption (at least 7 for each special)

  :white_check_mark: gives Horus 1-2 Warp corruption per normal attack

  :white_check_mark: uses all of its Corrution Warp as long as its above 7 

  



