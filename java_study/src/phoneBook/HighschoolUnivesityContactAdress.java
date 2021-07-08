package phoneBook;

import java.util.Scanner;

public class HighschoolUnivesityContactAdress {
	public static void main(String[] args) {
		Manager manager = new Manager();
		
		while (true) {
			int select = manager.menu();
			
			switch(select) {
			case 1:
				manager.setFriend(select);
				break;
			case 2:
				manager.setFriend(select);
				break;
			case 3:
				manager.printAll();
				break;
			case 4:
				manager.printBasic();
				break;
			case 5:
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
		}
	}
}

class Manager {
	Scanner scan = new Scanner(System.in);
	private Friend[] friend = new Friend[20];
	private int cnt = 0;
	
	int menu() {
		System.out.println("==== 메뉴 선택하세요. ====");
		System.out.println("1. 고교 정보 저장\n2. 대학 친구 저장\n3. 전체 정보 출력\n4. 기본 정보 출력\n5. 프로그램 종료");
		int select;
		do {
		System.out.print("선택>> ");
		select = scan.nextInt();
		}
		while(select<1 || select>5);
		return select;
	}
	
	void setFriend(int select) {
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("전화: ");
		String phoneNum = scan.next();
		System.out.print("주소: ");
		String addr = scan.next();
		System.out.print("직업: ");
		String job = scan.next();
		
		if (select == 1) {
			System.out.println();
			friend[cnt++] = new Highschool(name, phoneNum, addr, job);
		}
		else {
			System.out.print("전공: ");
			String major = scan.next();
			System.out.println();
			friend[cnt++] = new University(name, phoneNum, addr, job, major);
		}
	}
	
	void printAll() {
		for(int i=0; i<cnt; i++) {
			friend[i].showData();
			System.out.println();
		}
	}
	
	void printBasic() {
		for(int i=0; i<cnt; i++) {
			friend[i].showBasicInfo();
			System.out.println();
		}
	}
}


class Friend {
	protected String name;
	protected String phoneNum;
	protected String addr;
	
	public Friend(String name, String phoneNum, String addr) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
	}
	
	public void showData() { // 3. 전체 정보 출력용
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
		System.out.println("주소 : " + addr);
	}
	
	public void showBasicInfo() { // 4. 기본 정보 출력용
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
	}
}


class Highschool extends Friend {
	protected String job;
	
	Highschool(String name, String phoneNum, String addr, String job) {
		super(name, phoneNum, addr);
		this.job = job;
	}
	
	@Override
	public void showData() { // 3. 전체 정보 출력용
		super.showData();
		System.out.println("직업 : " + job);
	}
}


class University extends Highschool {
	protected String major;
	
	University(String name, String phoneNum, String addr, String job, String major) {
		super(name, phoneNum, addr, job);
		this.major = major;
	}
	
	@Override
	public void showData() { // 3. 전체 정보 출력용
		super.showData();
		System.out.println("전공 : " + major);
	}
	
	@Override
	public void showBasicInfo() { // 4. 기본 정보 출력용. 메소드 오버라이딩.
		super.showBasicInfo();
		System.out.println("전공 : " + major);
	}
}
