package createContactAddress;

import java.util.Scanner;

//연락처 객체를 생성할 클래스 ('설계도'의 역할)
class PhoneInfo {
	// 필드
	String name, phone, addr;
	
	// 생성자
	public PhoneInfo(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	// 메서드
	public void showPhoneInfo() {
		System.out.println("name: "+name);
		System.out.println("phone: "+phone);
		System.out.println("addr: "+addr);
		System.out.println();
	}
}

//파일 이름과 같은 클래스. 메인 메소드를 포함.
public class PhoneBook {
	public static void main(String[] args) {
		// 연락처 '매니저' 객체 생성
		PBManager pbm = new PBManager();
		
		// 사용자가 종료를 원하기 전까진 무한반복
		while(true) {
			// 매니저의 menu 메소드를 실행함.
			// 반환값으로 메뉴선택값(select)을 가져옴.
			int select = pbm.menu();
			
			// 메뉴선택에 따른 분기문
			switch(select) {
			// 데이터 입력
			case 1:
				pbm.insert();
				break;
			// 데이터 검색 (이름 기준)
			case 2:
				pbm.search();
				break;
			// 데이터 삭제 (이름 기준)
			case 3:
				pbm.delete();
				break;
			// 모든 데이터 출력
			case 4:
				pbm.print();
				break;
			// 시스템 종료
			case 5:
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
}

//연락처 '매니저'
//PhoneInfo라는 (객체 생산용) 설계도를 이용하여 '객체 배열'을 만들 예정.
class PBManager {
	Scanner scan = new Scanner(System.in);
	// 배열의 인덱스 값. 인원(객체) 수 카운트하는 용도.
	// current count
	int curCnt = 0;
	// 100개의 객체(PhoneInfo)를 저장할 배열 선언 (100명의 사람의 연락처)
	// 이름은 infoStorage로 정함
	PhoneInfo[] infoStorage = new PhoneInfo[100];
	
	public int menu() {
		System.out.println("전화번호 메뉴");
		System.out.println("1. 저장");
		System.out.println("2. 검색");
		System.out.println("3. 삭제");
		System.out.println("4. 출력");
		System.out.println("5. 종료");
		
		System.out.print("메뉴 선택: ");
		int select = scan.nextInt();
		// 메뉴 선택값을 메인 메소드로 반환함
		return select;
	}
	
	public void insert() {
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("전화번호: ");
		String phone = scan.next();
		System.out.print("주소: ");
		String addr = scan.next();
		System.out.println();
		// 객체를 참조할 수 있는 주소값을 이 배열 요소에 저장 / 객체 생성
		// curCnt번째의 infoStorage 객체 (생성) = PhoneInfo의 생성자(매개변수 3가지)
		infoStorage[curCnt++] = new PhoneInfo(name, phone, addr);
	}
	
	public void search() {
		System.out.print("검색할 이름: ");
		String name = scan.next();
		for(int i=0; i<curCnt; i++) {
			// (i번째의 infoStorage 객체가 가진 name 필드)의 문자열 = 입력한 문자열
			if (infoStorage[i].name.equals(name)) {
				infoStorage[i].showPhoneInfo();
			}
		}
	}
	
	public void delete() {
		System.out.print("삭제할 이름: ");
		String name = scan.next();
		for(int i=0; i<curCnt; i++) {
			// (i번째의 infoStorage 객체가 가진 name 필드)의 문자열 = 입력한 문자열
			if (infoStorage[i].name.equals(name)) {
				// (i~curCnt)번째의 infoStorage 객체. 다음 순서의 객체를 앞의 위치로 당겨와서 채우기
				for(int j=i; j<curCnt; j++) {
					infoStorage[j] = infoStorage[j+1];
				}
				curCnt--;
				System.out.println("삭제되었습니다.\n");
				break;
			}
		}
	}
	
	public void print() {
		for(int i=0; i<curCnt; i++) {
			// infoStorage의 타입: PhoneInfo[]
			// PhoneInfo 클래스의 메소드 -> showPhoneInfo
			// infoStorage[i] 객체를 통하여 멤버 메소드인 showPhoneInfo()를 사용함
			infoStorage[i].showPhoneInfo();
		}
	}
}
