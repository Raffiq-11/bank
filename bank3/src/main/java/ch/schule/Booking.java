package ch.schule;

public class Booking {
    /**
     * @uml.property  name="date"
     * Datum der Transaktion (Banktage seit 1.1.1970).
     */
    private int date;
    /**
     * @uml.property  name="amount"
     */
    private long amount;

    /**
     * constructor mit date und amount
     * @date
     * @amount
     *  
     */
    public Booking(int date, long amount)
    {
    	this.date = date;
    	this.amount = amount;
    }
    /**
     * Getter of the property <tt>date</tt>
     * @return  Returns the date.
     * @uml.property  name="date"
     */
    public int getDate() {
		return date;
	}
    
    
    /**
     * Setter of the property <tt>date</tt>
     * @param date  The date to set.
     * @uml.property  name="date"
     */
    public void setDate(int date) {
		this.date = date;
	}

    

    /**
     * Getter of the property <tt>amount</tt>
     * @return  Returns the amount.
     * @uml.property  name="amount"
     */
    public long getAmount() {
		return amount;
	}

    /**
     * Setter of the property <tt>amount</tt>
     * @param amount  The amount to set.
     * @uml.property  name="amount"
     */
    public void setAmount(long amount) {
		this.amount = amount;
	}
    
    /**
	 * Druckt die Buchungszeile
	 */
	public void print(long balance)
	{
		System.out.println( BankUtils.formatBankDate(date)
			+ " " + BankUtils.formatAmount(amount)
			+ " " + BankUtils.formatAmount(balance + amount) );
	}
    

}
