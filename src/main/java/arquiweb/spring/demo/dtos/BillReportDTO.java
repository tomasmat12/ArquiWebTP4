package arquiweb.spring.demo.dtos;

import java.math.BigInteger;

public class BillReportDTO {

	private String date;
	private BigInteger total;
	
	
	public BillReportDTO(String date, BigInteger total) {
		this.date = date;
		this.total = total;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
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
