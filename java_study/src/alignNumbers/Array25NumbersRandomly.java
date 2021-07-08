package alignNumbers;

public class Array25NumbersRandomly {
	public static void main(String[] args) {
		
		int[][] rand = new int[5][5];
		int cnt = 0;
		int[] randi = new int[25];
		int[] randj = new int[25];
		
		for(int i=0; i<rand.length; i++) {
			for(int j=0; j<rand[i].length; j++) {
				
				boolean distinct = true;
				if (cnt<15) {
					int num = (int)(Math.random()*9) + 1;	// 1~9
					int numi = (int)(Math.random()*5);	// 0~4
					randi[cnt] = numi;
					int numj = (int)(Math.random()*5);	// 0~4
					randj[cnt] = numj;
					
					for(int k=0; k<cnt; k++) {
						if ((randi[cnt]==randi[k]) && (randj[cnt]==randj[k])) {
							distinct = false;
						}
					}
					
					if (distinct == true) {
						cnt++;
						rand[numi][numj] = num;
					}
				}
			}
		}
		
		for(int i=0; i<rand.length; i++) {
			for(int j=0; j<rand[i].length; j++) {
				System.out.printf("%3d ", rand[i][j]);
			}
			System.out.println();
		}

	}
}
