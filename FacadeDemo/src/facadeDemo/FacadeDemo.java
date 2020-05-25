package facadeDemo;

// https://www.javabrahman.com/design-patterns/facade-design-pattern-in-java/

// Account Debit
class AccountDebitor{
	public void debitAccount(String accNo, Double amount){
		System.out.println("Debit " + amount + " from account: " + accNo);
	} 
}

// Credit to Account
class AccountCreditor{
	public void creditAccount(String accNo, Double amount){
		System.out.println("Credit " + amount + " into account: " + accNo);
	} 
}

// Fixed Deposit
class FDIssuer{
	public void issueFD(Double amount){
		System.out.println("FD: " + amount);
	} 
}

// Facade
class BankingFacade{
	AccountCreditor creditor=new AccountCreditor();
	AccountDebitor debitor=new AccountDebitor();
	FDIssuer fdIssuer=new FDIssuer();
	
	public void onlineTransfer(String fromAcc, String toAcc, Double amount){
		debitor.debitAccount(fromAcc, amount);
		creditor.creditAccount(toAcc, amount);
	}
	
	public void atmWithdrawal(String fromAcc, Double amount){
		debitor.debitAccount(fromAcc, amount);
	}
	
	public void issueFD(String fromAcc, Double amount){
		debitor.debitAccount(fromAcc, amount);
		fdIssuer.issueFD(amount);
	} 
}

// Client
public class FacadeDemo {
	private BankingFacade facade;
	
	public FacadeDemo(BankingFacade facade){
		this.facade=facade;
	}  
	
	public static void main(String args[]){
		BankingFacade facade = new BankingFacade();
		facade.onlineTransfer("1001","1002",10000.00);
		facade.atmWithdrawal("1001",1000.00);
		facade.issueFD("1002",500.00);
	} 
}
