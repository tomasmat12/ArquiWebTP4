package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bill_Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;	
	@ManyToOne
	@JoinColumn(name="id_bill")
	private Bill bill;
	private Long price;
	private int quantity;
	
		
	
	public Bill_Product(Product product, Bill bill, Long price, int quantity) {
		super();
		this.product = product;
		this.bill = bill;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Bill_Product [id=" + id + ", product=" + product + ", bill=" + bill + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
}
