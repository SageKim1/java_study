package realLifeProblem;

public class GetChangeInSupermarket {
	public static void main(String[] args) {
		// �ǶǸ��� ���� 70��, �ǲǹٴ� ���� 30��
		int ddo = 70, ggong = 30;
		
		// �ǶǸ� 2���� �ǲǹ� 3�� ����
		int amount1 = 2, amount2 = 3;
		int price1 = ddo*amount1;
		int price2 = ggong*amount2;
		System.out.println("�ǶǸ� ��ü �ݾ�: "+price1+"��");
		System.out.println("�ǲǹ� ��ü �ݾ�: "+price2+"��");
		
		// 1000���� ����
		int money = 1000;
		
		// �Ž�����
		int diff = money - (price1+price2);
		System.out.println("�Ž��� ��: "+diff+"��");
		
		// 500�� ���� ���� ���: �Ž����� / 500
		// 500�� �Ž��� �ְ� ���� ��: �Ž����� % 500
		System.out.println("\n�Ž��� �� ������ �ּ� ����");
		int fiveHundred = diff/500;
		int oneHundred = (diff%500)/100;
		int fifty = ((diff%500)%100)/50;
		int ten = (((diff%500)%100)%50)/10;
		System.out.print("500��: "+fiveHundred+"��, ");
		System.out.print("100��: "+oneHundred+"��, ");
		System.out.print("50��: "+fifty+"��, ");
		System.out.print("10��: "+ten+"��");
	}
}
