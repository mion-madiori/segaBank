package fr.vincent.DTO;

public class SavingAccount extends Account {
	private final int interestRate = 3;
	
	public Float calculateInterest() {
		return balance + (balance * interestRate / 100);
	}
}
