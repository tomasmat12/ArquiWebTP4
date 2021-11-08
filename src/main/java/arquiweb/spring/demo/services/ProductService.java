package arquiweb.spring.demo.services;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arquiweb.spring.demo.dtos.ProductReportDTO;
import arquiweb.spring.demo.entities.Product;
import arquiweb.spring.demo.repositories.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository products;
	
	public List<Product> getProducts() {
		return this.products.findAll();
	}
	
	@Transactional
	public boolean insert(Product p) {
		this.products.save(p);
		return true;
	}
	@Transactional
	public boolean update(String name, int stock, long price, int id) {
		this.products.updateProduct(name, stock, price, id);
		return true;
	}
	@Transactional
	public boolean delete(int id) {
		this.products.deleteById(id);
		return true;
	}
	
	public List<ProductReportDTO> getReport(){
		return this.products.productSalesReport();
	}

}
