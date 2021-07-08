package realLifeProblem;

public class SnailGetOutOfWell {
	public static void main(String[] args) {
		int count = 0;
		int move;
		
		// �����̰� �칰(���� 100)�� �ö� ������������ ��Ȳ. ?��ŭ �ö󰬴ٰ� ?��ŭ �̲����� ������.
		// �� �ö� �Ÿ��� 50���� ���� -> 6��ŭ �ö� �� 2��ŭ �̲�����. ��������� ��ȸ 4��ŭ �ö�.
		for(move = 4; move<50; move+=4) {
			count++;
			System.out.printf("%2d) �����̰� �̵��� ����: %d\n", count, move);
		}
		System.out.println("-> �Ÿ��� 50���� ���� ��\n");
		move -= 4; //  move+=4 ������ 4�� ���������� move<50�� ������ �������� ������. 4��ŭ ����.
		
		while (true) {
			move += 5;
			count++;
			if (move<=100) {
				// 5��ŭ �ö󰬴ٰ� 2��ŭ �̲�����.
				move -= 2;
				System.out.printf("%2d) �����̰� �̵��� ����: %d\n", count, move);
			}
			else if (move>100) {
				// �칰�� ��������.
				break;
			}
		}
		System.out.printf("Ż�� ����! �������� �� �̵� Ƚ��: %d��", count);
	}
}
