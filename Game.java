import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
	run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){

	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	//YOUR CODE HERE
	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    for (int i = 1; i <= 30; i++) {
        Text.go(i, 0); 
        System.out.println("║");
        Text.go(i, 80); 
        System.out.println("║");
    }

    for (int i = 1; i <= 80; i++) {
        Text.go(1, i); 
        System.out.println("═");
		Text.go(5, i);
		System.out.println("═");
		Text.go(25, i);
		System.out.println("═");
        Text.go(HEIGHT, i); 
        System.out.println("═");
    }
	Text.go(1,1);
	System.out.println("╔");
	Text.go(1,80);
	System.out.println("╗");
	Text.go(5,1);
	System.out.println("╠");
	Text.go(5,80);
	System.out.println("╣");
	Text.go(25,1);
	System.out.println("╠");
	Text.go(25,80);
	System.out.println("╣");
	Text.go(30,1);
	System.out.println("╚");
	Text.go(30,80);
	System.out.println("╝");
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.

  public static void drawText(String s,int startRow, int startCol){
	Text.go(startRow, startCol);
	System.out.print(s);
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	//YOUR CODE HERE
	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    int currentRow = row;
    int heightCounter  = 0;

    while (!text.isEmpty() && heightCounter <= height) {
        String line;
        if (text.length() > width) {
            line = text.substring(0, width);
            text = text.substring(width);
        } else {
            line = text;
            text = "";
        }
        Text.go(currentRow, col);
        System.out.print(line);

        currentRow++;
        heightCounter++;
    }
  }


	//return a random adventurer (choose between all available subclasses)
	//feel free to overload this method to allow specific names/stats.
	public static Adventurer createRandomAdventurer(){
  		Random rand = new Random();
		int random = rand.nextInt(3) + 1;
		if (random == 1){
			return new Guardsman();
		}
		else if (random == 2){
			return new Mechanicus();
		}
		return new Ultramarine();
	}

	/*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
	*Should include Name HP and Special on 3 separate lines.
	*Note there is one blank row reserved for your use if you choose.
	*Format:
	*Bob      	Amy    	Jun
	*HP: 10   	HP: 15 	HP:19
	*Caffeine: 20 Mana: 10   Snark: 1
	* ***THIS ROW INTENTIONALLY LEFT BLANK***
	*/
	public static void drawParty(ArrayList<Adventurer> party,int startRow){
		int numSlots=4;
		int increment =(WIDTH-2)/numSlots;
		for(int i = 0; i<numSlots;i++){
			for (int j = 0;j<4;j++){
				Text.go(startRow+j,i*increment+2);
				System.out.print(" ". repeat(increment-1));
			}
		}
		for(int i = 0; i < party.size(); i ++){
			Adventurer member = party.get(i);

			Text.go(startRow, i * increment + 2);
			System.out.print(member.getName());

			Text.go(startRow + 1, i * increment + 2);
			int displayHP = Math.max(0,member.getHP());
			System.out.println("HP: " + colorByPercent(member.getHP(), member.getmaxHP()));

			Text.go(startRow + 2, i * increment + 2);
			System.out.println(member.getSpecialName() + ": " +  member.getSpecial());

			Text.go(startRow+3,i*increment +2);
			System.out.println("");
		}
		drawBackground();
	}


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
	String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
	double percent = (double) hp / maxHP*100;
	if (percent < 25){
		return Text.colorize(output,Text.RED);
	}else if (percent<75){
		return Text.colorize(output, Text.YELLOW);
	}else{
		return Text.colorize(output, Text.WHITE);
	}
	//COLORIZE THE OUTPUT IF HIGH/LOW:
	// under 25% : red
	// under 75% : yellow
	// otherwise : white
  }



  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer>party, ArrayList<Adventurer>enemies){

	drawBackground();

	//draw player party
	drawParty(party, 2);

	//draw enemy party
	drawParty(enemies, 26);
  }

  private static void removeDeadUnits(ArrayList<Adventurer> list){
	Iterator<Adventurer> iterator = list.iterator();
	while(iterator.hasNext()){
		Adventurer unit= iterator.next();
		if (unit.getHP()<=0){
			iterator.remove();
		}
	}
  }

  public static String userInput(Scanner in){
  	//Move cursor to prompt location
	Text.showCursor();
  	//show cursor

  	String input = in.nextLine();

  	//clear the text that was written
	Text.hideCursor();
  	return input;
  }

  public static void quit(){
	Text.reset();
	Text.showCursor();
	Text.go(HEIGHT + 1,1);
  }

  public static void run(){
	//Clear and initialize
	Text.hideCursor();
	Text.clear();


	//Things to attack:
	//Make an ArrayList of Adventurers and add 1-3 enemies to it.
	//If only 1 enemy is added it should be the boss class.
	//start with 1 boss and modify the code to allow 2-3 adventurers later.
	ArrayList<Adventurer>enemies = new ArrayList<>();
	ArrayList<Adventurer>party=new ArrayList<>();

	boolean isBoss = false;
	Random rand = new Random();

	int numEnemies = rand.nextInt(3) + 1;
	if (numEnemies == 1){
		isBoss = true;
		enemies.add(new Boss());
	}
	else{
		for (int i = 0; i < numEnemies; i ++){
			enemies.add(createRandomAdventurer());
		}
	}

	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	//YOUR CODE HERE
	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

	//Adventurers you control:
	//Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
	for (int i = 0; i < 3; i ++){
		party.add(createRandomAdventurer());
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	//YOUR CODE HERE
	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


	boolean partyTurn = true;
	int whichPlayer = 0;
	int whichOpponent = 0;
	String input = "";//blank to get into the main loop.
	Scanner in = new Scanner(System.in);
	//Draw the window border
	String preprompt = "Enter command for "+party.get(whichPlayer)+": (a)ttack/(sp)ecial/(su)pport/(q)uit ";

	String prompt = preprompt;
	drawScreen(party, enemies);//initial state.
	drawText(preprompt,HEIGHT-1,2);


	
	while(!(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
		//You can add parameters to draw screen!
		//Main loop

		if(party.isEmpty()){
			Text.clearLine(6);
			Text.clearLine(7);
			Text.clearLine(8);
			TextBox(6,2,WIDTH-4,2, "All your allies have fallen! You have been defeated.");
			quit();
			return;
		}
		
		if(enemies.isEmpty()){
			Text.clearLine(6);
			Text.clearLine(7);
			Text.clearLine(8);
			TextBox(6,2,WIDTH-4,2, "All your enemies have fallen! Glory to the Space King");
			quit();
			return;
		}

		drawScreen(party, enemies); 
		//Read user input		

  	//example debug statment
  	// TextBox(24,2,WIDTH-4,1,"Input: "+input+" partyTurn:"+partyTurn);

  	//display event based on last turn's input
  	if(partyTurn){
		if (whichPlayer>= party.size()){
			partyTurn=false;
			whichOpponent=0;
			prompt= "Press enter to see monster's turn.";
			continue;
		}

		Adventurer player = party.get(whichPlayer);
		Text.clearLine(29);
		drawText(prompt,HEIGHT-1,2);
		
		input = userInput(in);
		if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")){
			break;
		}
		String[] parts = input.trim().toLowerCase().split("\\s+"); 
		// \\s+ basically splits the string into one or more parts I used it to remove any extra space 
		if (parts.length<2){
			Text.clearLine(6);
			Text.clearLine(7);
			Text.clearLine(8);
			TextBox(6,2,WIDTH -4, 2, "Invalid Input! Please use 'command [index]'");
			continue;
		}
		String action=parts[0];
		int targetIndex;

		try{
			targetIndex= Integer.parseInt(parts[1]);
		}catch (NumberFormatException e){
			Text.clearLine(6);
			Text.clearLine(7);
			Text.clearLine(8);
			TextBox(6,2,WIDTH-4,2,"Invalid Input! Please put a number.");
			continue;
		}

    	//Process user input for the last Adventurer:
    	if(action.equals("attack") || action.equals("a")){
      	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      	//YOUR CODE HERE
			if(targetIndex>=0&& targetIndex<enemies.size()){
		  	Text.clearLine(6);
			Text.clearLine(7);
			Text.clearLine(8);
			TextBox(6,2,WIDTH-4,2, player.attack(enemies.get(targetIndex)));
			removeDeadUnits(enemies);
			}else{
				Text.clearLine(6);
		  		Text.clearLine(7);
		 		 Text.clearLine(8);
				TextBox(6,2,WIDTH-4,2, "Invalid Target.");
				continue;
			}
      	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    	}
    	else if(action.equals("special") || action.equals("sp")){
      	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      	//YOUR CODE HERE
			if(targetIndex>=0&& targetIndex<enemies.size()){
		  	Text.clearLine(6);
			Text.clearLine(7);
			Text.clearLine(8);
			TextBox(6,2,WIDTH-4,2, player.specialAttack(enemies.get(targetIndex)));
			removeDeadUnits(enemies);
			}else{
				Text.clearLine(6);
		 		Text.clearLine(7);
		 		Text.clearLine(8);
				TextBox(6,2,WIDTH-4,2, "Invalid Target.");
				continue;
			}
      	/*<<<<<<<<
      	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    	}
    	else if(action.equals("support") || action.equals("su")){
      	//"support 0" or "su 0" or "su 2" etc.
      	//assume the value that follows su is an integer.
      	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      	//YOUR CODE HERE
			if(targetIndex>=0&& targetIndex<party.size()){
		  	Text.clearLine(6);
			Text.clearLine(7);
			Text.clearLine(8);
			TextBox(6,2,WIDTH-4,2, player.support(party.get(targetIndex)));
			}else{
				TextBox(6,2,WIDTH-4,2, "Invalid Target.");
				continue;
			}
      	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    	}else{
		  Text.clearLine(6);
		  Text.clearLine(7);
		  Text.clearLine(8);
		  TextBox(6,2,WIDTH-4,2,"Invalid input! Please Try Again.");
		  continue;
		}
		whichPlayer++;
		
		if(whichPlayer < party.size()){ 
			//This is a player turn.
			//Decide where to draw the following prompt:
			// Text.go(HEIGHT - 1, 2);
			prompt = "Enter command for "+party.get(whichPlayer)+": (a)ttack/(sp)ecial/(su)pport/(q)uit ";
			// drawText(prompt,HEIGHT-1,2);
		  }else{
			//This is after the player's turn, and allows the user to see the enemy turn
			//Decide where to draw the following prompt:
			prompt = "Press enter to see monster's turn ";
			// Text.go(HEIGHT - 1, 2);
			// drawText(prompt,HEIGHT-1,2);
			partyTurn = false;
			whichOpponent = 0;
		}

    	//You should decide when you want to re-ask for user input
    	//If no errors:
      	//This is a player turn.
      	//Decide where to draw the following prompt:

    	//done with one party member
  	}else{
		Text.clearLine(29);
		drawText(prompt,HEIGHT-1,2);
		
		input = userInput(in);
    	//not the party turn!
		int numMoves;
		if (isBoss) numMoves = 3;
		else numMoves = 4;
		
			Adventurer currentEnemy = enemies.get(whichOpponent);

			int move = rand.nextInt(numMoves);
			if (move == 0){
				Text.clearLine(6);
				Text.clearLine(7);
				Text.clearLine(8);
				int randomPerson = rand.nextInt(party.size());
				TextBox(6,2,WIDTH-4,2,currentEnemy.attack(party.get(randomPerson)));
				removeDeadUnits(party);

			}
			else if (move == 1){
				Text.clearLine(6);
				Text.clearLine(7);
				Text.clearLine(8);
				int randomPerson = rand.nextInt(party.size());
				if (currentEnemy.getSpecial()>= currentEnemy.getSpecialMax()){
					TextBox(6,2,WIDTH-4,2,currentEnemy.specialAttack(party.get(randomPerson)));
				}
				else {
					TextBox(6,2,WIDTH-4,2,currentEnemy.getName()+ " tried to use their special but lacked enough " + currentEnemy.getSpecialName()+ "so it attacked instead.");
					TextBox(6,2,WIDTH-4,2,currentEnemy.specialAttack(party.get(randomPerson)));
				}
				removeDeadUnits(party);
				// currentEnemy.specialAttack(party.get(randomPerson));
				// TextBox(6,2,WIDTH-4,2,currentEnemy.specialAttack(party.get(randomPerson)));
			}
			else if (move == 2){
				Text.clearLine(6);
				Text.clearLine(7);
				Text.clearLine(8);
				if (currentEnemy.getHP()>= currentEnemy.getmaxHP()||currentEnemy.getSpecial()>= currentEnemy.getSpecialMax()){
					TextBox(6,2,WIDTH-4,2,currentEnemy.support());
				}
				else {
					TextBox(6,2,WIDTH-4,2,currentEnemy.getName()+ " decided not to heal or boost as they forgot they're already in top condition.");
				}
			}
			else if (move == 3){
				Text.clearLine(6);
				Text.clearLine(7);
				Text.clearLine(8);
				int randomPerson = rand.nextInt(enemies.size());
				currentEnemy.support(enemies.get(randomPerson));
				TextBox(6,2,WIDTH-4,2,currentEnemy.support(enemies.get(randomPerson)));
			}

		

		prompt = "press enter to see monster's turn ";
		whichOpponent++;

    	//enemy attacks a randomly chosen person with a randomly chosen attack.z`
    	//Enemy action choices go here!
    	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    	//YOUR CODE HERE
    	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


    	//Decide where to draw the following prompt:
  	//end of one enemy.

  	//modify this if statement.
	}
	 //modify this if statement.
	 if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
		whichOpponent = 0;
        whichPlayer = 0;
        partyTurn=true;
        //display this prompt before player's turn
		if (!party.isEmpty()){
        prompt = "Enter command for "+party.get(whichPlayer)+": (a)ttack/(sp)ecial/(su)pport/(q)uit ";
      }
	 }

      //display the updated screen after input has been processed.

	}//end of main game loop


	//After quit reset things:
	quit();
  }
}