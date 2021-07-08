package alignNumbers;

import java.util.Scanner;

public class FourArithmeticOperationsWithMenu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int option;
		
		do {
		System.out.print("¸Þ´º ¼±ÅÃ: 1. µ¡¼À  2. »¬¼À  3. °ö¼À  4. ³ª´°¼À ? ");
		option = scan.nextInt();
		}
		while(option!=1 && option!=2 && option!=3 && option!=4);
		
		System.out.print("Ã¹ ¹øÂ° ¼ö: ");
		int num1 = scan.nextInt();
		System.out.print("µÎ ¹øÂ° ¼ö: ");
		int num2 = scan.nextInt();
		
		switch(option) {
		case 1:
			System.out.println("µ¡¼À °á°ú´Â "+(num1+num2));
			break;
		case 2:
			System.out.println("»¬¼À °á°ú´Â "+(num1-num2));
			break;
		case 3:
			System.out.println("°ö¼À °á°ú´Â "+(num1*num2));
			break;
		case 4:
			System.out.println("³ª´°¼À °á°ú´Â "+(num1/num2));
			break;
		}
	}
}
