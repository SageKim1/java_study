package simpleGame;

import java.util.Random;
import java.util.Scanner;

public class FlingOfTheDice {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�ֻ��� ������ �����մϴ�.");
		System.out.println("����� ���ϴ�.\n");
		
		System.out.print("������� �ֻ����� �����ڽ��ϴ�.(ENTER �Է�)");
		String enter1 = scan.nextLine();
		int user = rand.nextInt(6)+1;
		System.out.println("������� ����: " + user + "\n");
		
		System.out.print("��ǻ���� �ֻ����� �����ڽ��ϴ�.(ENTER �Է�)");
		String enter2 = scan.nextLine();
		int com = rand.nextInt(6)+1;
		System.out.println("��ǻ���� ����: " + com + "\n");
		
		if (user>com)
			System.out.println("������� �¸�");
		else if (user<com)
			System.out.println("��ǻ���� �¸�");
		else
			System.out.println("�����ϴ�.");
	}
}
