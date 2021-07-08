package realLifeProblem;

import java.io.IOException;
import java.util.Random;

public class HitNumberStrikeBall {
	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		int cnt = 0;
		
		while(true) {
			int[] question = new int[3];
			int[] answer = new int[3];
				
			boolean bool = false;
			
			for(int i=0; i<question.length; i++) {
				int num;
				do {
					num = rand.nextInt(10);
					for(int j=0; j<i; j++) {
						if (num == question[j]) {
							bool = true;
						}
					}
				}
				while(bool);
				question[i] = num;
				System.out.printf("%d\t", question[i]);
			}
			
			boolean again = false;
			do {
				System.out.print("\n세 개의 수를 중복 없이 연속하여 입력: ");
				for(int i=0; i<answer.length; i++) {
					// read는 기본적으로 키 코드 값(int)으로 입력 받음.
					answer[i] = System.in.read() - 48;
				}
				System.in.read(); // \r
				System.in.read(); // \n
				
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if (answer[i] == answer[j] && i!=j)
							again = true;
					}
				}
			}
			while(again);
			
			int strike = 0, ball = 0;
			for(int i=0; i<3; i++) {
				if (question[i] == answer[i])
					strike++;
				for(int j=0; j<3; j++) {
					if (question[i] == answer[j] && i!=j)
						ball++;
				}
			}
			cnt++;
			
			if (strike<3) {
				System.out.printf("%d strike, %d ball!\n", strike, ball);
			}
			else {
				System.out.printf("3 strike, out! %d번만에 맞추셨습니다.\n", cnt);
				System.exit(0);
			}
		}
	}
}
