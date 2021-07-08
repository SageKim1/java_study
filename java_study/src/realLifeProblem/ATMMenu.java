package realLifeProblem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ATMMenu {
	public static void main(String[] args) {
		ATMSystem system = new ATMSystem(); // 기능 완성을 담당하는 클래스의 객체 생성
		
		System.out.println("은행 계좌관리 시스템을 시작합니다.");
		while(true) {
			int select = system.menu(); // 메뉴 선택 값(정수)
			
			switch(select) {
			case 1:
				System.out.println("-------------");
				System.out.println("계좌생성");
				System.out.println("-------------");
				system.init();
				break;
			case 2:
				System.out.println("-------------");
				System.out.println("계좌목록");
				System.out.println("-------------");
				system.get();
				break;
			case 3:
				System.out.println("-------------");
				System.out.println("예금");
				System.out.println("-------------");
				system.deposit();
				break;
			case 4:
				System.out.println("-------------");
				System.out.println("출금");
				System.out.println("-------------");
				system.withdraw();
				break;
			case 5:
				system.remit();
				break;
			case 6:
				System.out.println("-------------");
				System.out.println("이자결산");
				System.out.println("-------------");
				system.settleInterest();
				break;
			case 7:
				System.out.println("시스템을 종료합니다.");
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
		System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 송금 | 6. 이자결산 | 7. 종료");
		System.out.println("-------------------------------------------------------------------");
		int select;
		do {
		System.out.print("선택> ");
		select = scan.nextInt();
		}
		while(select<1 || select>7);
		return select;
	}
	
	// 초기화(계좌생성)
	public void init() {
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("계좌번호: ");
		String accountNum = scan.next();
		System.out.print("예금액: ");
		int deposit = scan.nextInt();
		System.out.print("비밀번호: ");
		int password = scan.nextInt();
		//System.out.print("이율: ");
		//int rate = scan.nextInt();
		
		for(int i=0; i<cnt; i++) {
			if (accountNum.equals(bank[i].getAccountNum())) {
				System.out.println("동일한 계좌가 있습니다.");
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
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		String date = format.format(new Date());
		System.out.println("신규 가입이 " + date + "에 이루어졌습니다.\n");
	}
	
	// 계좌목록 출력
	public void get() {
		for(int i=0; i<cnt; i++) {
			System.out.println("이름: " + bank[i].getOwnerName());
			System.out.println("계좌번호: " + bank[i].getAccountNum());
			System.out.println("예금액: " + bank[i].getDeposit());
			System.out.println("비밀번호: " + bank[i].getPassword());
			//System.out.println("이율: " + bank[i].getRate());
			//System.out.println("원리금 합계: " + bank[i].getTotal());
			System.out.println();
		}
	}
	
	// 조회(계좌번호 필요)
	public int inquiry(String accountNum) {
		int index;
		
		for(int i=0; i<cnt; i++) {
			if (accountNum.equals(bank[i].getAccountNum())) {
				index = i;
				System.out.println("유효한 계좌입니다.");
				return i;
			}
		}
		
		System.out.println("일치하는 계좌번호가 없습니다.");
		return -1;
	}
	
	// 조회(계좌번호, 비밀번호 필요)
	public int inquiry(String accountNum, int password) {
		int index;
		
		for(int i=0; i<cnt; i++) {
			if (accountNum.equals(bank[i].getAccountNum())) {
				index = i;
				System.out.println("유효한 계좌입니다.");
				if (password == bank[i].getPassword()) {
					System.out.println("비밀번호가 일치합니다.");
					return i;
				}
				System.out.println("비밀번호가 일치하지 않습니다.");
				return -1;
			}
		}
		
		System.out.println("일치하는 계좌번호가 없습니다.");
		return -1;
	}
	
	// 입금
	public void deposit() {
		System.out.print("계좌번호: ");
		String num = scan.next();
		System.out.print("예금액: ");
		int money = scan.nextInt();
		
		int index = inquiry(num);
		if (index != -1) {
			bank[index].setDeposit(bank[index].getDeposit() + money);
			System.out.println("예금 성공");
		}
		else {
			System.out.println("예금 실패");
		}
	}
	
	// 출금
	public void withdraw() {
		System.out.print("계좌번호: ");
		String num = scan.next();
		System.out.print("출금액: ");
		int money = scan.nextInt();
		System.out.print("비밀번호: ");
		int password = scan.nextInt();
		
		int index = inquiry(num, password);
		if (index != -1 && money <= bank[index].getDeposit()) {
			bank[index].setDeposit(bank[index].getDeposit() - money);
			System.out.println("출금 성공");
		}
		else if (index != -1 && money > bank[index].getDeposit()) {
			System.out.println("잔액이 부족합니다.");
		}
		else {
			System.out.println("출금 실패");
		}
	}
	
	// 송금
	public void remit() {
		System.out.println("-------------");
		System.out.println("송금: 출금할 계좌");
		System.out.println("-------------");
		System.out.print("계좌번호: ");
		String num1 = scan.next();
		System.out.print("출금액: ");
		int money = scan.nextInt();
		System.out.print("비밀번호: ");
		int password = scan.nextInt();
		
		// 계좌번호, 비밀번호를 매개변수로 보내서 inquiry 함수 호출
		// inquiry에서 매개변수로 보낸 문자열과 일치하는 계좌번호가 있는지 확인
		// 해당 계좌의 비밀번호가 매개변수로 보낸 비밀번호와 일치하는 정수인지 확인
		// 계좌번호, 비밀번호 모두가 일치한다면 인덱스 숫자를 가지고 return함
		// 그렇지 않다면 (인덱스 숫자로서는) 무의미한 값(-1)을 가지고 돌아옴
		int index1 = inquiry(num1, password);
		// 인덱스가 유효한 숫자이고, 희망출금액이 잔액(예금)보다 작거나 같으면 출금 가능
		if (index1 != -1 && money <= bank[index1].getDeposit()) {
			System.out.println("출금 가능");
		}
		// 인덱스가 유효한 숫자이지만, 희망출금액이 잔액보다 많으면 출금 불가능
		else if (index1 != -1 && money > bank[index1].getDeposit()) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		// return 받은 인덱스가 무의미한 숫자면(계좌번호, 비밀번호 중 일치하지 않는 것이 존재함) 출금 불가능
		else {
			System.out.println("출금 불가");
			return;
		}
		
		System.out.println("-------------");
		System.out.println("송금: 입금받을 계좌");
		System.out.println("-------------");
		System.out.print("계좌번호: ");
		String num2 = scan.next();
		// 계좌번호를 매개변수로 보내면서 inquiry 함수 호출
		// inquiry에서 매개변수로 보낸 문자열과 일치하는 계좌번호가 있으면 인덱스 숫자 반환
		// 일치하는 계좌번호를 찾을 수 없으면 (인덱스 숫자로서는) 무의미한 값(-1)을 반환함
		int index2 = inquiry(num2);
		// 계좌번호가 존재함
		if (index2 != -1) {
			// 자신이 소유한 계좌에서 입력했던 금액만큼 출금함
			bank[index1].setDeposit(bank[index1].getDeposit() - money);
			// 타인의 계좌에 해당 금액을 입금함
			bank[index2].setDeposit(bank[index2].getDeposit() + money);
			System.out.println("송금 성공");
		}
		// 입력한 문자열(num2)과 일치하는 계좌번호가 존재하지 않음
		else {
			System.out.println("송금 불가");
			return;
		}
	}
	
	// 이자 결산
	public void settleInterest() {
		System.out.print("계좌번호: ");
		String num = scan.next();
		System.out.print("비밀번호: ");
		int password = scan.nextInt();
		
		int index = inquiry(num, password);
		if (index != -1) {
			System.out.println("이자결산 가능");
		}
		else {
			System.out.println("이자결산 불가");
		}
		
		System.out.print("이율: ");
		int rate = scan.nextInt();
		System.out.print("기간: ");
		int month = scan.nextInt();
		
		bank[index].setRate(rate);
		bank[index].setMonth(month);
		bank[index].setTotal();
		System.out.printf("원리금 합계: %d원\n\n", bank[index].getTotal());
	}
}

class Bank {
	private String ownerName; // 예금주
	private String accountNum; // 계좌번호
	private int deposit; // 예금
	private int rate; // 이율
	private int month; // 기간(단위: 월, 보관한 기간)
	private int total; // 원리금 합계
	private int password; // 계좌의 비밀번호
	
	// get, set 메서드로 필드 값 가져오고 설정하기
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