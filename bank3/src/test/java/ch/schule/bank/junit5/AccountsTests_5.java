package ch.schule.bank.junit5;

import ch.schule.Account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 * mit JUnit v 4
 * @author Luigi Cavuoti
 * @version 1.1
 */

public class AccountsTests_5 {

	@BeforeEach
	public void setUp() throws Exception {

	}

	@AfterEach
	public void tearDown() throws Exception {

	}
	/**
	 * Tested die Initialisierung eines Kontos.
	 */
	@Test
	public void testInit()
	{
		Account a = new Account("A-1000");

		assertEquals("A-1000", a.getId());
		assertEquals(0, a.getBalance());
	}
	@Test
	public void testDeposit() {
		Account a = new Account("A-1000");

	    // CHF 1.-- einzahlen
		assertTrue(a.deposit(16670, 100000));
		// Saldo muss 1.-- sein
		assertEquals(100000, a.getBalance());

	    // CHF 2.00 einzahlen
		assertTrue(a.deposit(16663, 200000));
	    // Saldo muss 3.-- sein
		assertEquals(300000, a.getBalance());

		// Versuch, negativen Betrag einzuzahlen
		// darf nicht gehen. Saldo muss unver�ndert
		// bleiben
	    assertFalse(a.deposit(16663, -50000));
		assertEquals(300000, a.getBalance());
	}

	@Test
	public void testWithdraw() {
		Account a = new Account("A-1000");

		// CHF 1.-- abheben
		assertTrue(a.withdraw(16663, 100000));
		// Saldo muss -1.-- sein
		assertEquals(-100000, a.getBalance());

		// CHF 2.00 abheben
		assertTrue(a.withdraw(16663, 200000));
		// Saldo muss -3.-- sein
		assertEquals(-300000, a.getBalance());

		// Versuch, negativen Betrag abzuheben
		// darf nicht gehen. Saldo muss unver�ndert
		// bleiben
		assertFalse(a.withdraw(16663, -50000));
		assertEquals(-300000, a.getBalance());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		System.out.println("--- Gesamtauszüge ---");
		Account a = new Account("A-1000");

		a.deposit(18800, 1000000);
		a.withdraw(18801, 200000);
		a.withdraw(18841, 200000);
		a.print();
	}

	/**
	 * Experimente mit print(year,month).
	 */
	@Test
	public void testMonthlyPrint()
	{
		System.out.println("--- Monatsauszüge ---");

		Account a = new Account("A-1000");

		a.deposit(0, 1000000);
		a.withdraw(1, 200000);
		a.withdraw(31, 200000);

		a.print(2022, 1);
		a.print(2022, 2);
	}


}
