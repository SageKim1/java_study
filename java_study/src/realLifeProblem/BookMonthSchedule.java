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
		System.out.println("�̹� ���� ������ ���� ���α׷�");
		System.out.print("���� ���� [�Է�:1  ����:2  ������:3] >> ");
		int select = scan.nextInt();
		
		switch(select) {
		case 1:
			insert();
			break;
		case 2:
			show();
			break;
		case 3:
			System.out.println("�ý����� �����մϴ�.");
			System.exit(0);
		}
	}
	
	static public void insert() {
		System.out.print("\n��¥(1~30)? ");
		int date = scan.nextInt();
		scan.nextLine();
		
		System.out.print("������ �Է��ϼ���: ");
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
		System.out.print("\n��¥(1~30)? ");
		int date = scan.nextInt();
		boolean empty = true;
		
		System.out.printf("%d���� ����\n", date);
		for(int i=0; i<schedule.length; i++) {
			if (schedule[i][date-1] != null) {
				empty = false;
				System.out.println(schedule[i][date-1]);
			}
		}
		if (empty == true) {
			System.out.println("������ �����ϴ�.");
		}
		System.out.println();
	}
}