package orderapp.products;

public abstract class Product {
	private double price;
	private int piece;
	
	public Product(double price, int piece) {
		this.price = price;
		this.piece = piece;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", piece=" + piece + "]";
	}
	
	

}
