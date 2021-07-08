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
			
			System.out.printf("%d ~ %d ������ ����\n", low, high);
			do {
				do {
					System.out.printf("���� ����(%dȸ��): ", count+1);
					guess = scan.nextInt();
				}
				while(guess<1 || guess>100);
				count++;
				
				if (guess > randNum) {
					System.out.println("������ ���ڰ� Ů�ϴ�.");
					high = guess - 1;
					System.out.printf("%d ~ %d ������ ����\n", low, high);
				}
				else if (guess < randNum) {
					System.out.println("������ ���ڰ� �۽��ϴ�.");
					low = guess+1;
					System.out.printf("%d ~ %d ������ ����\n", low, high);
				}
				else {
					System.out.println("�����մϴ�! �����Դϴ�.");
					break;
				}
			}
			while (true);
			
			String yesNo;
			System.out.printf("�õ�Ƚ��: %d\n", count);
			do {
				System.out.print("����Ͻðڽ��ϱ�?(y/n): ");
				yesNo = scan.next();
			}
			while(!yesNo.equals("y") && !yesNo.equals("Y") && !yesNo.equals("n") && !yesNo.equals("N"));
			System.out.println();
			
			if (yesNo.equals("y") || yesNo.equals("Y"))
				continue;
			else if (yesNo.equals("n") || yesNo.equals("N")) {
				System.out.println("�ý����� �����մϴ�.");
				break;
			}
		}

	}
}
