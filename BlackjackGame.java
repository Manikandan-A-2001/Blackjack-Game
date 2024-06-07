package gamefiles;

import java.util.Scanner;

public class BlackjackGame {

	public static void main(String[] args) {
		
		System.out.println("**********************************************************************************");
		System.out.println("                            Welcome to Blackjack Game");
		System.out.println("**********************************************************************************");
		Scanner scan = new Scanner(System.in);
		boolean playerChoice = true;
		
		while(playerChoice) {
			
			System.out.println("If you wish to play, type 'play'. To read the instructions, type 'read'.");
			String gameChoice = scan.nextLine();
			
			if(gameChoice.equals("play")) {
				startGame();
				playerChoice = false;
			}
			else if(gameChoice.equals("read")) {
				showInstruction();
				playerChoice = true;
			}
			else {
				System.out.println("Choose and type accurately, please.");
			}
			}
	}
	
	public static String formattedCard(char cardNumber) {
		return "  ---\n  |"+cardNumber+"|\n  ---";
	}
	

	private static void startGame() {
		System.out.println("\nDealer's Card \n" + "---  ---\n|"+ Dealer.dealerCardNumber() +"|  |*|\n---  ---");
		System.out.println("\nYour Card \n" + "---  ---\n|"+ Player.playerCardNumber() +"|  |"+ Player.playerCardNumber() +"|\n---  ---");
		System.out.println("Type \"hit\" to receive more cards, or type \"stand\" to keep your current hand.");
		while(true) {
			System.out.print("Your Response: ");
			Scanner scan = new Scanner(System.in);
			String ans = scan.nextLine();
			if(ans.equals("hit")) {
				System.out.println(formattedCard(Player.playerCardNumber()));
				Player.playerScoreAccessment();
				if(Player.playerScore>21) {
					dealerTurn();
					break;
				}
			}
			else if(ans.equals("stand")) {
				Player.playerScoreAccessment();
				if(Player.playerScore<17) {
					System.out.println("Your Score is Below 17. So you have to Choose another card.");
				}
				else {
					dealerTurn();
					break;
				}
			}
			else {
				System.out.println("Choose and type accurately, please.");
			}
		}
	}
	
	private static void dealerTurn() {
		System.out.println("Dealer's Hidden Card: \n"+ formattedCard(Dealer.dealerCardNumber()));
		while(true) {
			int score = Dealer.dealerScoreAccessment();
			if(17<=score && score>=21) {
				finalResult();
				break;
			}else if(score<17) {
				System.out.println("Dealer's another Card: \n"+ formattedCard(Dealer.dealerCardNumber()));
				
			}
			else {
				finalResult();
				break;
			}
		}
	}

	private static void finalResult() {
		int dealerscore = Dealer.dealerScore;
		int playerscore = Player.playerScore;
		System.out.println("Your's Score: "+ playerscore +".  Dealer's Score: "+ dealerscore);
		if (dealerscore > 21 && playerscore > 21) {
		    System.out.println("Game is Bust. We both lose the Game. :(");
		} else if (playerscore > 21) {
		    System.out.println("Sorry. You lose the Game. :(");
		} else if (dealerscore > 21) {
		    System.out.println("You win the Game. :)");
		} else if (playerscore == dealerscore) {
		    System.out.println("Match is Push. We both neither win nor lose.");
		} else if (playerscore > dealerscore) {
		    System.out.println("You win the Game. :)");
		} else {
		    System.out.println("Sorry. You lose the Game. :(");
		}
	}

	private static void showInstruction() {
		System.out.println("In Blackjack, the goal is to have a hand value closer to 21 than the \n"
				+ "dealer's without exceeding 21. Number cards (2-10) are worth their face value, \n"
				+ "face cards (King, Queen, Jack) are worth 10 points each, and Aces can be worth \n"
				+ "either 1 or 11 points. Each player is dealt two cards, as is the dealer, with \n"
				+ "one of the dealer's cards face down. Players then decide to either \"hit\" \n"
				+ "(draw another card), \"stand\" (keep their current hand and dealer starts to play).\n"
				+ " The dealer must draw until reaching at least 17. The hand closest to 21 wins,\n"
				+ " but exceeding 21 results in a bust and loss of the hand.");
		System.out.println("\n");
	}

}
