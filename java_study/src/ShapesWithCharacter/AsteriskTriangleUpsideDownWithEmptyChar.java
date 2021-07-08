package ShapesWithCharacter;

public class AsteriskTriangleUpsideDownWithEmptyChar {
	public static void main(String[] args) {
		// 10, 9, 8, ..., 1
		for (int i=10; i>0; i--) {
			// 0, 1, 2, ..., 9
			for (int j=0; j<10-i; j++) {
				System.out.print(' ');
			}
			// 10, 9, 8, ..., 1
			for (int j=i; j>0; j--) {
				System.out.print('*');
			}
			System.out.println();
		}	
	}
}
