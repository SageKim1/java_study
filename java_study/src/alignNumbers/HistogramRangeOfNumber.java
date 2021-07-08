package alignNumbers;

import java.util.Scanner;

public class HistogramRangeOfNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num = new int[10]; // 10���� ������ �Է¹��� �迭 ����
		int[] cnt = new int[10]; // ���� ������ ������ ���� ���� �迭 ����
		
		System.out.println("1~99 ������ ������ 10�� �Է�>>");
		for (int i=0; i<10; i++) {
			num[i] = scan.nextInt();
			// 1~99�� ����� ���� -> �Ʒ� �κ� �����ϰ� for�� ���ư�
			if (num[i]<1 || num[i]>99) {
				System.out.println("���� ���Դϴ�. �ٽ� �Է��ϼ���.");
				// continue�� for������ �ö��� ��, i++ ������ i�� 1�� ��
				// i = 0���� �����ϱ� ���� 1�� ����
				i--;
				continue;
			}
			// num�� �� �ڸ��� = cnt�� �ε��� ����
			cnt[num[i]/10]++;
		}
		
		// 10���� ���� (1~9, 10~19, ..., 90~99)
		for(int i=0; i<10; i++) {
			// ���� ���. ù ��° ������ 0�� �ƴ� 1���� ����
			if (i==0)
				System.out.printf("%2d~%2d: ", i*10 + 1, i*10 + 9);
			else
				System.out.printf("%2d~%2d: ", i*10, i*10 + 9);
			// ����(cnt)��ŭ �� ���
			for(int j=0; j<cnt[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
