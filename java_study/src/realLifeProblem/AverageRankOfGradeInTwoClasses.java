package realLifeProblem;

import java.util.Scanner;

public class AverageRankOfGradeInTwoClasses {
	static Scanner scan = new Scanner(System.in);
	static String[] subjectName = {"국어", "영어", "수학"};
	// 012 국영수, 3 총점, 4 반석차, 5 전교석차
	static int [][][] subject = new int[2][3][subjectName.length + 3];
	static String[][] name = new String [2][3];
	static double[][] avg = new double [2][3];
	
	public static void main(String[] args) {
		input();
		print();
	}
	
	public static void input() {
		// 2개의 반
		for(int i=0; i<subject.length; i++) {
			// 반마다 3명의 학생
			for(int j=0; j<subject[i].length; j++) {
				System.out.printf("%d반 %d번째 학생 이름: ", i+1, j+1);
				name[i][j] = scan.next();
				// 3개의 과목
				for(int k=0; k<(subject[i][j].length - 3); k++) {
					System.out.printf("%d반 %d번째 학생 %s 점수: ", i+1, j+1, subjectName[k]);
					subject[i][j][k] = scan.nextInt();
					subject[i][j][subjectName.length] += subject[i][j][k];
				} // 과목(k) 끝
				// subject[i][j][3] = i반 j학생의 총점(국영수)
				avg[i][j] = (double) subject[i][j][subjectName.length] / 3;
				// subject[i][j][4] = i반 j학생의 반석차
				subject[i][j][subjectName.length+1] = 1;
				// subject[i][j][5] = i반 j학생의 전교석차
				subject[i][j][subjectName.length+2] = 1;
			} // 학생(j) 끝
			// 반석차 매기기
 			for(int j=0; j<subject[i].length; j++) { // 반석차를 매길 학생
				for(int k=0; k<subject[i].length; k++) { // 반 학생들과 비교
					if (subject[i][j][subjectName.length]<subject[i][k][subjectName.length]) {
						subject[i][j][subjectName.length+1]++;
				}
				}
			}
		} // 반(i) 끝
		
		// 전교석차 매기기
		for(int i=0; i<subject.length; i++) { // 석차 매길 학생의 반(0~1)
			// 비교되는 학생의 반(0~1). 이거 없으면 같은 반 내에서만 비교함.
			for(int j=0; j<subject.length; j++) {
				for(int k=0; k<subject[i].length; k++) { // 석차 매길 학생의 번호(0~2)
					// 비교되는 학생의 번호(0~2). 이거 없으면 같은 번호의 학생과만 비교함.
					for(int l=0; l<subject[i].length; l++) {
						if (subject[i][k][subjectName.length]<subject[j][l][subjectName.length]) {
							subject[i][k][subjectName.length+2]++;
						}
					}
				}
			}
		}
		
	}
	
	public static void print() {
		// 반
		for(int i=0; i<subject.length; i++) {
			System.out.printf("=========================%d반 성적처리 결과========================\n", i+1);
			System.out.println("이 름     국어    영어    수학      총점       평균  반석차 전교석차");
			// 학생
			for(int j=0; j<subject[i].length; j++) {
				System.out.printf("%s     ", name[i][j]); // 이름 출력
				for(int k=0; k<(subject[i][j].length - 3); k++) {
					System.out.printf("%d     ", subject[i][j][k]); // 국영수 출력
				}
				// 3 총점, (평균), 4 반석차, 5 전교석차
				System.out.printf("%3d     %.2f     %d     %d\n", 
						subject[i][j][subjectName.length], avg[i][j], 
						subject[i][j][subjectName.length + 1], subject[i][j][subjectName.length + 2]);
			}
			System.out.println("==============================================================");
		}
		
	}
}
