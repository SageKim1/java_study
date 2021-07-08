package ShapesWithCharacter;

public class AsteriskTriangleWithEmptyChar {
	public static void main(String[] args) {;
		// 0, 1, 2, 3, ... 9
		for (int i=0; i<10; i++) {
			// 9, 8, 7, 6, ... 0
			for (int j=9-i; j>=0; j--) {
				System.out.print(" ");
			}
			// 1, 2, 3, 4, ... 10
			for (int j=0; j<i+1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
