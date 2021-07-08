package simpleGame;

import java.util.Random;
import java.util.Scanner;

public class FlingOfTheDice {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("주사위 게임을 시작합니다.");
		System.out.println("행운을 빕니다.\n");
		
		System.out.print("사용자의 주사위를 굴리겠습니다.(ENTER 입력)");
		String enter1 = scan.nextLine();
		int user = rand.nextInt(6)+1;
		System.out.println("사용자의 숫자: " + user + "\n");
		
		System.out.print("컴퓨터의 주사위를 굴리겠습니다.(ENTER 입력)");
		String enter2 = scan.nextLine();
		int com = rand.nextInt(6)+1;
		System.out.println("컴퓨터의 숫자: " + com + "\n");
		
		if (user>com)
			System.out.println("사용자의 승리");
		else if (user<com)
			System.out.println("컴퓨터의 승리");
		else
			System.out.println("비겼습니다.");
	}
}
