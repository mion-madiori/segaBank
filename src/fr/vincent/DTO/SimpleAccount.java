package fr.vincent.DTO;

public class SimpleAccount extends Account {
	private int overdraft = 0;

	@Override
	public void withdrawal(Float amount) throws Exception {
		if (balance - amount < overdraft) {
			balance -= amount;
		} else {
			throw new Exception("D�couvert non-autoris�");
		}
	}
	
	@Override
	public String toString() {
		return String.format("Num�ro de compte: %s%nSolde: %s%nD�couvert: %s%n", code, balance, overdraft);
	}
}
