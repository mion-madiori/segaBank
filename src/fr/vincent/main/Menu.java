package fr.vincent.main;

import java.util.List;
import java.util.Scanner;

import fr.vincent.DTO.Account;
import fr.vincent.DTO.Agency;
import fr.vincent.DTO.PaidAccount;
import fr.vincent.DTO.SavingAccount;
import fr.vincent.DTO.SimpleAccount;

public class Menu {
	final Scanner sc = new Scanner(System.in);
	private Agency agency = new Agency();
	private Account masterAccount;
	
	public void CreateAccount() {
		System.out.println("Créer un compte");
		System.out.println("1 - compte simple");
		System.out.println("2 - compte épargne");
		System.out.println("3 - compte payant");
		selectAccount(sc.nextInt());
	}

	private void selectAccount(int typeAccount) {
		switch (typeAccount) {
		case 1:
			createSimple();
			break;
		case 2:
			createSaving();
			break;
		case 3:
			createPaid();
			break;

		default:
			System.out.println("Mauvais choix...");
			break;
		}
	}
	
	private void createSimple() {
		SimpleAccount account = new SimpleAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
		agency.addAccount(account);
		masterAccount = account;
		showAllAcounts();
	}
	
	private void createSaving() {
		SavingAccount account = new SavingAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
		agency.addAccount(account);
		masterAccount = account;
		showAllAcounts();
	}
	
	private void createPaid() {
		PaidAccount account = new PaidAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
		agency.addAccount(account);
		masterAccount = account;
		showAllAcounts();
	}
	
	private void showAllAcounts() {
		for (int i = 0, lt = agency.getListAccounts().size(); i < lt; i++) {
			System.out.println(agency.getListAccounts().get(i));
		}
		System.out.println("1 - ajouter un compte");
		System.out.println("2 - créditer");
		System.out.println("3 - débiter");
		
		selectOperation(sc.nextInt());
	}
	
	private void selectOperation(int typeAccount) {
		switch (typeAccount) {
		case 1:
			selectAccount(typeAccount);
			break;
		case 2:
			addOperation();
			break;
		case 3:
			minusOperation();
			break;

		default:
			System.out.println("Mauvais choix...");
			break;
		}
	}
	
	private void addOperation() {
		
	}
	
	private void minusOperation() {
		
	}
}
