package alignNumbers;

import java.util.Scanner;

public class FindMediumNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int temp; // 임시 값 저장할 정수 변수 선언
		
		System.out.print("정수 3개 입력>> ");
		int first = scan.nextInt();
		int second = scan.nextInt();
		int third = scan.nextInt();
		
		// first>second 충족시키기
		if (second > first) {
			temp = first;	// first 값을 temp에 대입
			first = second;	// second 값을 first에 대입
			second = temp;	// temp 값을 second에 대입
		}
		
		// first>second>third 충족시키기
		if (third > first) {
	    	temp = first;	// first 값을 temp에 대입
	    	first = third;	// third 값을 first에 대입
	    	third = second;	// second 값을 third에 대입
	    	second = temp;	// temp 값을 second에 대입
	    }
		else if (third < first && third >second) {
			temp = second;	// second 값을 temp에 대입
			second = third;	// third 값을 second에 대입
			third = temp;	// temp 값을 third에 대입
		}
		// third<second일 때는 따로 해 줄 게 없음
		
		System.out.printf("중간 값은 %d", second);
	}
}
