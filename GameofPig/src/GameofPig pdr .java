 import java.util.Scanner;
 import java.util.Random;

 public class Game
 {
	static int turnscore = 0;
	static int turnscore2 = 0;
	static int totalscore = 0;
	static int totalscore2 = 0;
	static int dice1;
	static int dice2;
	static boolean turnOver = false; 
	static char decision;
	static String input; 
	static  Scanner keyboard = new Scanner(System.in);
	
	
	// static Random rand = new Random(); 
	 
	

 	static void playerturn(){
 		//turnscore = 0;
	while (turnOver == false){
		System.out.println("Your Turn!");
		dice1 = diceroll(dice1);
		dice2 = diceroll(dice2);
		System.out.println("You Rolled a " + dice1 + " and a "+ dice2);
		
		
			if (dice1 == 1 ^ dice2 == 1){
				turnscore = 0;
				System.out.println("You lose your turn" + "\n" + "Your total score is " + " " + totalscore);
				turnOver = true; 	
				}
			
			else if (dice1 == 1 &&  dice2==1 ){
				turnscore = 0;
				totalscore = 0;
				System.out.println("You rolled two ones, You lose your turn, and your score!");
				turnOver = true;
				}
			else if (dice1 == dice2){
				playerturn();
				break;
				}
			else { 
				turnscore = turnscore + dice1 + dice2;
				//totalscore = turnscore; 
				System.out.println("Your Turn Score is" + " " +turnscore + "\n" + "If you pass you will have a score of"+ " " +totalscore + "\n" + "Enter 'r' to roll, " + "or 'p' to pass the turn");
				input = keyboard.nextLine();
				decision = input.charAt(0);
				
				if(decision == 'p'){
					turnOver = true; 
				}
				}
			
			
			
		}
	
	System.out.println("\n");
	turnOver = false;
	turnscore = 0;

	}

	static void computerturn(){
		//turnscore2 = 0;
		while (turnOver == false ^ turnscore2 <= 30){
			dice1 = diceroll(dice1);
			dice2 = diceroll(dice2);
			System.out.println("Computer Rolled a " + dice1 +" and a "+ dice2);
				if (dice1 == 1 ^ dice2 == 1){
					turnscore2 = 0;
					System.out.println("The computer lost its turn" + "\n" + "The computers score is" + " " + totalscore2);
					turnOver = true; 	
					}
				
				else if (dice1 == 1 &&  dice2==1 ){
					turnscore2 = 0;
					totalscore2 = 0;
					System.out.println("The computer rolled two ones" + "\n" + "The computer lost its turn, his score is zero");
					turnOver = true;
					}
				else if (dice1 == dice2){
					System.out.println("Doubles! Roll Again!");
					computerturn();
					break;
					}
				else { 
					turnscore2 = turnscore2 + dice1 + dice2;
					//totalscore2 = turnscore2; 
					System.out.println("Computers turn score is" + " " +turnscore2 + "\n" + "If it passes it will have a total score "+ " " + totalscore2);
					
					}
				
				
				}
		 turnOver = false;
		 turnscore = 0; 
		 System.out.println("\n");
		}	
	
	static int diceroll(int dice) {
		dice = (int) Math.floor(Math.random() * 6) + 1;
		return dice;
	}
	
	public static void main(String[] args)
 {
	System.out.println("Welcome to Spencer's Game of Pig!\n");
		
	while(totalscore <100 && totalscore2 < 100)
	{
		turnscore = 0;
		playerturn();
		turnscore2 = 0; 
		computerturn();
		
		totalscore = totalscore + turnscore;
		totalscore2 = totalscore2 + turnscore2; 
		
		System.out.println("Player Score is"+ " " + turnscore + "  computer score is" +" " + turnscore2 );
		System.out.println("Press y to continue!");
		
		while (true){
		input = keyboard.nextLine();
		decision = input.charAt(0);
		break;
		}
		

 }	
 }


private static void printDiceRolls(int dice1, int dice2, String player) {
		
		String diceOne = null, diceTwo = null;
		
		// case statement is used to determine what roll was fed into the function and print out appropriate words.
		switch(dice1){
		case 1: diceOne = "one";
				break;
		case 2: diceOne = "two";
		break;
		case 3: diceOne = "three";
		break;
		case 4: diceOne = "four";
		break;
		case 5: diceOne = "five";
		break;
		case 6: diceOne = "six";
		break;
		}
		
		switch(dice2){
		case 1: diceTwo = "one";
				break;
		case 2: diceTwo = "two";
		break;
		case 3: diceTwo = "three";
		break;
		case 4: diceTwo = "four";
		break;
		case 5: diceTwo = "five";
		break;
		case 6: diceTwo = "six";
		break;
		}
		
		System.out.println("\n" + player + "'s  Turn:");
		System.out.println(player + " rolled: " + diceOne + " + " + diceTwo);
		
	}



















 
 }