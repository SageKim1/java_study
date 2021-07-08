package simpleGame;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String c, y, yn;
		int ynum;
		int game=0;
		int victory=0;
	    int draw=0;
	    int lose=0;
		System.out.println("가위, 바위, 보 게임입니다.");
		
		do {
			do {
			System.out.print("사용자: ");
			c = scan.next();
			}
			while(!c.equals("가위") && !c.equals("바위") && !c.equals("보"));
			
			ynum = rand.nextInt(3)+1;
			if (ynum==1) {
				y = "보";
			}
			else if (ynum==2) {
				y = "가위";
			}
			else {
				y = "바위";
			}
			System.out.printf("컴퓨터: %s\n", y);
			
			
			if (c.equals("가위") && y.equals("보") || c.equals("바위") && y.equals("가위")
					|| c.equals("보") && y.equals("바위")) {
				System.out.println("이겼습니다.");
				game++;
				victory++;
			}
			else if (c.equals(y)) {
				System.out.println("비겼습니다.");
				game++;
				draw++;
			}
			else {
				System.out.println("졌습니다.");
				game++;
				lose++;
			}
			
			System.out.print("게임을 계속할까요?(Y/N)");
			yn = scan.next();
			System.out.println();
		}
		while (yn.equals("y") || yn.equals("Y"));
		
		System.out.printf("사용자 이긴 횟수: %d\n", victory);
		System.out.printf("컴퓨터 이긴 횟수: %d\n", lose);
		System.out.printf("비긴 횟수: %d\n", draw);
		System.out.printf("승률은 %.1f%%입니다.(무승부는 계산에서 제외)\n", (double)victory/(victory+lose)*100);
		System.out.println("시스템이 종료되었습니다.");
	}
}
