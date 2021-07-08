package ShapesWithCharacter;

public class AsteriskPyramid {
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			for (int j=9-i; j>0; j--) {
				System.out.print(" ");
			}
			for (int j=1; j<2+i*2; j++) {
				System.out.print('*');
			}
			for (int j=9; j>i; j--) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
