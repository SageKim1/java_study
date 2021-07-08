package ShapesWithCharacter;

import java.util.Scanner;

public class PushBackFirstChar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열 입력: ");
		// scan.next는 공백 앞의 문자까지만 입력 받음. 띄어쓰기 기준.
		// scan.nextLine: 중간의 공백문자 포함. 한 줄 단위로 입력 받음. 개행문자 기준.
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
