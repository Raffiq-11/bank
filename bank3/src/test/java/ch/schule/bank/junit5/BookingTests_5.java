package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi cavuoti
 * @version 1.1
 */
public class BookingTests_5
{
	/**
	 * Tests für die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization()
	{
		Booking b = new Booking(1, 1000);

		assertEquals(1, b.getDate());
		assertEquals(1000, b.getAmount());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
		Booking b;

	    b = new Booking(0, 100000);
		b.print(0);

		b = new Booking(16669, 1000000000);
		b.print(0);
	}
}
