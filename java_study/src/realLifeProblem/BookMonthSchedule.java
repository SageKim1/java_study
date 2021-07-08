package realLifeProblem;

import java.util.Scanner;

public class BookMonthSchedule {
	public static void main(String[] args) {
		while(true) {
			MonthSchedule.menu();
		}
	}
}

class MonthSchedule {
	static Scanner scan = new Scanner(System.in);
	static String[][] schedule = new String [5][30];
	
	static public void menu() {
		System.out.println("이번 달의 스케줄 관리 프로그램");
		System.out.print("할일 선택 [입력:1  보기:2  끝내기:3] >> ");
		int select = scan.nextInt();
		
		switch(select) {
		case 1:
			insert();
			break;
		case 2:
			show();
			break;
		case 3:
			System.out.println("시스템을 종료합니다.");
			System.exit(0);
		}
	}
	
	static public void insert() {
		System.out.print("\n날짜(1~30)? ");
		int date = scan.nextInt();
		scan.nextLine();
		
		System.out.print("할일을 입력하세요: ");
		String work = scan.nextLine();
		System.out.println();
		
		for(int i=0; i<schedule.length; i++) {
			if (schedule[i][date-1] == null) {
				schedule[i][date-1] = work;
				break;
			}
		}
		
	}
	
	static public void show() {
		System.out.print("\n날짜(1~30)? ");
		int date = scan.nextInt();
		boolean empty = true;
		
		System.out.printf("%d일의 할일\n", date);
		for(int i=0; i<schedule.length; i++) {
			if (schedule[i][date-1] != null) {
				empty = false;
				System.out.println(schedule[i][date-1]);
			}
		}
		if (empty == true) {
			System.out.println("할일이 없습니다.");
		}
		System.out.println();
	}
}