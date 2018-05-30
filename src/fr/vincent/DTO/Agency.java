package fr.vincent.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agency implements Serializable{
	private String code;
	private String address;
	private List<Account> listAccounts = new ArrayList<Account>();
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setListAccounts(List<Account> listAccounts) {
		this.listAccounts = listAccounts;
	}

	private static int count = 0;
	
	
	public Agency() {
		super();
		count++;
	}

	public List<Account> getListAccounts() {
		return listAccounts;
	}

	public void addAccount(Account account) {
		listAccounts.add(account);
	}
}
