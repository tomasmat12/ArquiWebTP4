package arquiweb.spring.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import arquiweb.spring.demo.entities.Bill_Product;
import arquiweb.spring.demo.services.Bill_ProductService;


class Bill_ProductController {
	private static Logger LOG = LoggerFactory.getLogger(Bill_ProductController.class);
	
	@Autowired
	private Bill_ProductService billProductService;
	
	@GetMapping("")
	public List<Bill_Product> getAll() {
		return this.billProductService.getClients();
	}
	
}
