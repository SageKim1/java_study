package simpleGame;

import java.util.Scanner;

public class ClapGame369 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num, hundred, ten, one;
		int count = 0;
		
		System.out.println("��ſ� 369 ����^^");
		System.out.print("1~999 ������ ����: ");
		num = scan.nextInt();
		while(num<1 || num>999) {
			System.out.printf("���� ���Դϴ�. �ٽ� �Է�: ");
			num = scan.nextInt();
		}
		
		
		hundred = num/100;
		if (hundred == 0) {
			hundred = 1;
		}
		if (hundred%3==0) {
			count++;
		}
		ten = (num/10)%10;
		if (ten == 0) {
			ten = 1;
		}
		if (ten%3==0) {
			count++;
		}
		one = num%10;
		if (one == 0) {
			one = 1;
		}
		if (one%3==0) {
			count++;
		}
		
		if (count == 3) {
			System.out.print("�ڼ� ¦!¦!¦!");
		}
		else if (count == 2) {
			System.out.print("�ڼ� ¦!¦!");
		}
		else if (count == 1) {
			System.out.print("�ڼ� ¦!");
		}
		else
			System.out.println("(ħ��)");
	}
}
