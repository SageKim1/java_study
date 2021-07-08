package realLifeProblem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ATMMenu {
	public static void main(String[] args) {
		ATMSystem system = new ATMSystem(); // ��� �ϼ��� ����ϴ� Ŭ������ ��ü ����
		
		System.out.println("���� ���°��� �ý����� �����մϴ�.");
		while(true) {
			int select = system.menu(); // �޴� ���� ��(����)
			
			switch(select) {
			case 1:
				System.out.println("-------------");
				System.out.println("���»���");
				System.out.println("-------------");
				system.init();
				break;
			case 2:
				System.out.println("-------------");
				System.out.println("���¸��");
				System.out.println("-------------");
				system.get();
				break;
			case 3:
				System.out.println("-------------");
				System.out.println("����");
				System.out.println("-------------");
				system.deposit();
				break;
			case 4:
				System.out.println("-------------");
				System.out.println("���");
				System.out.println("-------------");
				system.withdraw();
				break;
			case 5:
				system.remit();
				break;
			case 6:
				System.out.println("-------------");
				System.out.println("���ڰ��");
				System.out.println("-------------");
				system.settleInterest();
				break;
			case 7:
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
				break;
			}
		}
	}
}

class ATMSystem {
	Scanner scan = new Scanner(System.in);
	Bank[] bank = new Bank[10];
	int cnt;
	
