package arquiweb.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import arquiweb.spring.demo.dtos.ProductReportDTO;
import arquiweb.spring.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Object> {

	@Modifying
	@Query("UPDATE Product SET name = :name, stock = :stock, price =:price WHERE id = :id")
	public void updateProduct(@Param("name") String name, @Param("stock") int stock,@Param("price") long price, @Param("id") int id);

	@Query(name = "product_report_dto", nativeQuery = true)
	public List<ProductReportDTO> productSalesReport();
}
