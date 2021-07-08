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
				System.out.println("�ý����� �����մϴ�.");
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
		System.out.println("==== �޴� �����ϼ���. ====");
		System.out.println("1. �� ���� ����\n2. ���� ģ�� ����\n3. ��ü ���� ���\n4. �⺻ ���� ���\n5. ���α׷� ����");
		int select;
		do {
		System.out.print("����>> ");
		select = scan.nextInt();
		}
		while(select<1 || select>5);
		return select;
	}
	
	void setFriend(int select) {
		System.out.print("�̸�: ");
		String name = scan.next();
		System.out.print("��ȭ: ");
		String phoneNum = scan.next();
		System.out.print("�ּ�: ");
		String addr = scan.next();
		System.out.print("����: ");
		String job = scan.next();
		
		if (select == 1) {
			System.out.println();
			friend[cnt++] = new Highschool(name, phoneNum, addr, job);
		}
		else {
			System.out.print("����: ");
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
	
	public void showData() { // 3. ��ü ���� ��¿�
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phoneNum);
		System.out.println("�ּ� : " + addr);
	}
	
	public void showBasicInfo() { // 4. �⺻ ���� ��¿�
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phoneNum);
	}
}


class Highschool extends Friend {
	protected String job;
	
	Highschool(String name, String phoneNum, String addr, String job) {
		super(name, phoneNum, addr);
		this.job = job;
	}
	
	@Override
	public void showData() { // 3. ��ü ���� ��¿�
		super.showData();
		System.out.println("���� : " + job);
	}
}


class University extends Highschool {
	protected String major;
	
	University(String name, String phoneNum, String addr, String job, String major) {
		super(name, phoneNum, addr, job);
		this.major = major;
	}
	
	@Override
	public void showData() { // 3. ��ü ���� ��¿�
		super.showData();
		System.out.println("���� : " + major);
	}
	
	@Override
	public void showBasicInfo() { // 4. �⺻ ���� ��¿�. �޼ҵ� �������̵�.
		super.showBasicInfo();
		System.out.println("���� : " + major);
	}
}
