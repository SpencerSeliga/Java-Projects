/* James Weiss NetID : 13jmw28*/
import java.util.Scanner;
import java.util.Random;
public class Game
{
   public static void main(final String[] args)
   {
	   int HumanTotalScore = 0, ComputerTotalScore = 0;
	   String PlayerName = "";
	   Scanner keyboard = new Scanner(System.in); 
	   Random randgen = new Random(System.currentTimeMillis());
	   
	 
	   System.out.println("Each Turn Your Able To Roll Two Dice or Hold your Current Points");
	   System.out.println("If Either of The Die are one, Your Turn is over and your turn score is zero");
	   System.out.println("If you choose to hold your turn, your turn score will be added to your total score");
	   System.out.println("Each time you roll the sum of the die will be added to your turn score");
	   System.out.println("If you reach 100 total points before the computer does, you win! \n");
	   System.out.println("Pig Game Rules Above: \n");
	   
	   PlayerName = NameCheck(keyboard);
	   System.out.println("Hi " + PlayerName + " Welcome to James' Game of Pig \n");
	   PlayGame(keyboard, randgen, HumanTotalScore, ComputerTotalScore, PlayerName);
   }
   
   
   
   
   
   /*
    The convert function takes an integer and produces an output of that digit in a string
   */
   static String convert(int num){
		String[] numbers = {" ", "One", "Two","Three", "Four", "Five", "Six"};
		
		return numbers[num];
	}
	 
   /*
    The PlayGame function combines the HumanTurn & ComputerTurn & Winner methods in a while loop until winning score is reached
    */
	static void PlayGame(Scanner keyboard, Random randgen, int HumanTotalScore, int ComputerTotalScore, String PlayerName) { 
	   int turn = 1;
	   while(HumanTotalScore < 100 && ComputerTotalScore < 100) {
	   System.out.println("Would You Like To Start Turn: " + turn);
	   TurnCheck(keyboard);
	   System.out.println(PlayerName + " Turn: " + turn + " \n");
	   HumanTotalScore += HumanTurn(keyboard, randgen, HumanTotalScore, PlayerName);
	   if(HumanTotalScore < 100) {
	   System.out.println("Computer Turn: " + turn + " \n");
	   ComputerTotalScore += ComputerTurn(randgen, ComputerTotalScore, "Computer");
	   }
	   Winner(ComputerTotalScore, HumanTotalScore, PlayerName);
	   turn++; 
   }
	   
   }
	 /*
	  The winner method checks if either the human player or the computer has reached the winning score
	   */
    static void Winner(int ComputerScore, int HumanScore , String PlayerName) {
	   if(HumanScore >= 100) {
		   System.out.println(PlayerName + " Has Won The Game with " + HumanScore + " Points");
	   }
	   else if(ComputerScore >= 100) {
		   System.out.println("The Computer Has Won The Game with " + ComputerScore + " Points");
	   }
	   else {
		   
	   }
   }
    
    /*
     Turn Check keeps checking if the player is ready to commence their turn 
     by asking for a character input of 'y' or 'n;
     */
   static char TurnCheck(Scanner scan)
   {
	   System.out.println("Please Return a 'y' for yes and a 'n' for no");
	   String input; 
	   char output = 'r';
	   input = scan.nextLine();
	   try {
	   output = input.charAt(0);
	   }
	   catch(IndexOutOfBoundsException e)
	   {
		 System.out.println("IndexOutOfBoundsException: Please write to terminal 'y' or 'n'");
		 TurnCheck(scan); 
	   }
	   if(output == 'n') {
		   System.out.println("Waiting For Player To Be Ready to Play (:");
		   TurnCheck(scan); 
	   }
	   if(output != 'y' && output != 'n')
	   {
		 System.out.println("Please write to terminal 'y' or 'n'");
		 TurnCheck(scan);
	   }
	   return output; 
   }
   
   /*
    NameCheck waits for the player to enter a nickname or name, but if a blank number 
    is entered the name of the player is defaulted to "Player1"
    */
   
