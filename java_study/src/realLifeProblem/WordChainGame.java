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
		System.out.print("���� ���� �ο�: ");
		num = scan.nextInt();
		name = new String[num];
		word = new String[num+1];
		
		for(int i=0; i<num; i++) {
			System.out.printf("%d��° �������� �̸�: ", i+1);
			name[i] = scan.next();
		}
	}
	
	public static void game() {
		System.out.print("���� �ܾ� �Է�: ");
		word[0] = scan.next();
		
		while (true) {
			char last, first;
			
			for(int i=0; i<num; i++) {
				last = word[i].charAt(word[i].length() - 1);
				System.out.printf("%s>>", name[i]);
				word[i+1] = scan.next();
				first = word[i+1].charAt(0);
				
				if (first != last) {
					System.out.printf("%s�� �����ϴ�.\n", name[i]);
					System.exit(0);
				}
				
				if (i == num-1) {
					word[0] = word[num];
				}
			}
		}
	}
}
