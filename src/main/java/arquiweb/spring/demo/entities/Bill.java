package arquiweb.spring.demo.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@ManyToOne
	@JoinColumn(name="dni")
	private Client client;
	private Date date;
	private Long total;
	
	
	public Bill(Client client, Date date, Long total) {
		super();
		this.client = client;
		this.date = date;
		this.total = total;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", client=" + client + ", date=" + date + ", total=" + total + "]";
	}
}
