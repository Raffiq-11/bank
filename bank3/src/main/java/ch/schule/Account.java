package ch.schule;

import java.util.ArrayList;

public class Account {

	/**
	 * @uml.property name="bookings"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     aggregation="composite"
	 *                     inverse="account:ch.schule.m326.bank.Booking"
	 */
	private ArrayList<Booking> bookings;

	/**
	 * @uml.property name="id"
	 */
	private String id = "";
	/**
	 * @uml.property name="balance"
	 */
	private long balance;

	/**
	 *
	 * @param id
	 */
	public Account(String id) {
		this();
		this.id = id;
	}

	/**
	 * Default Constructor
	 */
	public Account() {
		super();
		bookings = new ArrayList<Booking>();
	}

	/**
	 * Getter of the property <tt>bookings</tt>
	 *
	 * @return Returns the bookings.
	 * @uml.property name="bookings"
	 */
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	/**
	 * Setter of the property <tt>bookings</tt>
	 *
	 * @param bookings
	 *            The bookings to set.
	 * @uml.property name="bookings"
	 */
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}


	/**
	 * Getter of the property <tt>id</tt>
	 *
	 * @return Returns the id.
	 * @uml.property name="id"
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 *
	 * @param id
	 *            The id to set.
	 * @uml.property name="id"
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter of the property <tt>balance</tt>
	 *
	 * @return Returns the balance.
	 * @uml.property name="balance"
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * Setter of the property <tt>balance</tt>
	 *
	 * @param f
	 *            The balance to set.
	 * @uml.property name="balance"
	 */
	public void setBalance(long f) {
		this.balance = f;
	}

	/**
	 */
	public boolean deposit(int date, long amount) {
		if (amount <= 0)
			return false;

		this.balance += amount;
		// Buchung in die Liste der Buchungen
		bookings.add( new Booking(date, amount) );
		return true;
	}

	/**
	 */
	public boolean withdraw(int date, long amount) {
		if (amount < 0)
			return false;

		this.balance -= amount;
		// Buchung in die Liste der Buchungen
		bookings.add(new Booking(date, -amount));
		return true;
	}

	/**
	 * Druckt den Kontoauszug dieses Kontos.
	 */
	public void print() {
		System.out.println("Kontoauszug '" + id + "'");
		System.out.println("Datum          Betrag       Saldo");

		long saldo = 0;

		for (int i = 0; i < bookings.size(); ++i) {
			Booking b = (Booking) bookings.get(i);
			// druckt die Buchungszeile
			b.print(saldo);
			// das Konto-Saldo wird mit neu berechnet
			saldo += b.getAmount();
		}
	}

	/**
	 * Druckt den Monats-Kontoauszug dieses Kontos.
	 *
	 * @param year
	 *            das Jahr
	 * @param month
	 *            der Monat
	 */
	public void print(int year, int month) {
		System.out.println("Kontoauszug '" + id + "' " + "Monat: " + month
				+ "." + year);
		System.out.println("Datum          Betrag      Saldo");

		int startDate = (year - 1970) * 360 + (month - 1) * 30;
		int endDate = startDate + 30;
		long balance = 0;

		for (int i = 0; i < bookings.size(); ++i) {
			Booking b = (Booking) bookings.get(i);

			if (b.getDate() >= endDate)
				break; // Fertig, aus der Schleife springen

			if (b.getDate() >= startDate)
				b.print(balance);

			balance += b.getAmount();
		}
	}



}
