package alignNumbers;

import java.util.Scanner;

public class FourArithmeticOperationsWithMenu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int option;
		
		do {
		System.out.print("�޴� ����: 1. ����  2. ����  3. ����  4. ������ ? ");
		option = scan.nextInt();
		}
		while(option!=1 && option!=2 && option!=3 && option!=4);
		
		System.out.print("ù ��° ��: ");
		int num1 = scan.nextInt();
		System.out.print("�� ��° ��: ");
		int num2 = scan.nextInt();
		
		switch(option) {
		case 1:
			System.out.println("���� ����� "+(num1+num2));
			break;
		case 2:
			System.out.println("���� ����� "+(num1-num2));
			break;
		case 3:
			System.out.println("���� ����� "+(num1*num2));
			break;
		case 4:
			System.out.println("������ ����� "+(num1/num2));
			break;
		}
	}
}
