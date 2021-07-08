package alignNumbers;

import java.util.Scanner;

public class HistogramRangeOfNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num = new int[10]; // 10개의 정수를 입력받을 배열 변수
		int[] cnt = new int[10]; // 수의 범위별 개수를 세기 위한 배열 변수
		
		System.out.println("1~99 사이의 정수를 10개 입력>>");
		for (int i=0; i<10; i++) {
			num[i] = scan.nextInt();
			// 1~99를 벗어나는 숫자 -> 아래 부분 무시하고 for로 돌아감
			if (num[i]<1 || num[i]>99) {
				System.out.println("범위 밖입니다. 다시 입력하세요.");
				// continue로 for문으로 올라갔을 때, i++ 때문에 i는 1이 됨
				// i = 0부터 시작하기 위해 1을 빼줌
				i--;
				continue;
			}
			// num의 십 자릿수 = cnt의 인덱스 숫자
			cnt[num[i]/10]++;
		}
		
		// 10개의 범위 (1~9, 10~19, ..., 90~99)
		for(int i=0; i<10; i++) {
			// 범위 출력. 첫 번째 범위는 0이 아닌 1에서 시작
			if (i==0)
				System.out.printf("%2d~%2d: ", i*10 + 1, i*10 + 9);
			else
				System.out.printf("%2d~%2d: ", i*10, i*10 + 9);
			// 개수(cnt)만큼 별 출력
			for(int j=0; j<cnt[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
