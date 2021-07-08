package alignNumbers;

import java.util.Random;

public class ArrangeRandomNumbers {
	public static void main(String[] args) {
		Random rand = new Random();
		
		int[] num = new int[10];
		System.out.println("0~99 사이의 난수 배열 전");
		for(int i=0; i<num.length; i++) {
			num[i] = rand.nextInt(100);
			System.out.print(num[i]+" ");
		}
		System.out.println();
		
		int temp;
		for(int i=0; i<10; i++) {
			for(int j=0; j<i; j++) {
				if (num[i]>num[j]) {
					temp = num[j];
					num[j] = num[i];
					num[i] = temp;
				}
			}
		}
		
		System.out.println("배열 후");
		for (int i=0; i<10; i++) {
			System.out.print(num[i]+" ");
		}
	}
}
