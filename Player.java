package gamefiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Player {
	public static int playerScore = 0;
	public static ArrayList<Character> cards = new ArrayList<Character>
	(Arrays.asList('A','2','3','4', '5','6','7','8','9','J','K','Q'));
	public static ArrayList<Character> playerCards= new ArrayList<Character>();


	public static char playerCardNumber() {
		Random random = new Random();
		int card = random.nextInt(12);
		char temp = cards.get(card);
		playerCards.add(temp);
		return temp;
	}

	public static void playerScoreAccessment() {
		playerScore =0;
		for(Character card: playerCards) {
			if(card == 'A')  playerScore += 1;
			else if(card == '2')  playerScore += 2;
			else if(card == '3')  playerScore += 3;
			else if(card == '4')  playerScore += 4;
			else if(card == '5')  playerScore += 5;
			else if(card == '6')  playerScore += 6;
			else if(card == '7')  playerScore += 7;
			else if(card == '8')  playerScore += 8;
			else if(card == '9')  playerScore += 9;
			else if(card == 'K' || card == 'Q' ||card == 'J')  playerScore += 10;
		}
		
		if(playerCards.size()==2) {
			if(playerCards.get(0)=='A'|| playerCards.get(1)=='A') playerScore += 10;
		}
		
		if(playerCards.size()>2) {
			if((playerCards.get(0)=='A'|| playerCards.get(1)=='A')&& 
					(playerCards.get(2)!= 'K'&& playerCards.get(2)!= 'Q'&& playerCards.get(2)!= 'J')) playerScore += 10;
		}
	}

}