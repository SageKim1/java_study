package realLifeProblem;

import java.util.Scanner;

class Dictionary {
	// 0��° ��: kor, 1��° ��: eng
	public static String[][] koreng = { { "�ڹ�", "���", "�Ʊ�", "å", "�д�", "��", "����", "����", "����", "�Ź�" },
			{ "java", "love", "baby", "book", "read", "home", "man", "woman", "family", "newspaper" } };
	
	public static String kortoeng(String word) {
		for(int i=0; i<koreng[1].length; i++) {
			if (koreng[0][i].equals(word)) {
				return koreng[1][i];
			}	
		}
		return "������ �������� �ʴ� �ܾ��Դϴ�.";
	}
	
	public static String engtokor(String word) {
		for(int i=0; i<koreng[0].length; i++) {
			if (koreng[1][i].equalsIgnoreCase(word)) {
				return koreng[0][i];
			}	
		}
		return "������ �������� �ʴ� �ܾ��Դϴ�.";
	}
}

public class EnglishKoreanDictionary {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {	
		System.out.println("�ѿ��˻� ���α׷�");
		while(true) {
		System.out.println("1. �ѱ۴ܾ�\n2. �����ܾ�\n3. ����");
		System.out.print("�޴� ����: ");
		int select = scan.nextInt();
		
		switch(select) {
		case 1:
			searchkor();
			break;
		case 2:
			searcheng();
			break;
		case 3:
			System.out.println("�ý����� �����մϴ�.");
			System.exit(0);
		default:
			continue;
		}
		}
	}
	
	static void searchkor() {
		for(int i=0; i<Dictionary.koreng[0].length; i++) {
			System.out.print(Dictionary.koreng[0][i]+" ");
		}
		System.out.println("\n");
		
		System.out.print("�ѱ� �ܾ� �Է�: ");
		String s = scan.next();
		System.out.println(Dictionary.kortoeng(s)+"\n");
	}
	
	static void searcheng() {
		for(int i=0; i<Dictionary.koreng[1].length; i++) {
			System.out.print(Dictionary.koreng[1][i]+" ");
		}
		System.out.println("\n");
		

		System.out.print("���� �ܾ� �Է�: ");
		String s = scan.next();
		System.out.println(Dictionary.engtokor(s)+"\n");
	}
}
