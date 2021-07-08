package alignNumbers;

public class ArrayNumbersRow5Column5 {
	public static void main(String[] args) {
		int[][] rand = new int[5][5];
		int cnt = 0;
		
		for(int i=0; i<rand.length; i++) {
			for(int j=0; j<rand[i].length; j++) {
				
				if (cnt<15) {
					int num = (int)(Math.random()*10);
					if (num!=0)
					cnt++;
				
					rand[i][j] = num;
				}
				
				System.out.printf("%3d ", rand[i][j]);
			} // j 반복문 끝 (열)
			System.out.println();
		} // i 반복문 끝 (행)
	}
}
