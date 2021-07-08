package realLifeProblem;

public class GetChangeInSupermarket {
	public static void main(String[] args) {
		// 또또면은 개당 70원, 꽁꽁바는 개당 30원
		int ddo = 70, ggong = 30;
		
		// 또또면 2개와 꽁꽁바 3개 구매
		int amount1 = 2, amount2 = 3;
		int price1 = ddo*amount1;
		int price2 = ggong*amount2;
		System.out.println("또또면 전체 금액: "+price1+"원");
		System.out.println("꽁꽁바 전체 금액: "+price2+"원");
		
		// 1000원을 냈음
		int money = 1000;
		
		// 거스름돈
		int diff = money - (price1+price2);
		System.out.println("거스름 돈: "+diff+"원");
		
		// 500원 동전 개수 계산: 거스름돈 / 500
		// 500원 거슬러 주고 남은 돈: 거스름돈 % 500
		System.out.println("\n거스름 돈 동전의 최소 개수");
		int fiveHundred = diff/500;
		int oneHundred = (diff%500)/100;
		int fifty = ((diff%500)%100)/50;
		int ten = (((diff%500)%100)%50)/10;
		System.out.print("500원: "+fiveHundred+"개, ");
		System.out.print("100원: "+oneHundred+"개, ");
		System.out.print("50원: "+fifty+"개, ");
		System.out.print("10원: "+ten+"개");
	}
}
