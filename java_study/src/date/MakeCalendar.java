package date;

import java.util.Scanner;

public class MakeCalendar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 키보드로 연도 입력
		int year;
		do {
			System.out.print("연도>> ");
			year = scan.nextInt();
		}
		while(year<1 || year>9999);
		
		// 윤년, 평년의 일수 합산
		int total = 0;
		for (int i=1; i<year; i++) {
			if ((i%4==0 && i%100!=0) || i%400==0) {
				total += 366;
			}
			else
				total += 365;
		}
		
		int finalTotal = total;
		
		int month;
		for (month=1; month<13; month++) {
			// 달력의 상단부
			System.out.printf("\n\t %d년   %d월\n", year, month);
			System.out.println("\t=============");
			System.out.println("------------------------------");
			System.out.println(" SUN MON TUE WED THU FRI SAT");
			System.out.println("------------------------------");
			
			total = finalTotal;
			
			// 2021년 입력 전 달까지 일수 계산
			switch (month-1) {
			case 11:
				total += 30;
			case 10:
				total += 31;
			case 9:
				total += 30;
			case 8:
				total += 31;
			case 7:
				total += 31;
			case 6:
				total += 30;
			case 5:
				total += 31;
			case 4:
				total += 30;
			case 3:
				total += 31;
			case 2:
				if ((year%4==0 && year%100!=0) || year%400==0)
					total +=29;
				else
					total += 28;
			case 1:
				total += 31;
			}
			
			// 입력한 달의 시작하는 요일 구하기
			total += 1;
			int weekday = total%7;
		
			int monthDay=0;
			switch(month) {
			case 1, 3, 5, 7, 8, 10, 12:
				monthDay = 31;
				break;
			case 4, 6, 9, 11:
				monthDay = 30;
				break;
			case 2:
				if ((year%4==0 && year%100!=0) || year%400==0)
					monthDay = 29;
				else
					monthDay = 28;
				break;
			}
				
			int j=1;
			for (int i=0; i<7; i++) {
				if (i<weekday)
					System.out.print("    ");
				else {
					System.out.printf("%4d", j);
					j++;
				}
			}
			System.out.println();
		
			for (int k=j; k<=monthDay; k+=7) {
				for (int i=0; i<7; i++) {
					if ((k+i)<(monthDay+1))
						System.out.printf("%4d", k+i);
					else
						break;
				}
				System.out.println();
			}
		}
		
		scan.close();
	}
}
