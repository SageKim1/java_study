package alignNumbers;

import java.util.Scanner;

public class AlignThreeIntegers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int first, second, third, temp;
		
		System.out.print("ù ��° ����: ");		
		first = scan.nextInt();
		
		System.out.print("�� ��° ����: ");
		second = scan.nextInt();
		
		if (second > first) {
			temp = first;
			first = second;
			second = temp;
		}
		
		System.out.print("�� ��° ����: ");
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
