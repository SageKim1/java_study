package ShapesWithCharacter;

import java.util.Scanner;

public class PushBackFirstChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է�: ");
		// scan.next�� ���� ���� ���ڱ����� �Է� ����. ���� ����.
		// scan.nextLine: �߰��� ���鹮�� ����. �� �� ������ �Է� ����. ���๮�� ����.
		String s = scan.nextLine();
		System.out.println(s);
		
		int leng = s.length();
		String disp = s;
		for (int i=0; i<leng; i++) {
		String first = disp.substring(0, 1);
		String right = disp.substring(1);
		disp = right.concat(first);
		System.out.println(disp);
		}
	}
}
