package orderapp;

import java.time.LocalDate;

public class Invoice {
    private LocalDate date;
    private double amount;
    private String customerName;
    
	public Invoice(LocalDate date, double amount, String customerName) {
		this.date = date;
		this.amount = amount;
		this.customerName = customerName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Invoice [date=" + date + ", amount=" + amount + ", customerName=" + customerName + "]";
	}
    
	
    
}
