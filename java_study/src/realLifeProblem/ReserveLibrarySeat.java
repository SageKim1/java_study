package realLifeProblem;

import java.util.Scanner;

public class ReserveLibrarySeat {
	static Scanner scan = new Scanner(System.in);
	static String[][][] library = new String[5][5][5];
	static int select, floor, row, column;
	static String name;
	
	// ���� �޼���
	public static void main(String[] args) {
		show();
		while (true) {
			menu();
			switch (select) {
			case 1:
				book();
				break;
			case 2:
				leave();
				break;
			case 3:
				show();
				break;
			case 4:
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
				break;
			}
		}
	}
	
	// 1~5���� �¼� �ȳ���, �¼� ��(��ü/���༮/����) ���
	public static void show() {
		int cnt = 0;
		
		for(int i=0; i<library.length; i++) {
			System.out.printf("%d�� �¼� �ȳ���\n", i+1);
			System.out.println("       1��   2��    3��   4��    5��");
			for(int j=0; j<library[i].length; j++) {
				System.out.printf("%d��", j+1);
				for(int k=0; k<library[i][j].length; k++) {
					if (library[i][j][k] == null) {
						System.out.printf("     ��");
					}
					else {
						cnt++;
						System.out.printf("  %s", library[i][j][k]);
					}
				}	// ���� ��
				System.out.println();
			}	// ���� ��
			System.out.println();
		}
		System.out.printf("��ü 125 �¼�. ����� �¼�: %d��. �� �¼�: %d��.\n", cnt, 125-cnt);
	}	// show �޼ҵ��� ��
	
	// �޴� ����� �޼ҵ�
	public static void menu() {
		System.out.println("\n�޴�\n1 - �¼� ����\n2 - �¼� �ݳ�\n3 - �¼� Ȯ��\n4 - ����\n");
		do {
			System.out.print("�޴� ����: ");
			select = scan.nextInt();
		}
		while(select<1 || select>4);
	}
	
	// �¼� ���� �޼���
	public static void book() {
		do {
			System.out.print("���ϴ� ���� ����(1~5): ");
			floor = scan.nextInt();
			}
			while(floor<1 || floor>5);
			do {
			System.out.print("���ϴ� ���� ����(1~5): ");
			row = scan.nextInt();
			}
			while(row<1 || row>5);
			do {
			System.out.print("���ϴ� ���� ����(1~5): ");
			column = scan.nextInt();
			}
			while(column<1 || column>5);
		
			if (!(library[floor-1][row-1][column-1] == null)) {
				System.out.printf("[%d��][%d��][%d��]�� �̹� ����� �ڸ��Դϴ�.\n", floor, row, column);
			}
			else {
				System.out.print("������ �̸�: ");
				name = scan.next();
				library[floor-1][row-1][column-1] = name;
				System.out.printf("[%d��][%d��][%d��]�� ����Ǿ����ϴ�.\n", floor, row, column);
			}
	}
	
	// �¼� �ݳ� �޼���
	public static void leave() {
		do {
			System.out.print("�ݳ��� ���� ����(1~5): ");
			floor = scan.nextInt();
			}
			while(floor<1 || floor>5);
			do {
			System.out.print("�ݳ��� ���� ����(1~5): ");
			row = scan.nextInt();
			}
			while(row<1 || row>5);
			do {
			System.out.print("�ݳ��� ���� ����(1~5): ");
			column = scan.nextInt();
			}
			while(column<1 || column>5);
			
			if (library[floor-1][row-1][column-1] == null) {
				System.out.printf("[%d��][%d��][%d��]�� ���� ����ֽ��ϴ�.\n", floor, row, column);
			}
			else {
				library[floor-1][row-1][column-1] = null;
				System.out.printf("[%d��][%d��][%d��]�� �ݳ��Ǿ����ϴ�.\n", floor, row, column);
			}
	}
}
