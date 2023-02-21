package orderapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import orderapp.products.Apple;
import orderapp.products.Banana;
import orderapp.products.Product;
import orderapp.products.Strawberry;
import orderapp.products.Watermelon;

public class Controller {
	
	List<Product> order = new ArrayList();
	double sum = 0;
	LocalDate date = LocalDate.now();
	List<Customer> customers = new ArrayList();
	
	
	public void runMenu() {
		
		boolean keepGoing = true;
		int menuSelection = 0;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Who are you?");
		String name = sc.nextLine();
		Customer customer = new Customer(name);
		customers.add(customer);
		
		
		while (keepGoing) {		
			System.out.println("---------------------");
			System.out.println("Welcome " + name);
			System.out.println("---------------------");
			System.out.println("Press 1 for make an order");
			System.out.println("Press 2 for save your order's amount");
			System.out.println("Press 3 for display your orders");
			System.out.println("Press 4 for show case log");
			System.out.println("Press 5 for quit");
			System.out.println("---------------------");
			System.out.print("Your decision = ");
			menuSelection = sc.nextInt();
			
			switch (menuSelection) {
				case 1:
					addOrder();
					break;
				case 2:
					saveOrder();
					customer.getOrderList().add(new Invoice(date, sum, name));
					System.out.println("Your orders saved.");
					break;
				case 3:
					displayOrders();
					break;
				case 4:
					// Tüm müşterileri listeleyin
					System.out.println("Tüm Müşteriler:");
				    customers.forEach(System.out::println);
				    System.out.println();
				    
				    // İçerisinde ‘C’ harfi olan müşterileri listeleyin
				    List<Customer> cCustomers = getCustomersWithChar(customers, 'C');
				    System.out.println("C Harfi içeren Müşteriler:");
				    cCustomers.forEach(System.out::println);
				    System.out.println();
				    
				    // Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin
				    double totalJuneInvoiceAmount = getTotalInvoiceAmountForJune(customers);
				    System.out.println("Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı: " + totalJuneInvoiceAmount);
				    System.out.println();
				
				    // Sistemdeki tüm faturaları listeleyin
				    List<Invoice> allInvoices = getAllInvoices(customers);
				    System.out.println("Tüm Faturalar:");
				    allInvoices.forEach(System.out::println);
				    System.out.println();
				    
				    // Sistemdeki 1500TL üstündeki faturaları listeleyin
				    List<Invoice> highValueInvoices = getHighValueInvoices(allInvoices, 1500.0);
				    System.out.println("1500 TL Üzeri Faturalar:");
				    highValueInvoices.forEach(System.out::println);
				    System.out.println();

				    // Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın
				    double avgHighValueInvoices = getAvgHighValueInvoices(highValueInvoices);
				    System.out.println("1500 TL Üzeri Faturaların Ortalaması: " + avgHighValueInvoices);
				    System.out.println();
				    
				    // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin
				    List<Customer> customersWithLowValueInvoices = getCustomersWithLowValueInvoices(customers, 500.0);
				    System.out.println("500 TL Altı Faturalara Sahip Müşteriler:");
				    customersWithLowValueInvoices.forEach(c -> System.out.println(c.getName()));
				    System.out.println();
				    
				    // Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyin.
				    Set<String> industriesWithLowAvgInvoiceAmount = getIndustriesWithLowAvgInvoiceAmount(customers, allInvoices, "June", 750.0);
				    System.out.println("Haziran ayında faturaların ortalaması 750 TL altında olan sektörler:");
				    industriesWithLowAvgInvoiceAmount.forEach(System.out::println);
				    System.out.println();
				    
				case 5:
					keepGoing = false;
					return;
				default:
					unknownCommand();
			}
		}
		exitMessage();    
	}
	
	private void addOrder() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---MENU---");
		System.out.println("1 - Strawberry 1kg = 15TL");
		System.out.println("2 - Watermelon 1kg = 10TL");
		System.out.println("3 - Apple 1kg = 12TL");
		System.out.println("4 - Banana 1kg = 25TL");
		System.out.println("---------------------");
		System.out.print("Which fruit you want to order ?");
		int fruit = sc.nextInt();
		
		System.out.print("How many kilos do you want ?");
		int kilo = sc.nextInt();
		
		if(fruit==1) {
			order.add(new Strawberry(15, kilo));
		}else if(fruit==2) {
			order.add(new Watermelon(15, kilo));
		}else if(fruit==3) {
			order.add(new Apple(12, kilo));
		}else if(fruit==4) {
			order.add(new Banana(25, kilo));
		}else {
			return;
		}
	}
	
	private void saveOrder() {
		sum = 0;
		for(Product product: order) {
			sum += product.getPrice()*product.getPiece();
		}
	}

	private void displayOrders() {
		for(Product product: order) {
			System.out.println(product.getClass().getSimpleName() + " Price = " + product.getPrice() + " Kilos = " + product.getPiece() + " Sum = " + product.getPrice()*product.getPiece());
		}
		System.out.println("Total price = " + sum);
		System.out.println("---------------------");
	}
	
	private void unknownCommand() {
		System.out.println("Wrong input!");
	}

	private void exitMessage() {
		System.out.println("Have a nice day!");
		
	}
	
	private Set<String> getIndustriesWithLowAvgInvoiceAmount(List<Customer> customers2, List<Invoice> allInvoices,
			String string, double d) {
		return null;
	}

	private List<Customer> getCustomersWithLowValueInvoices(List<Customer> customers2, double d) {
		return null;
	}

	private double getAvgHighValueInvoices(List<Invoice> highValueInvoices) {
		return 0;
	}

	private List<Invoice> getHighValueInvoices(List<Invoice> allInvoices, double d) {
		return null;
	}

	private List<Invoice> getAllInvoices(List<Customer> customers2) {
		return null;
	}

	private double getTotalInvoiceAmountForJune(List<Customer> customers2) {
		return 0;
	}

	private List<Customer> getCustomersWithChar(List<Customer> customers2, char c) {
		return null;
	}
		
}
