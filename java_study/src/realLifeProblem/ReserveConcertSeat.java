package realLifeProblem;

import java.util.Scanner;

public class ReserveConcertSeat {
	public static void main(String[] args) {
		// 무한반복 (메뉴에서 종료를 선택하면 시스템 종료함)
		while (true) {
			ConcertSystem.menu();
		}
	}
}

class ConcertSystem {
	static Scanner scan = new Scanner(System.in);
	// 3개의 행(0~2). 6개의 열(0~5).
	// 0행: S석 / 1행: A석 / 2행: B석
	// 0 ~ 4열: 5개의 좌석(예약자 이름을 저장함. 초기값은 null.)
	// 5열: 좌석의 종류를 저장(S, A, B).
	static String[][] seats = new String[3][6];
	
	static void menu() {
		// 각 행의 5열에 해당하는 좌석의 종류 이름을 저장함. 출력할 용도.
		// 대입은 메서드 내부에서 해야 함. (선언은 메서드 외부에서 가능함.)
		seats[0][5] = "S";
		seats[1][5] = "A";
		seats[2][5] = "B";
		
		System.out.println("콘서트홀 예약 시스템");
		// 메뉴 선택 값
		int select;
		do {
		System.out.print("예약:1   조회:2   취소:3   종료:4 >> ");
		select = scan.nextInt();
		}
		while(select<1 || select>4);
		
		switch(select) {
		case 1:
			// 예약 메서드 호출
			reserve();
			break;
		case 2:
			// 조회 메서드 호출
			// S석(0), A석(1), B석(2)을 순차적으로 출력
			view(0);
			view(1);
			view(2);
			System.out.println();
			break;
		case 3:
			// 취소 메서드 호출
			cancel();
			break;
		case 4:
			System.out.println("시스템을 종료합니다.");
			System.exit(0);
		}
	}
	
	static void reserve() {
		System.out.println("S석:1, A석:2, B석:3");
		int num;
		do {
		System.out.print("예약할 좌석의 종류: ");
		num = scan.nextInt();
		}
		while(num<1 || num>3);
		
		// 출력 메소드 호출
		// 배열의 행은 0~2인데 입력은 1~3으로 받았기에 1만큼 빼줌.
		view(num-1);
		
		// seats[0][5]: S, seats[1][5]: A, seats[2][5]: B
		System.out.printf("%s석 중 예약을 원하는 ", seats[num-1][5]);
		
		int seat;
		do {
		System.out.print("좌석의 번호를 입력: ");
		seat = scan.nextInt();
		}
		while(seat<1 || seat>5);
		
		if (seats[num-1][seat-1] != null) {
			System.out.println("예약할 수 없는 좌석입니다.\n");
		}
		else {
			System.out.print("이름을 입력하시오: ");
			String name = scan.next();
			// 예약한 좌석에 예약자의 이름 저장
			seats[num-1][seat-1] = name;
			System.out.printf("%s석의 %d번 좌석이 예약되었습니다.\n\n", seats[num-1][5], seat);
		}
	}
	
	static void view(int grade) {
		// seats[0][5]: S, seats[1][5]: A, seats[2][5]: B
		System.out.print(seats[grade][5]+" ");
		
		for(int i=0; i<(seats[grade].length)-1; i++) {
			// 좌석 번호 출력
			System.out.print(i+1);
			if(seats[grade][i] == null) {
				System.out.print("----");
			}
			// 예약자의 이름 출력
			else
				System.out.print(seats[grade][i]);
		}
		System.out.println();
	}
	
	static void cancel() {
		System.out.print("예약자의 성함: ");
		String name = scan.next();
		
		for(int i=0; i<seats.length; i++) {
			for(int j=0; j<(seats[i].length)-1; j++) {
				if (seats[i][j] != null && seats[i][j].equals(name)) {
					seats[i][j] = null;
					System.out.printf("%s석의 %d번 좌석이 취소되었습니다.\n\n", seats[i][5], j+1);
					return;
				}
			}
		}
		System.out.println("일치하는 이름이 없습니다.\n");

	}
}
