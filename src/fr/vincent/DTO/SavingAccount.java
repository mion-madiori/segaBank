package fr.vincent.DTO;

public class SavingAccount extends Account {
	private final Float interestRate = 3F;
	
	public Float calculateInterest() {
		return balance + (balance * interestRate / 100);
	}
	
	@Override
	public String toString() {
		return String.format("Num�ro de compte: %s%nSolde: %s%nTaux d'int�ret: %s%n", code, balance, interestRate);
	}
}
