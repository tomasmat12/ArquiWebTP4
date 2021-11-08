package arquiweb.spring.demo.dtos;

import java.math.BigInteger;
import java.sql.Date;

public class BillReportDTO {

	private Date date;
	private BigInteger total;
	
	
	public BillReportDTO(Date date, BigInteger total) {
		this.date = date;
		this.total = total;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public BigInteger getTotal() {
		return total;
	}
	
	public void setTotal(BigInteger total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "BillReportDTO [date=" + date + ", total=" + total + "]";
	}
	
}
