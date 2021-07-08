package realLifeProblem;

import java.util.Scanner;

public class WordChainGame {
	public static Scanner scan = new Scanner(System.in);
	public static int num;
	public static String[] name;
	public static String[] word;
	
	public static void main(String[] args) {
		input();
		game();
	}
	
	public static void input() {
		System.out.print("게임 참가 인원: ");
		num = scan.nextInt();
		name = new String[num];
		word = new String[num+1];
		
		for(int i=0; i<num; i++) {
			System.out.printf("%d번째 참가자의 이름: ", i+1);
			name[i] = scan.next();
		}
	}
	
	public static void game() {
		System.out.print("시작 단어 입력: ");
		word[0] = scan.next();
		
		while (true) {
			char last, first;
			
			for(int i=0; i<num; i++) {
				last = word[i].charAt(word[i].length() - 1);
				System.out.printf("%s>>", name[i]);
				word[i+1] = scan.next();
				first = word[i+1].charAt(0);
				
				if (first != last) {
					System.out.printf("%s가 졌습니다.\n", name[i]);
					System.exit(0);
				}
				
				if (i == num-1) {
					word[0] = word[num];
				}
			}
		}
	}
}
