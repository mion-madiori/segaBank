package fr.vincent.DTO;

import java.util.ArrayList;
import java.util.List;

public class Agency {
	private String code;
	private String address;
	private List<Account> listAccounts = new ArrayList<Account>();
	
	public List<Account> getListAccounts() {
		return listAccounts;
	}

	public void addAccount(Account account) {
		listAccounts.add(account);
	}
}