	public int menu() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. �۱� | 6. ���ڰ�� | 7. ����");
		System.out.println("-------------------------------------------------------------------");
		int select;
		do {
		System.out.print("����> ");
		select = scan.nextInt();
		}
		while(select<1 || select>7);
		return select;
	}
	
	// �ʱ�ȭ(���»���)
	public void init() {
		System.out.print("�̸�: ");
		String name = scan.next();
		System.out.print("���¹�ȣ: ");
		String accountNum = scan.next();
		System.out.print("���ݾ�: ");
		int deposit = scan.nextInt();
		System.out.print("��й�ȣ: ");
		int password = scan.nextInt();
		//System.out.print("����: ");
		//int rate = scan.nextInt();
		
		for(int i=0; i<cnt; i++) {
			if (accountNum.equals(bank[i].getAccountNum())) {
				System.out.println("������ ���°� �ֽ��ϴ�.");
				return;
			}
		}
		
		bank[cnt] = new Bank();
		bank[cnt].setOwnerName(name);
		bank[cnt].setAccountNum(accountNum);
		bank[cnt].setDeposit(deposit);
		//bank[cnt].setRate(rate);
		bank[cnt].setPassword(password);
		cnt++;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm��");
		String date = format.format(new Date());
		System.out.println("�ű� ������ " + date + "�� �̷�������ϴ�.\n");
	}
	
	// ���¸�� ���
	public void get() {
		for(int i=0; i<cnt; i++) {
			System.out.println("�̸�: " + bank[i].getOwnerName());
			System.out.println("���¹�ȣ: " + bank[i].getAccountNum());
			System.out.println("���ݾ�: " + bank[i].getDeposit());
			System.out.println("��й�ȣ: " + bank[i].getPassword());
			//System.out.println("����: " + bank[i].getRate());
			//System.out.println("������ �հ�: " + bank[i].getTotal());
			System.out.println();
		}
	}
	
	// ��ȸ(���¹�ȣ �ʿ�)
	public int inquiry(String accountNum) {
		int index;
		
		for(int i=0; i<cnt; i++) {
			if (accountNum.equals(bank[i].getAccountNum())) {
				index = i;
				System.out.println("��ȿ�� �����Դϴ�.");
				return i;
			}
		}
		
		System.out.println("��ġ�ϴ� ���¹�ȣ�� �����ϴ�.");
		return -1;
	}
	
	// ��ȸ(���¹�ȣ, ��й�ȣ �ʿ�)
	public int inquiry(String accountNum, int password) {
		int index;
		
		for(int i=0; i<cnt; i++) {
			if (accountNum.equals(bank[i].getAccountNum())) {
				index = i;
				System.out.println("��ȿ�� �����Դϴ�.");
				if (password == bank[i].getPassword()) {
					System.out.println("��й�ȣ�� ��ġ�մϴ�.");
					return i;
				}
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				return -1;
			}
		}
		
		System.out.println("��ġ�ϴ� ���¹�ȣ�� �����ϴ�.");
		return -1;
	}
	
	// �Ա�
	public void deposit() {
		System.out.print("���¹�ȣ: ");
		String num = scan.next();
		System.out.print("���ݾ�: ");
		int money = scan.nextInt();
		
		int index = inquiry(num);
		if (index != -1) {
			bank[index].setDeposit(bank[index].getDeposit() + money);
			System.out.println("���� ����");
		}
		else {
			System.out.println("���� ����");
		}
	}
	
	// ���
	public void withdraw() {
		System.out.print("���¹�ȣ: ");
		String num = scan.next();
		System.out.print("��ݾ�: ");
		int money = scan.nextInt();
		System.out.print("��й�ȣ: ");
		int password = scan.nextInt();
		
		int index = inquiry(num, password);
		if (index != -1 && money <= bank[index].getDeposit()) {
			bank[index].setDeposit(bank[index].getDeposit() - money);
			System.out.println("��� ����");
		}
		else if (index != -1 && money > bank[index].getDeposit()) {
			System.out.println("�ܾ��� �����մϴ�.");
		}
		else {
			System.out.println("��� ����");
		}
	}
	
	// �۱�
	public void remit() {
		System.out.println("-------------");
		System.out.println("�۱�: ����� ����");
		System.out.println("-------------");
		System.out.print("���¹�ȣ: ");
		String num1 = scan.next();
		System.out.print("��ݾ�: ");
		int money = scan.nextInt();
		System.out.print("��й�ȣ: ");
		int password = scan.nextInt();
		
		// ���¹�ȣ, ��й�ȣ�� �Ű������� ������ inquiry �Լ� ȣ��
		// inquiry���� �Ű������� ���� ���ڿ��� ��ġ�ϴ� ���¹�ȣ�� �ִ��� Ȯ��
		// �ش� ������ ��й�ȣ�� �Ű������� ���� ��й�ȣ�� ��ġ�ϴ� �������� Ȯ��
		// ���¹�ȣ, ��й�ȣ ��ΰ� ��ġ�Ѵٸ� �ε��� ���ڸ� ������ return��
		// �׷��� �ʴٸ� (�ε��� ���ڷμ���) ���ǹ��� ��(-1)�� ������ ���ƿ�
		int index1 = inquiry(num1, password);
		// �ε����� ��ȿ�� �����̰�, �����ݾ��� �ܾ�(����)���� �۰ų� ������ ��� ����
		if (index1 != -1 && money <= bank[index1].getDeposit()) {
			System.out.println("��� ����");
		}
		// �ε����� ��ȿ�� ����������, �����ݾ��� �ܾ׺��� ������ ��� �Ұ���
		else if (index1 != -1 && money > bank[index1].getDeposit()) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		// return ���� �ε����� ���ǹ��� ���ڸ�(���¹�ȣ, ��й�ȣ �� ��ġ���� �ʴ� ���� ������) ��� �Ұ���
		else {
			System.out.println("��� �Ұ�");
			return;
		}
		
		System.out.println("-------------");
		System.out.println("�۱�: �Աݹ��� ����");
		System.out.println("-------------");
		System.out.print("���¹�ȣ: ");
		String num2 = scan.next();
		// ���¹�ȣ�� �Ű������� �����鼭 inquiry �Լ� ȣ��
		// inquiry���� �Ű������� ���� ���ڿ��� ��ġ�ϴ� ���¹�ȣ�� ������ �ε��� ���� ��ȯ
		// ��ġ�ϴ� ���¹�ȣ�� ã�� �� ������ (�ε��� ���ڷμ���) ���ǹ��� ��(-1)�� ��ȯ��
		int index2 = inquiry(num2);
		// ���¹�ȣ�� ������
		if (index2 != -1) {
			// �ڽ��� ������ ���¿��� �Է��ߴ� �ݾ׸�ŭ �����
			bank[index1].setDeposit(bank[index1].getDeposit() - money);
			// Ÿ���� ���¿� �ش� �ݾ��� �Ա���
			bank[index2].setDeposit(bank[index2].getDeposit() + money);
			System.out.println("�۱� ����");
		}
		// �Է��� ���ڿ�(num2)�� ��ġ�ϴ� ���¹�ȣ�� �������� ����
		else {
			System.out.println("�۱� �Ұ�");
			return;
		}
	}
	
	// ���� ���
	public void settleInterest() {
		System.out.print("���¹�ȣ: ");
		String num = scan.next();
		System.out.print("��й�ȣ: ");
		int password = scan.nextInt();
		
		int index = inquiry(num, password);
		if (index != -1) {
			System.out.println("���ڰ�� ����");
		}
		else {
			System.out.println("���ڰ�� �Ұ�");
		}
		
		System.out.print("����: ");
		int rate = scan.nextInt();
		System.out.print("�Ⱓ: ");
		int month = scan.nextInt();
		
		bank[index].setRate(rate);
		bank[index].setMonth(month);
		bank[index].setTotal();
		System.out.printf("������ �հ�: %d��\n\n", bank[index].getTotal());
	}
}

class Bank {
	private String ownerName; // ������
	private String accountNum; // ���¹�ȣ
	private int deposit; // ����
	private int rate; // ����
	private int month; // �Ⱓ(����: ��, ������ �Ⱓ)
	private int total; // ������ �հ�
	private int password; // ������ ��й�ȣ
	
	// get, set �޼���� �ʵ� �� �������� �����ϱ�
	public int getMonth() { return month; }
	public void setMonth(int month) { this.month = month; }
	public String getOwnerName() { return ownerName; }
	public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
	public String getAccountNum() { return accountNum; }
	public void setAccountNum(String accountNum) { this.accountNum = accountNum; }
	public int getDeposit() { return deposit; }
	public void setDeposit(int deposit) { this.deposit = deposit; }
	public int getRate() { return rate; }
	public void setRate(int rate) { this.rate = rate; }
	public void setTotal() { total = deposit + (deposit*rate)/100*month; }
	public int getTotal() { return total; }
	public int getPassword() { return password; }
	public void setPassword(int password) { this.password = password; }
	
}