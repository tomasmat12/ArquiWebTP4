package ArquiWeb.Spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ArquiWeb.Spring.demo.entities.Bill;
import ArquiWeb.Spring.demo.entities.Bill_Product;
import ArquiWeb.Spring.demo.entities.Product;

public interface Bill_productRepository extends JpaRepository<Bill_Product, Object> {
/*
	@Modifying
	//@Query("UPDATE BillProduct SET product = :product, bill = :bill, price = :price, quantity = :quantity WHERE id = :id")
	/*public void updateBill_Product(@Param("product") Product product, @Param("bill") Bill bill, 
								  @Param("price") long price, @Param("quantity") int quantity, @Param("id") int id);
	*/
}
