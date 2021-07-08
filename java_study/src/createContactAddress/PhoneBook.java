package createContactAddress;

import java.util.Scanner;

//����ó ��ü�� ������ Ŭ���� ('���赵'�� ����)
class PhoneInfo {
	// �ʵ�
	String name, phone, addr;
	
	// ������
	public PhoneInfo(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	// �޼���
	public void showPhoneInfo() {
		System.out.println("name: "+name);
		System.out.println("phone: "+phone);
		System.out.println("addr: "+addr);
		System.out.println();
	}
}

//���� �̸��� ���� Ŭ����. ���� �޼ҵ带 ����.
public class PhoneBook {
	public static void main(String[] args) {
		// ����ó '�Ŵ���' ��ü ����
		PBManager pbm = new PBManager();
		
		// ����ڰ� ���Ḧ ���ϱ� ������ ���ѹݺ�
		while(true) {
			// �Ŵ����� menu �޼ҵ带 ������.
			// ��ȯ������ �޴����ð�(select)�� ������.
			int select = pbm.menu();
			
			// �޴����ÿ� ���� �б⹮
			switch(select) {
			// ������ �Է�
			case 1:
				pbm.insert();
				break;
			// ������ �˻� (�̸� ����)
			case 2:
				pbm.search();
				break;
			// ������ ���� (�̸� ����)
			case 3:
				pbm.delete();
				break;
			// ��� ������ ���
			case 4:
				pbm.print();
				break;
			// �ý��� ����
			case 5:
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
				break;
			}
		}
	}
}

//����ó '�Ŵ���'
//PhoneInfo��� (��ü �����) ���赵�� �̿��Ͽ� '��ü �迭'�� ���� ����.
class PBManager {
	Scanner scan = new Scanner(System.in);
	// �迭�� �ε��� ��. �ο�(��ü) �� ī��Ʈ�ϴ� �뵵.
	// current count
	int curCnt = 0;
	// 100���� ��ü(PhoneInfo)�� ������ �迭 ���� (100���� ����� ����ó)
	// �̸��� infoStorage�� ����
	PhoneInfo[] infoStorage = new PhoneInfo[100];
	
	public int menu() {
		System.out.println("��ȭ��ȣ �޴�");
		System.out.println("1. ����");
		System.out.println("2. �˻�");
		System.out.println("3. ����");
		System.out.println("4. ���");
		System.out.println("5. ����");
		
		System.out.print("�޴� ����: ");
		int select = scan.nextInt();
		// �޴� ���ð��� ���� �޼ҵ�� ��ȯ��
		return select;
	}
	
	public void insert() {
		System.out.print("�̸�: ");
		String name = scan.next();
		System.out.print("��ȭ��ȣ: ");
		String phone = scan.next();
		System.out.print("�ּ�: ");
		String addr = scan.next();
		System.out.println();
		// ��ü�� ������ �� �ִ� �ּҰ��� �� �迭 ��ҿ� ���� / ��ü ����
		// curCnt��°�� infoStorage ��ü (����) = PhoneInfo�� ������(�Ű����� 3����)
		infoStorage[curCnt++] = new PhoneInfo(name, phone, addr);
	}
	
	public void search() {
		System.out.print("�˻��� �̸�: ");
		String name = scan.next();
		for(int i=0; i<curCnt; i++) {
			// (i��°�� infoStorage ��ü�� ���� name �ʵ�)�� ���ڿ� = �Է��� ���ڿ�
			if (infoStorage[i].name.equals(name)) {
				infoStorage[i].showPhoneInfo();
			}
		}
	}
	
	public void delete() {
		System.out.print("������ �̸�: ");
		String name = scan.next();
		for(int i=0; i<curCnt; i++) {
			// (i��°�� infoStorage ��ü�� ���� name �ʵ�)�� ���ڿ� = �Է��� ���ڿ�
			if (infoStorage[i].name.equals(name)) {
				// (i~curCnt)��°�� infoStorage ��ü. ���� ������ ��ü�� ���� ��ġ�� ��ܿͼ� ä���
				for(int j=i; j<curCnt; j++) {
					infoStorage[j] = infoStorage[j+1];
				}
				curCnt--;
				System.out.println("�����Ǿ����ϴ�.\n");
				break;
			}
		}
	}
	
	public void print() {
		for(int i=0; i<curCnt; i++) {
			// infoStorage�� Ÿ��: PhoneInfo[]
			// PhoneInfo Ŭ������ �޼ҵ� -> showPhoneInfo
			// infoStorage[i] ��ü�� ���Ͽ� ��� �޼ҵ��� showPhoneInfo()�� �����
			infoStorage[i].showPhoneInfo();
		}
	}
}
