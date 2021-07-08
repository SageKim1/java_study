package phoneBook;

import java.util.Scanner;

public class PhoneBookUniversityCompany {
	public static void main(String[] args) {
		InfoManager manager = new InfoManager();
		
		while(true) {
			int select = manager.menu();
			
			switch(select) {
			case 1:
				System.out.println("-------------");
				System.out.println("데이터 입력");
				System.out.println("-------------");
				manager.inputData();
				break;
			case 2:
				System.out.println("-------------");
				System.out.println("데이터 검색");
				System.out.println("-------------");
				manager.search();
				break;
			case 3:
				System.out.println("-------------");
				System.out.println("데이터 삭제");
				System.out.println("-------------");
				manager.delete();
				break;
			case 4:
				System.out.println("-------------");
				System.out.println("데이터 출력");
				System.out.println("-------------");
				manager.print();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}
}

class InfoManager {
	Scanner scan = new Scanner(System.in);
	PhoneBookInfo[] phone = new PhoneBookInfo[10];
	int cnt = 0;
	
	int menu() {
		System.out.println("메뉴 입력하세요...");
		System.out.println("1. 데이터 입력\n2. 데이터 검색\n3. 데이터 삭제\n4. 데이터 출력\n5. 프로그램 종료");
		
		int select;
		do {
		System.out.print("선택: ");
		select = scan.nextInt();
		}
		while(select<1 || select>5);
		return select;
	}
	
	// 데이터 입력
	void inputData() {
		System.out.println("1. 일반   2. 대학   3. 회사");
		int type;
		do {
		System.out.print("종류 선택: ");
		type = scan.nextInt();
		}
		while(type<1 || type>3);
		
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("전화번호: ");
		String phoneNum = scan.next();
		System.out.print("주소: ");
		String addr = scan.next();
		
		switch(type) {
		case 1:
			System.out.println();
			
			phone[cnt++] = new PhoneBookInfo(name, phoneNum, addr);
			break;
		case 2:
			System.out.print("전공: ");
			String major = scan.next();
			System.out.print("학년: ");
			String year = scan.next();
			System.out.println();
			
			phone[cnt++] = new UniInfo(name, phoneNum, addr, major, year);
			break;
		case 3:
			System.out.print("회사: ");
			String company = scan.next();
			System.out.println();
			
			phone[cnt++] = new CompanyInfo(name, phoneNum, addr, company);
			break;
		}
	}
	
	// 데이터 검색
	void search() {
		System.out.print("검색할 이름: ");
		String name = scan.next();
		
		for(int i=0; i<cnt; i++) {
			if (name.equals(phone[i].name)) {
				System.out.println("검색 성공");
				phone[i].showPhoneInfo(); // 일치하는 정보 출력
				System.out.println();
				return;
			}
		}
		System.out.println("일치하는 이름이 없습니다.");
	}
	
	// 데이터 삭제
	void delete() {
		System.out.print("삭제할 이름: ");
		String name = scan.next();
		
		for(int i=0; i<cnt; i++) {
			if (name.equals(phone[i].name)) {
				System.out.println("검색 성공. 데이터를 삭제합니다.\n");
				
				for(int j=i; j<cnt-1; j++) {
					phone[j] = phone[j+1];
				}
				cnt--;
				
				return;
			}
		}
		System.out.println("일치하는 이름이 없습니다. 삭제 실패.");
	}
	
	// 데이터 출력
	void print() {
		for(int i=0; i<cnt; i++) {
			phone[i].showPhoneInfo();
			System.out.println();
		}
	}
}

class PhoneBookInfo {
	protected String name; // 이름
	protected String phoneNum; // 전화번호
	protected String addr; // 주소
	
	public PhoneBookInfo(String name, String phoneNum, String addr) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
	}
	
	// 재정의할 메소드
	public void showPhoneInfo() {
		System.out.println("name : "  + name);
		System.out.println("phone : "  + phoneNum);
		System.out.println("addr : "  + addr);
	}
}

class UniInfo extends PhoneBookInfo {
	protected String major;
	protected String year;
	
	UniInfo(String name, String phoneNum, String addr, String major, String year) {
		super(name, phoneNum, addr); // 부모 생성자 호출
		this.major = major;
		this.year = year;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo(); // 부모 메소드 호출
		System.out.println("major : "  + major);
		System.out.println("year : "  + year);
	}
}

class CompanyInfo extends PhoneBookInfo {
	protected String company;
	
	CompanyInfo(String name, String phoneNum, String addr, String company) {
		super(name, phoneNum, addr); // 부모 생성자 호출
		this.company = company;
	}

	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo(); // 부모 메소드 호출
		System.out.println("company : " + company);
	}
}