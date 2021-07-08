package realLifeProblem;

import java.util.Scanner;

class Dictionary {
	// 0번째 행: kor, 1번째 행: eng
	public static String[][] koreng = { { "자바", "사랑", "아기", "책", "읽다", "집", "남자", "여자", "가족", "신문" },
			{ "java", "love", "baby", "book", "read", "home", "man", "woman", "family", "newspaper" } };
	
	public static String kortoeng(String word) {
		for(int i=0; i<koreng[1].length; i++) {
			if (koreng[0][i].equals(word)) {
				return koreng[1][i];
			}	
		}
		return "사전에 존재하지 않는 단어입니다.";
	}
	
	public static String engtokor(String word) {
		for(int i=0; i<koreng[0].length; i++) {
			if (koreng[1][i].equalsIgnoreCase(word)) {
				return koreng[0][i];
			}	
		}
		return "사전에 존재하지 않는 단어입니다.";
	}
}

public class EnglishKoreanDictionary {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {	
		System.out.println("한영검색 프로그램");
		while(true) {
		System.out.println("1. 한글단어\n2. 영문단어\n3. 종료");
		System.out.print("메뉴 선택: ");
		int select = scan.nextInt();
		
		switch(select) {
		case 1:
			searchkor();
			break;
		case 2:
			searcheng();
			break;
		case 3:
			System.out.println("시스템을 종료합니다.");
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
		
		System.out.print("한글 단어 입력: ");
		String s = scan.next();
		System.out.println(Dictionary.kortoeng(s)+"\n");
	}
	
	static void searcheng() {
		for(int i=0; i<Dictionary.koreng[1].length; i++) {
			System.out.print(Dictionary.koreng[1][i]+" ");
		}
		System.out.println("\n");
		

		System.out.print("영어 단어 입력: ");
		String s = scan.next();
		System.out.println(Dictionary.engtokor(s)+"\n");
	}
}
