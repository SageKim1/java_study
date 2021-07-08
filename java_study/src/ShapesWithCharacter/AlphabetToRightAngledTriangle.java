package ShapesWithCharacter;

public class AlphabetToRightAngledTriangle {
	public static void main(String[] args) {
		
		// A´Â 65 ~ Z´Â 90
		/*
		for (int i=65; i<=90; i++) {
			for (int j=65; j<=i; j++) {
				System.out.print((char)j);
			}
			System.out.println();
		}
		*/
		
		for (char i='A'; i<='Z'; i++) {
			for (char j='A'; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
}
