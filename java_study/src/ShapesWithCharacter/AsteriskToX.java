package ShapesWithCharacter;

public class AsteriskToX {
	public static void main(String[] args) {
		// 행렬이 있으면 무조건 중첩 for
		for (int i=1; i<6; i++) {
			for (int j=1; j<6; j++) {
				if (j==i || j==6-i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
