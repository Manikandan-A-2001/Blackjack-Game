package gamefiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dealer {
	public static int dealerScore = 0;
	public static ArrayList<Character> cards = new ArrayList<Character>(Arrays.asList('A','2','3','4', '5','6','7','8','9','J','K','Q'));
	public static ArrayList<Character> dealerCards= new ArrayList<Character>();
	
	public static char dealerCardNumber() {
		Random random = new Random();
		int card = random.nextInt(12);
		char temp = cards.get(card);
		dealerCards.add(temp);
		return temp;
	}
	
	public static int dealerScoreAccessment() {
		dealerScore = 0;
		for(Character card: dealerCards) {
			if(card == 'A')  dealerScore += 1;
			else if(card == '2')  dealerScore += 2;
			else if(card == '3')  dealerScore += 3;
			else if(card == '4')  dealerScore += 4;
			else if(card == '5')  dealerScore += 5;
			else if(card == '6')  dealerScore += 6;
			else if(card == '7')  dealerScore += 7;
			else if(card == '8')  dealerScore += 8;
			else if(card == '9')  dealerScore += 9;
			else if(card == 'K' || card == 'Q' ||card == 'J')  dealerScore += 10;
		}
		
		if(dealerCards.size()==2) {
			if(dealerCards.get(0)=='A'|| dealerCards.get(1)=='A') dealerScore += 10;
		}
		
		if(dealerCards.size()>2) {
			if((dealerCards.get(0)=='A'|| dealerCards.get(1)=='A')&& 
					(dealerCards.get(2)!= 'K'&& dealerCards.get(2)!= 'Q'&& dealerCards.get(2)!= 'J')) dealerScore += 10;
		}
		return dealerScore;
	}
}
