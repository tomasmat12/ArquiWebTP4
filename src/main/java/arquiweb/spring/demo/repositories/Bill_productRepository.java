package arquiweb.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import arquiweb.spring.demo.dtos.BillReportDTO;
import arquiweb.spring.demo.entities.Bill;
import arquiweb.spring.demo.entities.Bill_Product;
import arquiweb.spring.demo.entities.Product;

public interface Bill_productRepository extends JpaRepository<Bill_Product, Object> {
/*
	@Modifying
	//@Query("UPDATE BillProduct SET product = :product, bill = :bill, price = :price, quantity = :quantity WHERE id = :id")
	/*public void updateBill_Product(@Param("product") Product product, @Param("bill") Bill bill, 
								  @Param("price") long price, @Param("quantity") int quantity, @Param("id") int id);
	*/
	
	@Modifying
	@Query("SELECT BillProduct FROM BillProduct WHERE id_bill = :id_bill")
	public List<Bill_Product>  getByIdBill(@Param("id_bill") int id_bill);
	
}
