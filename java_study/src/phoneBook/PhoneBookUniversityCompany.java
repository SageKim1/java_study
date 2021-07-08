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
				System.out.println("������ �Է�");
				System.out.println("-------------");
				manager.inputData();
				break;
			case 2:
				System.out.println("-------------");
				System.out.println("������ �˻�");
				System.out.println("-------------");
				manager.search();
				break;
			case 3:
				System.out.println("-------------");
				System.out.println("������ ����");
				System.out.println("-------------");
				manager.delete();
				break;
			case 4:
				System.out.println("-------------");
				System.out.println("������ ���");
				System.out.println("-------------");
				manager.print();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
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
		System.out.println("�޴� �Է��ϼ���...");
		System.out.println("1. ������ �Է�\n2. ������ �˻�\n3. ������ ����\n4. ������ ���\n5. ���α׷� ����");
		
		int select;
		do {
		System.out.print("����: ");
		select = scan.nextInt();
		}
		while(select<1 || select>5);
		return select;
	}
	
	// ������ �Է�
	void inputData() {
		System.out.println("1. �Ϲ�   2. ����   3. ȸ��");
		int type;
		do {
		System.out.print("���� ����: ");
		type = scan.nextInt();
		}
		while(type<1 || type>3);
		
		System.out.print("�̸�: ");
		String name = scan.next();
		System.out.print("��ȭ��ȣ: ");
		String phoneNum = scan.next();
		System.out.print("�ּ�: ");
		String addr = scan.next();
		
		switch(type) {
		case 1:
			System.out.println();
			
			phone[cnt++] = new PhoneBookInfo(name, phoneNum, addr);
			break;
		case 2:
			System.out.print("����: ");
			String major = scan.next();
			System.out.print("�г�: ");
			String year = scan.next();
			System.out.println();
			
			phone[cnt++] = new UniInfo(name, phoneNum, addr, major, year);
			break;
		case 3:
			System.out.print("ȸ��: ");
			String company = scan.next();
			System.out.println();
			
			phone[cnt++] = new CompanyInfo(name, phoneNum, addr, company);
			break;
		}
	}
	
	// ������ �˻�
	void search() {
		System.out.print("�˻��� �̸�: ");
		String name = scan.next();
		
		for(int i=0; i<cnt; i++) {
			if (name.equals(phone[i].name)) {
				System.out.println("�˻� ����");
				phone[i].showPhoneInfo(); // ��ġ�ϴ� ���� ���
				System.out.println();
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸��� �����ϴ�.");
	}
	
	// ������ ����
	void delete() {
		System.out.print("������ �̸�: ");
		String name = scan.next();
		
		for(int i=0; i<cnt; i++) {
			if (name.equals(phone[i].name)) {
				System.out.println("�˻� ����. �����͸� �����մϴ�.\n");
				
				for(int j=i; j<cnt-1; j++) {
					phone[j] = phone[j+1];
				}
				cnt--;
				
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸��� �����ϴ�. ���� ����.");
	}
	
	// ������ ���
	void print() {
		for(int i=0; i<cnt; i++) {
			phone[i].showPhoneInfo();
			System.out.println();
		}
	}
}

class PhoneBookInfo {
	protected String name; // �̸�
	protected String phoneNum; // ��ȭ��ȣ
	protected String addr; // �ּ�
	
	public PhoneBookInfo(String name, String phoneNum, String addr) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
	}
	
	// �������� �޼ҵ�
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
		super(name, phoneNum, addr); // �θ� ������ ȣ��
		this.major = major;
		this.year = year;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo(); // �θ� �޼ҵ� ȣ��
		System.out.println("major : "  + major);
		System.out.println("year : "  + year);
	}
}

class CompanyInfo extends PhoneBookInfo {
	protected String company;
	
	CompanyInfo(String name, String phoneNum, String addr, String company) {
		super(name, phoneNum, addr); // �θ� ������ ȣ��
		this.company = company;
	}

	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo(); // �θ� �޼ҵ� ȣ��
		System.out.println("company : " + company);
	}
}