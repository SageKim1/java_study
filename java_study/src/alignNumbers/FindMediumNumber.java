package alignNumbers;

import java.util.Scanner;

public class FindMediumNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int temp; // �ӽ� �� ������ ���� ���� ����
		
		System.out.print("���� 3�� �Է�>> ");
		int first = scan.nextInt();
		int second = scan.nextInt();
		int third = scan.nextInt();
		
		// first>second ������Ű��
		if (second > first) {
			temp = first;	// first ���� temp�� ����
			first = second;	// second ���� first�� ����
			second = temp;	// temp ���� second�� ����
		}
		
		// first>second>third ������Ű��
		if (third > first) {
	    	temp = first;	// first ���� temp�� ����
	    	first = third;	// third ���� first�� ����
	    	third = second;	// second ���� third�� ����
	    	second = temp;	// temp ���� second�� ����
	    }
		else if (third < first && third >second) {
			temp = second;	// second ���� temp�� ����
			second = third;	// third ���� second�� ����
			third = temp;	// temp ���� third�� ����
		}
		// third<second�� ���� ���� �� �� �� ����
		
		System.out.printf("�߰� ���� %d", second);
	}
}
