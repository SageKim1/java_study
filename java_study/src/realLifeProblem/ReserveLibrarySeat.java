package realLifeProblem;

import java.util.Scanner;

public class ReserveLibrarySeat {
	static Scanner scan = new Scanner(System.in);
	static String[][][] library = new String[5][5][5];
	static int select, floor, row, column;
	static String name;
	
	// 메인 메서드
	public static void main(String[] args) {
		show();
		while (true) {
			menu();
			switch (select) {
			case 1:
				book();
				break;
			case 2:
				leave();
				break;
			case 3:
				show();
				break;
			case 4:
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
	
	// 1~5층의 좌석 안내도, 좌석 수(전체/예약석/공석) 출력
	public static void show() {
		int cnt = 0;
		
		for(int i=0; i<library.length; i++) {
			System.out.printf("%d층 좌석 안내도\n", i+1);
			System.out.println("       1열   2열    3열   4열    5열");
			for(int j=0; j<library[i].length; j++) {
				System.out.printf("%d행", j+1);
				for(int k=0; k<library[i][j].length; k++) {
					if (library[i][j][k] == null) {
						System.out.printf("     □");
					}
					else {
						cnt++;
						System.out.printf("  %s", library[i][j][k]);
					}
				}	// 열의 끝
				System.out.println();
			}	// 행의 끝
			System.out.println();
		}
		System.out.printf("전체 125 좌석. 예약된 좌석: %d개. 빈 좌석: %d개.\n", cnt, 125-cnt);
	}	// show 메소드의 끝
	
	// 메뉴 입출력 메소드
	public static void menu() {
		System.out.println("\n메뉴\n1 - 좌석 배정\n2 - 좌석 반납\n3 - 좌석 확인\n4 - 종료\n");
		do {
			System.out.print("메뉴 선택: ");
			select = scan.nextInt();
		}
		while(select<1 || select>4);
	}
	
	// 좌석 예약 메서드
	public static void book() {
		do {
			System.out.print("원하는 층의 숫자(1~5): ");
			floor = scan.nextInt();
			}
			while(floor<1 || floor>5);
			do {
			System.out.print("원하는 열의 숫자(1~5): ");
			row = scan.nextInt();
			}
			while(row<1 || row>5);
			do {
			System.out.print("원하는 행의 숫자(1~5): ");
			column = scan.nextInt();
			}
			while(column<1 || column>5);
		
			if (!(library[floor-1][row-1][column-1] == null)) {
				System.out.printf("[%d층][%d행][%d열]은 이미 예약된 자리입니다.\n", floor, row, column);
			}
			else {
				System.out.print("예약자 이름: ");
				name = scan.next();
				library[floor-1][row-1][column-1] = name;
				System.out.printf("[%d층][%d행][%d열]에 예약되었습니다.\n", floor, row, column);
			}
	}
	
	// 좌석 반납 메서드
	public static void leave() {
		do {
			System.out.print("반납할 층의 숫자(1~5): ");
			floor = scan.nextInt();
			}
			while(floor<1 || floor>5);
			do {
			System.out.print("반납할 열의 숫자(1~5): ");
			row = scan.nextInt();
			}
			while(row<1 || row>5);
			do {
			System.out.print("반납할 행의 숫자(1~5): ");
			column = scan.nextInt();
			}
			while(column<1 || column>5);
			
			if (library[floor-1][row-1][column-1] == null) {
				System.out.printf("[%d층][%d행][%d열]은 원래 비어있습니다.\n", floor, row, column);
			}
			else {
				library[floor-1][row-1][column-1] = null;
				System.out.printf("[%d층][%d행][%d열]이 반납되었습니다.\n", floor, row, column);
			}
	}
}
