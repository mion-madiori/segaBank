package fr.vincent.DTO;

public class PaidAccount extends Account {
	private final int amountToPaid = 5;
	private Float finalAmount;
	
	@Override
	public void add(Float amount) {
		balance += finalAmount(amount);
	}
	
	@Override
	public void withdrawal(Float amount) throws Exception {
		balance -= finalAmount(amount);
	}
	
	private Float finalAmount(Float amount) {
		return amount - (amount * amountToPaid / 100);
	}
	
	@Override
	public String toString() {
		return String.format("Numéro de compte: %s%nSolde: %s%nPourcentage: %s%n", code, balance, amountToPaid);
	}
}
