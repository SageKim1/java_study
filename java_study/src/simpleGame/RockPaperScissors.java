package simpleGame;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String c, y, yn;
		int ynum;
		int game=0;
		int victory=0;
	    int draw=0;
	    int lose=0;
		System.out.println("����, ����, �� �����Դϴ�.");
		
		do {
			do {
			System.out.print("�����: ");
			c = scan.next();
			}
			while(!c.equals("����") && !c.equals("����") && !c.equals("��"));
			
			ynum = rand.nextInt(3)+1;
			if (ynum==1) {
				y = "��";
			}
			else if (ynum==2) {
				y = "����";
			}
			else {
				y = "����";
			}
			System.out.printf("��ǻ��: %s\n", y);
			
			
			if (c.equals("����") && y.equals("��") || c.equals("����") && y.equals("����")
					|| c.equals("��") && y.equals("����")) {
				System.out.println("�̰���ϴ�.");
				game++;
				victory++;
			}
			else if (c.equals(y)) {
				System.out.println("�����ϴ�.");
				game++;
				draw++;
			}
			else {
				System.out.println("�����ϴ�.");
				game++;
				lose++;
			}
			
			System.out.print("������ ����ұ��?(Y/N)");
			yn = scan.next();
			System.out.println();
		}
		while (yn.equals("y") || yn.equals("Y"));
		
		System.out.printf("����� �̱� Ƚ��: %d\n", victory);
		System.out.printf("��ǻ�� �̱� Ƚ��: %d\n", lose);
		System.out.printf("��� Ƚ��: %d\n", draw);
		System.out.printf("�·��� %.1f%%�Դϴ�.(���ºδ� ��꿡�� ����)\n", (double)victory/(victory+lose)*100);
		System.out.println("�ý����� ����Ǿ����ϴ�.");
	}
}
