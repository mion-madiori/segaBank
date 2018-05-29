package fr.vincent.main;

import java.util.Scanner;

import fr.vincent.DTO.PaidAccount;
import fr.vincent.DTO.SavingAccount;
import fr.vincent.DTO.SimpleAccount;

public class Menu {
	final Scanner sc = new Scanner(System.in);
	
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
	}
	
	private void createSaving() {
		SavingAccount account = new SavingAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
	}
	
	private void createPaid() {
		PaidAccount account = new PaidAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
	}
}
