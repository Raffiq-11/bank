package ch.schule;

public class TestAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setId("A-101");
		// Konto nummer ausgeben
		System.out.println("Konto Nummer ist: "+ account.getId());
		// Einzahlung in mmRp.
		account.deposit(1000000);

		System.out.println("Konto saldo ist: "+ account.getBalance()/100000 + " in CHF");

		// Abheben in mmRp.
		account.withdraw(100000);
		System.out.println("Konto saldo ist: "+ account.getBalance()/100000 + " in CHF");



	}

}
