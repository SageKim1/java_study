package ShapesWithCharacter;

import java.util.Scanner;

public class AlphabetUpperCaseTriangleMethod {
	static char stringToChar;
	
	public static void alphabet() {
		for (char a = 'A'; a <= stringToChar; a++) {
			for (char b = 'A'; b <= a; b++) {
				System.out.printf("%s ", b);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		do {
		System.out.print("알파벳 입력: ");
		// 문자열은 객체라서 비교 연산자를 쓸 수 없음. 기본 타입 char은 비교 연산자 사용 가능
		String str1 = scan.next();
		String str2 = str1.toUpperCase();
		// 0번째 1문자를 문자 형태로 가져옴. 아스키코드 문자.
		stringToChar = str2.charAt(0);
		
		alphabet(); // 전역 변수를 선언했기 때문에, 인자 전달할 필요 없음
		
		System.out.print("계속하시겠습니까?(y/n): ");
		String yesNo = scan.next();
		System.out.println();
		
		if (yesNo.equals("y") || yesNo.equals("Y")) {
			continue;
		}
		else if (yesNo.equals("n") || yesNo.equals("N")) {
			System.out.println("시스템을 종료합니다.");
			break;
		}
		}
		while(true);
		
	}
		
}
