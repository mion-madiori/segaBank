package fr.vincent.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.vincent.DAO.AgencyDAO;
import fr.vincent.DTO.Account;
import fr.vincent.DTO.Agency;
import fr.vincent.DTO.PaidAccount;
import fr.vincent.DTO.SavingAccount;
import fr.vincent.DTO.SimpleAccount;

public class Menu {
	final Scanner sc = new Scanner(System.in);
	private Agency agency;
	private AgencyDAO agencyDAO = new AgencyDAO();
	private Account masterAccount;
	private List<Agency> listAgencies = new ArrayList<Agency>();

	public void agency() throws Throwable {
		System.out.println("Agence:");
		System.out.println("1 - Créer une agence");
		System.out.println("2 - Séléctionner une agence");
		System.out.println("3 - Supprimer une agence");
		selectAgency(sc.nextInt());
	}
	
	private void selectAgency(int agencyChoice) throws Throwable {
		switch (agencyChoice) {
		case 1:
			createAgency();
			break;
		case 2:
			listAgency();
			break;
		case 3:
			removeAgency(sc.nextInt());
			break;

		default:
			System.out.println("Mauvais choix...");
			break;
		}
	}
	
	private void listAgency() throws Throwable {
		for (int i = 0, lt = listAgencies.size(); i < lt; i++) {
			System.out.println((i + 1) + " " + listAgencies.get(i).getAddress());
		}
		
		System.out.println("Sélectionner une agence:");

		agency = listAgencies.get(sc.nextInt() - 1);
		
		System.out.println(agency.getAddress());
		sc.nextLine();
		createAccount();
	}
	
	private void createAgency() throws Throwable {
		sc.nextLine();
		agency = new Agency();
		listAgencies.add(agency);
		System.out.println("Adresse de l'agence");
		agency.setAddress(sc.nextLine());
		createAccount();
	}
	
	private void removeAgency(int value) throws Throwable {
		sc.nextLine();
		
		for (int i = 0, lt = listAgencies.size(); i < lt; i++) {
			System.out.println((i + 1) + " " + listAgencies.get(i).getAddress());
		}
		
		System.out.println("Sélectionner une agence:");
		listAgencies.remove(value - 1);
		agency();
	}
	
	private void createAccount() throws Throwable {
		System.out.println("Créer un compte");
		System.out.println("1 - compte simple");
		System.out.println("2 - compte épargne");
		System.out.println("3 - compte payant");
		System.out.println("4 - supprimer un compte");
		System.out.println("5 - modifier un compte");
		System.out.println("6 - retour");
		selectAccount(sc.nextInt());
		sc.nextLine();
	}

	private void selectAccount(int typeAccount) throws Throwable {
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
		case 4:
			removeAccount();
			break;
		case 5:
			updateAccount();
			break;
		case 6:
			agency();
			break;
		default:
			System.out.println("Mauvais choix...");
			break;
		}
	}
	
	private void createSimple() throws Throwable {
		Account account = new SimpleAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
		agency.addAccount(account);
		masterAccount = account;
		showAllAcounts();
	}
	
	private void createSaving() throws Throwable {
		SavingAccount account = new SavingAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
		agency.addAccount(account);
		masterAccount = account;
		showAllAcounts();
	}
	
	private void createPaid() throws Throwable {
		PaidAccount account = new PaidAccount();
		System.out.println("Montant initial?");
		account.setBalance(sc.nextFloat());
		agency.addAccount(account);
		masterAccount = account;
		showAllAcounts();
	}
	
	private void showAllAcounts() throws Throwable {
		for (int i = 0, lt = agency.getListAccounts().size(); i < lt; i++) {
			System.out.println(agency.getListAccounts().get(i));
		}
		System.out.println("1 - retour");
		System.out.println("2 - créditer");
		System.out.println("3 - débiter");
		System.out.println("4 - sauvegarder");
		
		selectOperation(sc.nextInt());
	}
	
	private void removeAccount() throws Throwable {
		for (int i = 0, lt = agency.getListAccounts().size(); i < lt; i++) {
			System.out.println(i + " - " + agency.getListAccounts().get(i).getCode() + ": " +
					agency.getListAccounts().get(i).getBalance());
		}
		
		System.out.println("Sélectionner le compte à supprimer:");
		agency.getListAccounts().remove(sc.nextInt());
		sc.nextLine();
		showAllAcounts();
	}
	
	private void updateAccount() throws Throwable{
		for (int i = 0, lt = agency.getListAccounts().size(); i < lt; i++) {
			System.out.println(i + " - " + agency.getListAccounts().get(i).getCode() + ": " +
					agency.getListAccounts().get(i).getBalance());
		}
		
		System.out.println("Sélectionner le compte à supprimer:");
		
		int value = sc.nextInt();
		Account tmp = agency.getListAccounts().get(value);
		System.out.println("Modifier le solde du compte:");
		tmp.setBalance(sc.nextFloat());
		agency.getListAccounts().set(value, tmp);
		//sc.nextLine();
		showAllAcounts();
	}
	
	private void selectOperation(int typeAccount) throws Throwable {
		switch (typeAccount) {
		case 1:
			createAccount();
			break;
		case 2:
			addOperation();
			break;
		case 3:
			minusOperation();
			break;
		case 4:
			saveAgency();
			break;
		default:
			System.out.println("Mauvais choix...");
			break;
		}
	}
	
	private void addOperation() throws Throwable {
		System.out.println("Combien souhaitez-vous créditer?");
		masterAccount.add(sc.nextFloat());
		showAllAcounts();
	}
	
	private void minusOperation() throws Throwable {
		System.out.println("Combien souhaitez-vous retirer?");
		masterAccount.withdrawal(sc.nextFloat());
		showAllAcounts();
	}
	
	private void saveAgency() throws Throwable {
		agencyDAO.saveAgency(listAgencies);
		createAccount();
		showAllAcounts();
	}
}
