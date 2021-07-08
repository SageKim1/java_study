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
		// ���ڿ����� ������ ���ڿ��� �ν���
		System.out.println(a+" "+b+" "+c+" = "+d);
	}
	
	public static void main(String[] args) {
		// new Ű���� ����Ͽ� ��ü ����. ��ü�� ���� ��ĳ�ʸ� �����
		Scanner scan = new Scanner(System.in);
		
		String cal;
		char b;
		System.out.print("ù ��° ����: ");
		int num1 = scan.nextInt();
		do {
		System.out.print("�����ȣ: ");
		cal = scan.next();
		b = cal.charAt(0);
		}
		while(!cal.equals("+") && !cal.equals("-") && !cal.equals("*") 
				&& !cal.equals("/") && !cal.equals("%"));
		System.out.print("�� ��° ����: ");
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
