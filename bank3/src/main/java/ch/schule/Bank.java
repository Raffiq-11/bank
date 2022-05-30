package ch.schule;

import java.util.*;

/**
 * Die Bank.
 * 
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */
public class Bank {
	/**
	 * @uml.property name="accounts"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     aggregation="composite"
	 *                     inverse="bank:ch.schule.m326.bank.Account"
	 */
	private ArrayList<Account> accounts;

	/**
	 * Getter of the property <tt>accounts</tt>
	 * 
	 * @return Returns the accounts1.
	 * @uml.property name="accounts"
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/**
	 * Setter of the property <tt>accounts</tt>
	 * 
	 * @param accounts
	 *            The accounts1 to set.
	 * @uml.property name="accounts"
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * Initialisiert eine neue Bank.
	 */
	public Bank() {
		this.accounts = new ArrayList<Account>();
	}

	/**
	 * Erzeugt ein neues Konto
	 * 
	 * @param id
	 *            String die Kontonummer des neuen Kontos
	 * @return boolean ob das Erstellen gefunzt hat
	 */
	public boolean createAccount(String id) {
		// 1. Pr�fen, ob Konto schon vorhanden, return
		// false, falls vorhanden
		for (int i = 0; i < accounts.size(); i++) {
			Account a = (Account) accounts.get(i);

			if (a.getId().equals(id))
				return false;
		}

		// 2. Neues Konto erstellen und in die Liste
		// einf�gen
		Account b = new Account(id);
		accounts.add(b);

		return true;
	}

	/**
	 * Gibt den Kontostand des Kontos mit der gegebenen Kontonummer zur�ck.
	 * 
	 * <p>
	 * Falls kein Konto mit der gesuchten Kontonummer existiert, gibt diese
	 * Methode 0 (zero) zur�ck.
	 * </p>
	 * 
	 * @param id
	 *            die Kontonummer
	 * @return long der Kontostand des Kontos
	 */
	public long getBalance(String id) {
		for (int i = 0; i < accounts.size(); ++i) {
			Account a = (Account) accounts.get(i);

			if (a.getId().equals(id)) {
				return a.getBalance();
			}
		}

		return 0;
	}

	/**
	 * Zahlt den gegebenen Betrag auf das Konto mit der gegebenen Kontonummer
	 * ein.
	 * 
	 * <p>
	 * Diese Methode kann <code>false</code> zur�ckgeben, falls das Konto
	 * nicht existiert, oder falls die Einzahlung auf dem Konto nicht
	 * funktioniert.
	 * </p>
	 * 
	 * @param id
	 *            die Kontonummer
	 * @param amount
	 *            der einzuzahlende Betrag
	 * @return boolean ob die Einzahlung erfolgreich war
	 */
	public boolean deposit(String id, long amount, int date) {
		// 1. Konto suchen
		for (int i = 0; i < accounts.size(); i++) {
			Account a = (Account) accounts.get(i);

			if (a.getId().equals(id)) {
				// Konto gefunden: einzahlen und
				// Erfolg zur�ckgeben
				return a.deposit(date, amount);
			}
		}
		// Alle Konten durchsucht, aber das richtige
		// nicht gefunden
		return false;
	}

	/**
	 * Hebt den gegebenen Betrag vom Konto mit der gegebenen Kontonummer ab.
	 * 
	 * <p>
	 * Diese Methode kann <code>false</code> zur�ckgeben, falls das Konto
	 * nicht existiert, oder falls das Abheben vom Konto nicht funktioniert.
	 * </p>
	 * 
	 * @param id
	 *            die Kontonummer
	 * @param amount
	 *            der abzuhebende Betrag
	 * @return boolean ob das Abheben erfolgreich war
	 */
	public boolean withdraw(String id, long amount, int date) {
		// 1. Konto suchen
		for (int i = 0; i < accounts.size(); i++) {
			Account a = (Account) accounts.get(i);

			if (a.getId().equals(id)) {
				// Konto gefunden: abheben und
				// Erfolg zur�ckgeben
				return a.withdraw(date, amount);
			}
		}

		// Alle Konten durchsucht, aber das richtige
		// nicht gefunden
		return false;
	}

}
