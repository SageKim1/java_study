package date;

import java.util.Scanner;

public class SecondToHourMinuteSecond {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("초를 입력하시오: ");
		int time = scan.nextInt();
		
		int hour = (time/60)/60;
		int minute = (time/60)%60;
		int second = time%60;		
				
		System.out.printf("%d시간 %d분 %d초", hour, minute, second);
	}
}
