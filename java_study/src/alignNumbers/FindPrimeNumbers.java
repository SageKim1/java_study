package alignNumbers;

import java.util.Scanner;

public class FindPrimeNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("2부터 몇까지 소수인지 확인할까요?: ");
		int num = scan.nextInt();
		System.out.print("소수: ");
		
		for (int j=2; j<=num; j++) {	// 외부 for문 열기
			/* boolean의 위치가 정확히 여기 와야 함
		    외부 for문 도입부에서 boolean 값을 true로 초기화해야 하기 때문 */
			boolean primeNum = true;
			
			for (int i=2; i<j; i++) {	// 내부 for문 열기
				if (j%i == 0) {
					primeNum = false;
					break;
				}
			}	// 내부 for문 닫기
		
		if (primeNum==true)
				System.out.print(j+" ");
		}	// 외부 for문 닫기
	}
}
