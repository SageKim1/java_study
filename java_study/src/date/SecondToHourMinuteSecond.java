package date;

import java.util.Scanner;

public class SecondToHourMinuteSecond {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�ʸ� �Է��Ͻÿ�: ");
		int time = scan.nextInt();
		
		int hour = (time/60)/60;
		int minute = (time/60)%60;
		int second = time%60;		
				
		System.out.printf("%d�ð� %d�� %d��", hour, minute, second);
	}
}
