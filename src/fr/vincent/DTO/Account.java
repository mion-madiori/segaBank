package fr.vincent.DTO;

import java.io.Serializable;

public abstract class Account implements Serializable{
	protected Float balance = 0F;
	protected int code;
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
			throw new Exception("Découvert non-autorisé");
		}
	}
	
	public String toString() {
		return String.format("Numéro de compte: %s%nSolde: %s%n", code, balance);
	}

	public int getCode() {
		return code;
	}
}
