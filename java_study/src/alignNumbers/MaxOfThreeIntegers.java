package alignNumbers;

import java.util.Scanner;

public class MaxOfThreeIntegers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = 0, num1 = 0, num2 = 0, num3 = 0;
		
		System.out.print("ù ��° ����: ");
		num1 = scan.nextInt();
		max = num1;
		
		System.out.print("�� ��° ����: ");
		num2 = scan.nextInt();
		if (num2 > max) {
			max = num2;
		}
		
		System.out.print("�� ��° ����: ");
		num3 = scan.nextInt();
		if (num3 > max) {
			max = num3;
		}
		
		System.out.printf("���� ū ���� %d�Դϴ�.", max);
	}
}
