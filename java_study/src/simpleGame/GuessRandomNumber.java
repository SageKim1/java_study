package simpleGame;

import java.util.Random;
import java.util.Scanner;

public class GuessRandomNumber {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int guess;
		
		while (true) {
			int randNum = rand.nextInt(100)+1;
			System.out.println(randNum);
			int count = 0;
			int low = 1, high = 100;
			
			System.out.printf("%d ~ %d 사이의 정수\n", low, high);
			do {
				do {
					System.out.printf("정답 추측(%d회차): ", count+1);
					guess = scan.nextInt();
				}
				while(guess<1 || guess>100);
				count++;
				
				if (guess > randNum) {
					System.out.println("제시한 숫자가 큽니다.");
					high = guess - 1;
					System.out.printf("%d ~ %d 범위의 정수\n", low, high);
				}
				else if (guess < randNum) {
					System.out.println("제시한 숫자가 작습니다.");
					low = guess+1;
					System.out.printf("%d ~ %d 범위의 정수\n", low, high);
				}
				else {
					System.out.println("축하합니다! 정답입니다.");
					break;
				}
			}
			while (true);
			
			String yesNo;
			System.out.printf("시도횟수: %d\n", count);
			do {
				System.out.print("계속하시겠습니까?(y/n): ");
				yesNo = scan.next();
			}
			while(!yesNo.equals("y") && !yesNo.equals("Y") && !yesNo.equals("n") && !yesNo.equals("N"));
			System.out.println();
			
			if (yesNo.equals("y") || yesNo.equals("Y"))
				continue;
			else if (yesNo.equals("n") || yesNo.equals("N")) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}

	}
}
