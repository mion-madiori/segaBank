package fr.vincent.DTO;

public class SimpleAccount extends Account {
	private int overdraft = 0;

	@Override
	public void withdrawal(Float amount) throws Exception {
		if (balance - amount < overdraft) {
			balance -= amount;
		} else {
			throw new Exception("Découvert non-autorisé");
		}
	}
}
