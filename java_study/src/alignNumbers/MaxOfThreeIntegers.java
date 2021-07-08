package alignNumbers;

import java.util.Scanner;

public class MaxOfThreeIntegers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = 0, num1 = 0, num2 = 0, num3 = 0;
		
		System.out.print("첫 번째 정수: ");
		num1 = scan.nextInt();
		max = num1;
		
		System.out.print("두 번째 정수: ");
		num2 = scan.nextInt();
		if (num2 > max) {
			max = num2;
		}
		
		System.out.print("세 번째 정수: ");
		num3 = scan.nextInt();
		if (num3 > max) {
			max = num3;
		}
		
		System.out.printf("가장 큰 수는 %d입니다.", max);
	}
}
