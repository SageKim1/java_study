package realLifeProblem;

import java.util.Scanner;

public class AverageRankOfGradeInTwoClasses {
	static Scanner scan = new Scanner(System.in);
	static String[] subjectName = {"����", "����", "����"};
	// 012 ������, 3 ����, 4 �ݼ���, 5 ��������
	static int [][][] subject = new int[2][3][subjectName.length + 3];
	static String[][] name = new String [2][3];
	static double[][] avg = new double [2][3];
	
	public static void main(String[] args) {
		input();
		print();
	}
	
	public static void input() {
		// 2���� ��
		for(int i=0; i<subject.length; i++) {
			// �ݸ��� 3���� �л�
			for(int j=0; j<subject[i].length; j++) {
				System.out.printf("%d�� %d��° �л� �̸�: ", i+1, j+1);
				name[i][j] = scan.next();
				// 3���� ����
				for(int k=0; k<(subject[i][j].length - 3); k++) {
					System.out.printf("%d�� %d��° �л� %s ����: ", i+1, j+1, subjectName[k]);
					subject[i][j][k] = scan.nextInt();
					subject[i][j][subjectName.length] += subject[i][j][k];
				} // ����(k) ��
				// subject[i][j][3] = i�� j�л��� ����(������)
				avg[i][j] = (double) subject[i][j][subjectName.length] / 3;
				// subject[i][j][4] = i�� j�л��� �ݼ���
				subject[i][j][subjectName.length+1] = 1;
				// subject[i][j][5] = i�� j�л��� ��������
				subject[i][j][subjectName.length+2] = 1;
			} // �л�(j) ��
			// �ݼ��� �ű��
 			for(int j=0; j<subject[i].length; j++) { // �ݼ����� �ű� �л�
				for(int k=0; k<subject[i].length; k++) { // �� �л���� ��
					if (subject[i][j][subjectName.length]<subject[i][k][subjectName.length]) {
						subject[i][j][subjectName.length+1]++;
				}
				}
			}
		} // ��(i) ��
		
		// �������� �ű��
		for(int i=0; i<subject.length; i++) { // ���� �ű� �л��� ��(0~1)
			// �񱳵Ǵ� �л��� ��(0~1). �̰� ������ ���� �� �������� ����.
			for(int j=0; j<subject.length; j++) {
				for(int k=0; k<subject[i].length; k++) { // ���� �ű� �л��� ��ȣ(0~2)
					// �񱳵Ǵ� �л��� ��ȣ(0~2). �̰� ������ ���� ��ȣ�� �л����� ����.
					for(int l=0; l<subject[i].length; l++) {
						if (subject[i][k][subjectName.length]<subject[j][l][subjectName.length]) {
							subject[i][k][subjectName.length+2]++;
						}
					}
				}
			}
		}
		
	}
	
	public static void print() {
		// ��
		for(int i=0; i<subject.length; i++) {
			System.out.printf("=========================%d�� ����ó�� ���========================\n", i+1);
			System.out.println("�� ��     ����    ����    ����      ����       ���  �ݼ��� ��������");
			// �л�
			for(int j=0; j<subject[i].length; j++) {
				System.out.printf("%s     ", name[i][j]); // �̸� ���
				for(int k=0; k<(subject[i][j].length - 3); k++) {
					System.out.printf("%d     ", subject[i][j][k]); // ������ ���
				}
				// 3 ����, (���), 4 �ݼ���, 5 ��������
				System.out.printf("%3d     %.2f     %d     %d\n", 
						subject[i][j][subjectName.length], avg[i][j], 
						subject[i][j][subjectName.length + 1], subject[i][j][subjectName.length + 2]);
			}
			System.out.println("==============================================================");
		}
		
	}
}
