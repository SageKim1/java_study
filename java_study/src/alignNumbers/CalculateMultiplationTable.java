package alignNumbers;

public class CalculateMultiplationTable {
	public static void main(String[] args) {
		// �����ϴ� ��: 1, 4(1+3), 7(4+3)
		for (int i=1; i<10; i+=3) {
			// ���ϴ� ��: 1~9
			for (int j=1; j<10; j++) {
				// �������� ��: 1~3 / 4~6 / 7~9
				for (int k=i; k<i+3; k++) {
					System.out.printf("\t%d*%d=%2d", k, j, k*j);
				}
				// j=1, k=3���� ���� (3*1=3)
				System.out.println();
			}
			// i=1, j=9, (k=3)���� ���� (3*9=27)
			System.out.println();
		}
	}
}