   static String NameCheck(Scanner scan) {
	   System.out.println("Please Write Your Name/NickName in The Terminal");
	   String name; 
	   name = scan.nextLine();
	   if (name.length() == 0)
		   return "Player 1";
	   else
		   return name; 
   }
   
   /*
    The Scanner Check Method runs until the user inputs either a 'r' for roll and 'h' 
    for hold and continuously informs the player of any mistakes in inputting their answer
    */
   static char ScannerCheck(Scanner scan) {
	   String input; 
	   char output = 'r';
	   input = scan.nextLine();
	   try {
	   output = input.charAt(0);
	   }
	   catch(IndexOutOfBoundsException e)
	   {
		 System.out.println("IndexOutOfBoundsException: Please write to terminal 'r' or 'h'");
		 ScannerCheck(scan); 
	   }
	   if(output != 'h' && output != 'r')
	   {
		 System.out.println("Please write to terminal 'r' or 'h'");
		 ScannerCheck(scan);
	   }
	   return output; 
   }
   
   /*
    Check Conditions checks if the players roll is not 1 and sets the turnscore to zero if it is 
    */
   static int check_conditions(int roll1, int roll2, int TurnScore, int TotalScore, String PlayerName) {
	   System.out.println(PlayerName + " Rolled a " + convert(roll1) + " and " + convert(roll2)); 
	   if(roll1 == 1 || roll2 == 1) {
		   System.out.println(PlayerName + " has lost their turn, their Total Score is " + TotalScore + "\n"); 
		   TurnScore = 0; 
		   return 0; 
	   }
	   else {
		   return 1;
	   }
   }
   
   /*
    The HumanTurn uses the various function to take the roll values and respond to human inputs of roll 
    or hold, in addition to calculating the score of the turn. This function returns the score to the total score 
    variable.
    */
   static int HumanTurn(Scanner scan, Random rand, int HumanTotalScore, String PlayerName) {
	int HumanTurnScore = 0;
	char output = 'r'; 
	do {
	int roll1 = rand.nextInt(6) + 1;
	int roll2 = rand.nextInt(6) + 1;
	if(check_conditions(roll1, roll2, HumanTurnScore, HumanTotalScore, PlayerName) == 1)
	{
	HumanTurnScore += (roll1+roll2);
	System.out.println("Your Turn Score is " + HumanTurnScore + " If Held Your Total Score is " + (HumanTotalScore + HumanTurnScore));
	if((HumanTotalScore + HumanTurnScore) > 100){
		return HumanTurnScore;
	}
	System.out.println("Press 'r' to roll or 'h' to hold");
	output = ScannerCheck(scan);
	if(output == 'h' && HumanTurnScore !=0)
	{
	System.out.println("You Finished The Turn With a Total Score of " + (HumanTotalScore + HumanTurnScore) + "\n");
	return HumanTurnScore;
	}
	}
	else
		return 0;
	} while(output == 'r' && (HumanTotalScore + HumanTurnScore) < 100);
	
	return 0;
   }
   /*
   The ComputerTurn uses the various function to take the roll values and respond to human inputs of roll 
   or hold, in addition to calculating the score of the turn. This function returns the score to the total score 
   variable. It also plays the game to a preset strategy of playing until it gets a turnscore of 30 points. 
   */
   static int ComputerTurn(Random rand,  int ComputerTotalScore, String PlayerName) {
	char output ='r';
	int ComputerTurnScore = 0; 
	do {
	int roll1 = rand.nextInt(6) + 1;
	int roll2 = rand.nextInt(6) + 1; 
	if(check_conditions(roll1, roll2, ComputerTurnScore, ComputerTotalScore, PlayerName) == 1)
	{
		ComputerTurnScore += (roll1+roll2);
		//System.out.println("Computer Turn Score is " + ComputerTurnScore + " If held Computer Total Score is " + (ComputerTotalScore + ComputerTurnScore));
		if(ComputerTurnScore > 25) {
			   System.out.println("The Computer Ended Its Turn With a Total Score of " + (ComputerTotalScore + ComputerTurnScore));
			   output = 'h';
			   return ComputerTurnScore;
	}
	}
	else 
		return 0;
	}while(output == 'r');
	return 0;
   }
}