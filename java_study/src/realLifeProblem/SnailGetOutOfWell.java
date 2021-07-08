package realLifeProblem;

public class SnailGetOutOfWell {
	public static void main(String[] args) {
		int count = 0;
		int move;
		
		// 달팽이가 우물(높이 100)을 올라가 빠져나가려는 상황. ?만큼 올라갔다가 ?만큼 미끄러져 내려옴.
		// 총 올라간 거리가 50보다 작음 -> 6만큼 올라간 후 2만큼 미끄러짐. 결과적으로 매회 4만큼 올라감.
		for(move = 4; move<50; move+=4) {
			count++;
			System.out.printf("%2d) 달팽이가 이동한 높이: %d\n", count, move);
		}
		System.out.println("-> 거리가 50보다 작을 때\n");
		move -= 4; //  move+=4 때문에 4가 더해졌지만 move<50의 조건을 만족하지 못했음. 4만큼 빼줌.
		
		while (true) {
			move += 5;
			count++;
			if (move<=100) {
				// 5만큼 올라갔다가 2만큼 미끄러짐.
				move -= 2;
				System.out.printf("%2d) 달팽이가 이동한 높이: %d\n", count, move);
			}
			else if (move>100) {
				// 우물을 빠져나감.
				break;
			}
		}
		System.out.printf("탈출 성공! 달팽이의 총 이동 횟수: %d번", count);
	}
}
