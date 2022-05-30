package ch.schule;
import ch.schule.Bank;

public class TestBank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Eine neue Bank erzeugen
		Bank migros = new Bank();
		
		// Konto erstellen
		migros.createAccount("M-301");
		migros.createAccount("M-302");
		migros.createAccount("M-303");
		migros.createAccount("M-304");
		
		System.out.println("Kontostand M-302: " + migros.getAccount("M-302").getBalance() ); // Ausgabe
		
		Account konto = migros.getAccount("M-302");
		migros.deposit("M-302", 1000000000);
		System.out.println("Kontostand M-302: " + migros.getAccount("M-302").getBalance()/100000 + " in Fr." ); // Ausgabe
		
	}

}
