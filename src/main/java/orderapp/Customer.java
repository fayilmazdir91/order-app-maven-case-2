package orderapp;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Invoice> orderList = new ArrayList();
    
	public Customer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Invoice> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Invoice> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
       
}
