package alignNumbers;

import java.util.Scanner;

public class FindPrimeNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("2���� ����� �Ҽ����� Ȯ���ұ��?: ");
		int num = scan.nextInt();
		System.out.print("�Ҽ�: ");
		
		for (int j=2; j<=num; j++) {	// �ܺ� for�� ����
			/* boolean�� ��ġ�� ��Ȯ�� ���� �;� ��
		    �ܺ� for�� ���Ժο��� boolean ���� true�� �ʱ�ȭ�ؾ� �ϱ� ���� */
			boolean primeNum = true;
			
			for (int i=2; i<j; i++) {	// ���� for�� ����
				if (j%i == 0) {
					primeNum = false;
					break;
				}
			}	// ���� for�� �ݱ�
		
		if (primeNum==true)
				System.out.print(j+" ");
		}	// �ܺ� for�� �ݱ�
	}
}
