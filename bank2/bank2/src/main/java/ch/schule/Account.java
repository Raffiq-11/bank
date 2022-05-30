package ch.schule;

public class Account {


	private long balance = 0;

	private String id;
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getId() {
		return id;
	}

	/**
	 * Setter of the property <tt>accountNumber</tt>
	 *
	 * @param id
	 *            The accountNumber to set.
	 * @uml.property name="accountNumber"
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * einzahlen eines Betrages auf das Konto 1 CHF = 100000 mmRp
	 */
	public boolean deposit(long amount) {
		// 1. positiver Betrag sonst false
		if (amount > 0) {
			balance += amount;
			// 2. Betrag einzahlen und true zurück
			return true;
		}
		// 2. Betrag nicht einbezahlt und false zurück
		return false;
	}

	/**
	 * abheben eines Betrages vom Konto
	 */
	public boolean withdraw(long amount) {
		// 1. positiver Betrag sonst false
		if (amount > 0) {
			balance -= amount;
			// 2. Betrag abheben und true zurück
			return true;
		}
		// Es konnte nicht abgehoben werden
		return false;
	}

}
