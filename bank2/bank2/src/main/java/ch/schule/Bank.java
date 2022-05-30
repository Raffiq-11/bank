package ch.schule;
import java.util.ArrayList;
import java.util.Iterator;

public class Bank {

	/**
	 * @uml.property name="accounts"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     aggregation="composite" inverse="bank:Account"
	 */
	private ArrayList<Account> accounts;

	public Bank()
	{
		accounts = new ArrayList<Account>();
	}

	/**
	 * Getter of the property <tt>accounts</tt>
	 *
	 * @return Returns the accounts.
	 * @uml.property name="accounts"
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/**
	 * ertellt ein neues konto und fügt es der Liste zu
	 */
	public void createAccount(String accountNumber) {
		// 1. neues Konto erstellen
		Account account = new Account();
		account.setId(accountNumber);
		// 2. in die Liste einfügen
		accounts.add(account);

	}

	/**
	 * gibt das Konto zurück mit der übergebenen Konto-Nummer
	 */
	public Account getAccount(String accountNumber) {
		 // 1. Account suchen
	    for (int i=0; i<this.accounts.size();)
	    {
	        Account a = accounts.get(i);
	        if (a.getId().equals(accountNumber))
	        {
	            // Konto gefunden!
	            return a;
	        }  else
	        {
	        	return null;
	        }
	    }
	    // Falls alle Konti durch und nicht gefunden
	    // 2. Konto nicht gefunden null
		return null;
	}
	/**
	 * Mit Iterator
	 * @param accountNumber
	 * @return
	 */
	public Account getAccountIterator(String accountNumber) {

		Iterator<Account> it = accounts.iterator();
		// 1. Account suchen
	    while (it.hasNext())
	    {
	    	Account a = (Account) it.next();
	    	if (a.getId().equals(accountNumber))
	        {
	            // Konto gefunden!
	            return a;
	        }
	    }
	    // Falls alle Konti durch und nicht gefunden
	    // 2. Konto nicht gefunden null
		return null;
	}

	/**
	 * l�sccht das enteprechende Konto aus der Liste
	 */
	public boolean deleteAccount(String accountNumber) {

		// 1. Konto suchen

		// 2. Konto löschen
		return false;
	}

	/**
	 * sucht das Konto mit der KOntonummer und ruft deposit() des jeweiligen
	 * Kontos auf
	 *
	 */

	public boolean deposit(String kontoNummer, long amount) {

		// 1. Konto suchen in der Liste

				// Juhui Konto gefunden
				// Jetzt aufs Konto einzahlen
				// 2. deposit() vom Konto aufrufen

				// es hat geklappt


		// Konto nicht gefunden können nicht einzahlen
		return false;
	}

	/**
	 * sucht das Konto mit der Kontonummer und ruft withdraw() des Kontos auf
	 *
	 */
	public boolean withdraw(String KontoNummer, long amount) {
		// 1. Konto suchen

		// 2. withdraw des Kontos aufrufen

		return false;

	}

	/**
	 * Setter of the property <tt>accounts</tt>
	 *
	 * @param accounts
	 *            The accounts to set.
	 * @uml.property name="accounts"
	 */
	private void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
