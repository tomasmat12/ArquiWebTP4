package arquiweb.spring.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	private int dni;
	private String name;
	private String lastname;
	private String address;
	
	
	
	
	public Client(int dni, String name, String lastname, String address) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDni() {
		return dni;
	}
	@Override
	public String toString() {
		return "Client [dni=" + dni + ", name=" + name + ", lastname=" + lastname + ", address=" + address + "]";
	}
	
	
	
}
