package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse 'Bank'.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BankTests_5
{
	@Test
	public void testCreate()
	{
		Bank b = new Bank();

	    assertTrue( b.createAccount("A-1000"));
	    assertTrue( b.createAccount("A-1020"));

		assertTrue(b.createAccount("A-1001"), "A-1001");
	}

	@Test
	public void testDeposit()
	{
		Bank b = new Bank();
		b.createAccount("A-1000");
		b.createAccount("A-1001");

	    assertTrue(   b.deposit("A-1000", 100000, 16000)   );
		assertEquals(100000, b.getBalance("A-1000"));
		assertEquals(0, b.getBalance("A-1001"));

		assertTrue(b.deposit("A-1001", 200000, 0));
		assertEquals(100000, b.getBalance("A-1000"));
		assertEquals(200000, b.getBalance("A-1001"));

		assertFalse(b.deposit("A-1002", 0, 200000));
		assertEquals(100000, b.getBalance("A-1000"));
		assertEquals(200000, b.getBalance("A-1001"));
	}

	@Test
	public void testWithdraw()
	{
		Bank b = new Bank();
		b.createAccount("A-1000");
		b.createAccount("A-1001");

		assertTrue(b.withdraw("A-1000", 0, 100000));
		assertEquals(0,
				b.getBalance("A-1000"));
		assertEquals(0, b.getBalance("A-1001"));

		assertTrue(b.withdraw("A-1001", 0, 200000));
		assertEquals(0, b.getBalance("A-1000"));
		assertEquals(0, b.getBalance("A-1001"));

		assertFalse(b.withdraw("A-1002", 0, 200000));
		assertEquals(0, b.getBalance("A-1000"));
		assertEquals(0, b.getBalance("A-1001"));
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		System.out.println("-- Gesamtausz�ge --");
		Bank b = new Bank();

	    b.createAccount("A-1012");
		b.createAccount("A-1013");

	    b.deposit("A-1000", 1, 10000000);
		b.deposit("A-1001", 2, 20000000);
		b.withdraw("A-1000", 3, 1000000);
		b.withdraw("A-1001", 4, 2000000);


	}



}
