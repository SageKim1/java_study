package simpleGame;

public class HitAndMissLottery {
	public static void main(String[] args) {
		int[] count = new int[10];
		
		for(int i=0; i<10; i++) {
			// 0~9 ������ ������ 10�� ����
			int num = (int)(Math.random()*10);;
			// ������ ���� ������ �迭�� ã��
			// �ش� �迭�� ����� ���� (�⺻�� 0����) 1�� ������Ŵ
			count[num]++;
			System.out.print(num+" ");
		}
		System.out.println("\n");
		
		// �迭 ���ڿ� ��ġ�ϴ� ������ ���� Ƚ���� �����
		for(int i=0; i<10; i++) {
			System.out.printf("[%d]: %d��\n", i, count[i]);
		}
		
		// ���� ���� Ƚ��(max)�� ã��
		int max = 0;
		for(int i=0; i<10; i++) {
			if (count[i]>max) {
				max = count[i];
			}
		}
		System.out.println();
		
		// Ƚ���� max�� count[i]�� ��� �����
		// �׷��� count[i]�� ������ �����
		int count2 = 0;
		for(int i=0; i<10; i++) {
			if (count[i]==max) {
			System.out.printf("��÷: count[%d] ", i);
			count2++;
			}
		}
		System.out.println("\n��÷���� ��: "+count2);
	}
}
