package simpleGame;

import java.io.IOException;
import java.util.Random;

public class PickCardsRandomlyWithoutRepitition {
	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		
		String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		int[] suit1 = new int [7];
		int[] rank1 = new int [7];
		int cnt = 0;
		
		for(int i=0; i<7; i++) {
			boolean distinct = true;
			suit1[i] = rand.nextInt(4);
			rank1[i] = rand.nextInt(13);
			
			for(int j=0; j<i; j++) {
				if (suit1[i] == suit1[j] && rank1[i] == rank1[j]) {
					System.out.printf("\ni: %d, j: %d\n", i, j);
					System.out.printf("(카드는 %s의 %s)\n", suit[suit1[i]], rank[rank1[i]]);
					System.out.println("이미 나온 카드입니다. continue;\n");
					distinct = false;
				}
			}
			
			if (distinct == false) {
				i--;
				continue;
			}
			
			System.out.printf("%d번째 카드 / i:%d\n", ++cnt, i);
			System.out.printf("카드는 %s의 %s\n", suit[suit1[i]], rank[rank1[i]]);
		}
	}
}
