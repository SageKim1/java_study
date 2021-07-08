package simpleGame;

public class HitAndMissLottery {
	public static void main(String[] args) {
		int[] count = new int[10];
		
		for(int i=0; i<10; i++) {
			// 0~9 범위의 난수를 10번 생성
			int num = (int)(Math.random()*10);;
			// 난수와 같은 숫자의 배열을 찾음
			// 해당 배열에 저장된 값을 (기본값 0에서) 1씩 증가시킴
			count[num]++;
			System.out.print(num+" ");
		}
		System.out.println("\n");
		
		// 배열 숫자와 일치하는 난수가 나온 횟수를 출력함
		for(int i=0; i<10; i++) {
			System.out.printf("[%d]: %d번\n", i, count[i]);
		}
		
		// 가장 많은 횟수(max)를 찾음
		int max = 0;
		for(int i=0; i<10; i++) {
			if (count[i]>max) {
				max = count[i];
			}
		}
		System.out.println();
		
		// 횟수가 max인 count[i]를 모두 출력함
		// 그러한 count[i]의 개수를 출력함
		int count2 = 0;
		for(int i=0; i<10; i++) {
			if (count[i]==max) {
			System.out.printf("당첨: count[%d] ", i);
			count2++;
			}
		}
		System.out.println("\n당첨자의 수: "+count2);
	}
}
