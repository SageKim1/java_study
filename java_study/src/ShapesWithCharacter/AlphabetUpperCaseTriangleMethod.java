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
		System.out.print("���ĺ� �Է�: ");
		// ���ڿ��� ��ü�� �� �����ڸ� �� �� ����. �⺻ Ÿ�� char�� �� ������ ��� ����
		String str1 = scan.next();
		String str2 = str1.toUpperCase();
		// 0��° 1���ڸ� ���� ���·� ������. �ƽ�Ű�ڵ� ����.
		stringToChar = str2.charAt(0);
		
		alphabet(); // ���� ������ �����߱� ������, ���� ������ �ʿ� ����
		
		System.out.print("����Ͻðڽ��ϱ�?(y/n): ");
		String yesNo = scan.next();
		System.out.println();
		
		if (yesNo.equals("y") || yesNo.equals("Y")) {
			continue;
		}
		else if (yesNo.equals("n") || yesNo.equals("N")) {
			System.out.println("�ý����� �����մϴ�.");
			break;
		}
		}
		while(true);
		
	}
		
}
