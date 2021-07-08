package date;

import java.util.Scanner;

public class DistinguishLeapYear {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year=0, month=0, day=0;
		
		System.out.print("연도?: ");
		year = scan.nextInt();
		System.out.print("월?: ");
		month = scan.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			day = 31;
			break;
		case 4, 6, 9, 11:
			day = 30;
			break;
		case 2:
			if ((year%4==0 && year%100!=0) || year%400==0) {
				day = 29;
				System.out.println("윤년입니다.");
			}
			else {
			day = 28;
			}
			break;
		}
		
		System.out.printf("%d월은 %d일입니다.", month, day);
	}
}
