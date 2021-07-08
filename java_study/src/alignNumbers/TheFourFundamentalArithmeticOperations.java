package alignNumbers;

import java.util.Scanner;

public class TheFourFundamentalArithmeticOperations {

	public static int plus(int x, int y) {
			return x+y;
	}
	public static int minus(int x, int y) {
			return x-y;
	}
	public static int multiply(int x, int y) {
			return x*y;
	}
	public static int divide(int x, int y) {
			return x/y;
	}
	public static int remainder(int x, int y) {
			return x%y;
	}
	
	public static void disp(int a, char b, int c, int d) {
		// 문자열과의 결합은 문자열로 인식함
		System.out.println(a+" "+b+" "+c+" = "+d);
	}
	
	public static void main(String[] args) {
		// new 키워드 사용하여 객체 생성. 객체를 통해 스캐너를 사용함
		Scanner scan = new Scanner(System.in);
		
		String cal;
		char b;
		System.out.print("첫 번째 정수: ");
		int num1 = scan.nextInt();
		do {
		System.out.print("연산기호: ");
		cal = scan.next();
		b = cal.charAt(0);
		}
		while(!cal.equals("+") && !cal.equals("-") && !cal.equals("*") 
				&& !cal.equals("/") && !cal.equals("%"));
		System.out.print("두 번째 정수: ");
		int num2 = scan.nextInt();
		
		int result = 0;
		switch(cal) {
		case "+":
			result = plus(num1, num2);
			break;
		case "-":
			result = minus(num1, num2);
			break;
		case "*":
			result = multiply(num1, num2);
			break;
		case "/":
			result = divide(num1, num2);
			break;
		case "%":
			result = remainder(num1, num2);
			break;
		}
		disp(num1, b, num2, result);
		
	}
}
