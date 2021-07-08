package alignNumbers;

import java.util.Scanner;

public class AlignThreeIntegers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int first, second, third, temp;
		
		System.out.print("첫 번째 정수: ");		
		first = scan.nextInt();
		
		System.out.print("두 번째 정수: ");
		second = scan.nextInt();
		
		if (second > first) {
			temp = first;
			first = second;
			second = temp;
		}
		
		System.out.print("세 번째 정수: ");
		third = scan.nextInt();
		
		if (third > first) {
			temp = first;
			first = third;
			third = second;
			second = temp;
		}
		
		if  (third > second) {
			temp = second;
			second = third;
			third = temp;
		}
		
		System.out.printf("%d >= %d >= %d", first, second, third);
	}
}
