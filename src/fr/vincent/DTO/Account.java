package fr.vincent.DTO;

public abstract class Account {
	protected Float balance = 0F;
	private int code;
	protected static int count;
	
	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Account() {
		code = count++;
	}
	
	public void add(Float amount) {
		balance += amount;
	}
	
	public void withdrawal(Float amount) throws Exception {
		if(balance - amount < 0) {
			balance -= amount; 			
		} else {
			throw new Exception("D�couvert non-autoris�");
		}
	}
	
	public String toString() {
		return String.format("Num�ro de compte: %s%nSolde: %s%n", code, balance);
	}
}