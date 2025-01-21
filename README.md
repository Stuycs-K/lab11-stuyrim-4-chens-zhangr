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

:white_check_mark: play with a group of 3 different types adventurers.


:white_check_mark: play against 1-3 randomly chosen adventurer opponents (You can play with up to 4!).
:white_check_mark: use attack/special operations on your opponents.

:white_check_mark: use support operations on your team.

:white_check_mark: program ends when the user choosed to quit, or all enemies is defeated, or the entire party is defeated. A win/lose screen is useful here.

:white_check_mark: display the results of the attack/special/support inside your border. Do not print things at the bottom of the screen or it will scroll.

:white_check_mark: have a special boss class adventurer for when a single opponent is selected.

## Adventurer Subclasses

### Ultramarines (30 HP)
**Normal Attack**: Bolt Barrage (5-6 dmg)
- Ultramarine fires a volley from their boltgun at the enemy

**Special**: Orbital Strike (-4 dmg next round + 3 splash dmg)
- Ultramarine calls in a precision orbital bombardment, dealing splash damage of 3 dmg to all enemies and weakening them. Their next attack/special attack will deal 4 less damage (ie, damage effect only gets removed on their next attack)

**Support**: Logistics Wins Wars
- Ultramarine uses its superior logistical and management skills to bring extra supplies either to themself or a single ally, providing a boost of +4 hp. 

**Special Resource**: Command Points (5 for each special)

### Adeptus Mechanicus (20 HP)
**Normal Attack**: Radium Barrage (3-4 dmg)
- Adeptus Mechanicus fires a burst of radioactive rounds at their enemy.

**Special**: Omnissiah's Wrath 
- Adeptus Mechanicus calls on the power of the machine god to disable the weapon of one of the opponents for the next attack/special attack. (ie, effect only gets removed on their next attack. If they support on their next move, then it still be there.)

**Support**: Upgrade Agreement 
- Adeptus Mechanicals uses its technical skills to upgrade the weapon of either themself or a single ally, providing a boost of +3 dmg for the rest of the game. Can only be used once per person.

**Special Resource**: Machine Spirit Energy (3 for each special)

### Death Korps Guardsman (10 HP)
**Normal Attack**: Lasgun Shot (1-2 dmg)
- Guardsman fires a single shot from their lasgun due to their inferior physical abilities. 

**Special**: Fragment Grenade - (6 dmg + 2 splash dmg)
- Guardsman tosses a grenade, dealing 10 damage to a target and 3 splash damage to adjacent enemies.

**Support**: Call Reinforcements
- Summons another Guardsman upon defeat. Each reinforcement arrives with same health and  same abilities. Maximum of 4 reinforcements per match. Guardsmen cannot support other forces. 

**Special Resource**: Morale (4 for each special) 


### BOSS - Horus Lupercal (80 HP)
**Normal Attack**: Worldbreaker Strike (9-10 dmg)
- Horus delivers a hard strike, dealing damage to a single target.

**Special**: Eye of Terror 
- Horus releases a wave of warp energy, corrupting the mind of one enemy so that they attack themselves during the next round.

**Support**: Dark Corruption 
- Horus heals for 10 HP and grants himself immunity to all status effects for 1 turn.

**Special Resource**: Warp Corruption (5 for each special)



