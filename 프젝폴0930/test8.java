package week5_homework;

class Account{
	int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	void deposit(int balance) {
		this.balance += balance; 
	}
	
	void deposit(int[] balance) {
		for (int i = 0; i < balance.length; i++) {
			this.balance += balance[i]; 
		}
	}
	
	int getBalance() {
		return this.balance;
	}
	
	int withdraw(int money) {
		if(balance< money) {
			money = balance;
			balance = 0;
			return money;
		}
		else {
			balance -= money;
			return money;
		}
	}
}

public class test8 {
	public static void main(String[] args) {
		Account a = new Account(100);
		a.deposit(5000);
		System.out.println("잔금은 "+a.getBalance()+"원입니다.");
		
		int bulk[] = {100,500,200,700};
		a.deposit(bulk);
		System.out.println("잔금은 "+a.getBalance()+"원입니다.");
		
		int money = 1000;
		int wMoney = a.withdraw(money);
		if(wMoney < money)
			System.out.println(wMoney + "원만 인출");
		else
			System.out.println(wMoney + "원만 인출");
		
		System.out.println("잔금은 "+a.getBalance()+"원입니다.");
	}
}
