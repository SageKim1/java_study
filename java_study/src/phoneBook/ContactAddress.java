package phoneBook;

import java.util.Scanner;

class PhoneInfo {
	String name, phone, addr;
	
	public PhoneInfo(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	public void showPhoneInfo() {
		System.out.println("name: "+name);
		System.out.println("phone: "+phone);
		System.out.println("addr: "+addr);
		System.out.println();
	}
}

public class ContactAddress {
	public static void main(String[] args) {
		PBManager pbm = new PBManager();
		
		while(true) {
			int select = pbm.menu();
			
			switch(select) {
			case 1:
				pbm.insert();
				break;
			case 2:
				pbm.search();
				break;
			case 3:
				pbm.delete();
				break;
			case 4:
				pbm.print();
				break;
			case 5:
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
}

class PBManager {
	Scanner scan = new Scanner(System.in);
	int curCnt = 0;
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
		infoStorage[curCnt++] = new PhoneInfo(name, phone, addr);
	}
	
	public void search() {
		System.out.print("검색할 이름: ");
		String name = scan.next();
		for(int i=0; i<curCnt; i++) {
			if (infoStorage[i].name.equals(name)) {
				infoStorage[i].showPhoneInfo();
			}
		}
	}
	
	public void delete() {
		System.out.print("삭제할 이름: ");
		String name = scan.next();
		for(int i=0; i<curCnt; i++) {
			if (infoStorage[i].name.equals(name)) {
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
			infoStorage[i].showPhoneInfo();
		}
	}
}