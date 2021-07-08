package realLifeProblem;

import java.util.Scanner;

public class ReserveConcertSeat {
	public static void main(String[] args) {
		// ���ѹݺ� (�޴����� ���Ḧ �����ϸ� �ý��� ������)
		while (true) {
			ConcertSystem.menu();
		}
	}
}

class ConcertSystem {
	static Scanner scan = new Scanner(System.in);
	// 3���� ��(0~2). 6���� ��(0~5).
	// 0��: S�� / 1��: A�� / 2��: B��
	// 0 ~ 4��: 5���� �¼�(������ �̸��� ������. �ʱⰪ�� null.)
	// 5��: �¼��� ������ ����(S, A, B).
	static String[][] seats = new String[3][6];
	
	static void menu() {
		// �� ���� 5���� �ش��ϴ� �¼��� ���� �̸��� ������. ����� �뵵.
		// ������ �޼��� ���ο��� �ؾ� ��. (������ �޼��� �ܺο��� ������.)
		seats[0][5] = "S";
		seats[1][5] = "A";
		seats[2][5] = "B";
		
		System.out.println("�ܼ�ƮȦ ���� �ý���");
		// �޴� ���� ��
		int select;
		do {
		System.out.print("����:1   ��ȸ:2   ���:3   ����:4 >> ");
		select = scan.nextInt();
		}
		while(select<1 || select>4);
		
		switch(select) {
		case 1:
			// ���� �޼��� ȣ��
			reserve();
			break;
		case 2:
			// ��ȸ �޼��� ȣ��
			// S��(0), A��(1), B��(2)�� ���������� ���
			view(0);
			view(1);
			view(2);
			System.out.println();
			break;
		case 3:
			// ��� �޼��� ȣ��
			cancel();
			break;
		case 4:
			System.out.println("�ý����� �����մϴ�.");
			System.exit(0);
		}
	}
	
	static void reserve() {
		System.out.println("S��:1, A��:2, B��:3");
		int num;
		do {
		System.out.print("������ �¼��� ����: ");
		num = scan.nextInt();
		}
		while(num<1 || num>3);
		
		// ��� �޼ҵ� ȣ��
		// �迭�� ���� 0~2�ε� �Է��� 1~3���� �޾ұ⿡ 1��ŭ ����.
		view(num-1);
		
		// seats[0][5]: S, seats[1][5]: A, seats[2][5]: B
		System.out.printf("%s�� �� ������ ���ϴ� ", seats[num-1][5]);
		
		int seat;
		do {
		System.out.print("�¼��� ��ȣ�� �Է�: ");
		seat = scan.nextInt();
		}
		while(seat<1 || seat>5);
		
		if (seats[num-1][seat-1] != null) {
			System.out.println("������ �� ���� �¼��Դϴ�.\n");
		}
		else {
			System.out.print("�̸��� �Է��Ͻÿ�: ");
			String name = scan.next();
			// ������ �¼��� �������� �̸� ����
			seats[num-1][seat-1] = name;
			System.out.printf("%s���� %d�� �¼��� ����Ǿ����ϴ�.\n\n", seats[num-1][5], seat);
		}
	}
	
	static void view(int grade) {
		// seats[0][5]: S, seats[1][5]: A, seats[2][5]: B
		System.out.print(seats[grade][5]+" ");
		
		for(int i=0; i<(seats[grade].length)-1; i++) {
			// �¼� ��ȣ ���
			System.out.print(i+1);
			if(seats[grade][i] == null) {
				System.out.print("----");
			}
			// �������� �̸� ���
			else
				System.out.print(seats[grade][i]);
		}
		System.out.println();
	}
	
	static void cancel() {
		System.out.print("�������� ����: ");
		String name = scan.next();
		
		for(int i=0; i<seats.length; i++) {
			for(int j=0; j<(seats[i].length)-1; j++) {
				if (seats[i][j] != null && seats[i][j].equals(name)) {
					seats[i][j] = null;
					System.out.printf("%s���� %d�� �¼��� ��ҵǾ����ϴ�.\n\n", seats[i][5], j+1);
					return;
				}
			}
		}
		System.out.println("��ġ�ϴ� �̸��� �����ϴ�.\n");

	}
}
