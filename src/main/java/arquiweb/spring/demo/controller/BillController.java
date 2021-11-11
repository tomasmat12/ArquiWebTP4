package arquiweb.spring.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arquiweb.spring.demo.dtos.BillReportDTO;
import arquiweb.spring.demo.entities.Bill;
import arquiweb.spring.demo.entities.Bill_Product;
import arquiweb.spring.demo.entities.Client;
import arquiweb.spring.demo.entities.Product;
import arquiweb.spring.demo.services.BillService;
import arquiweb.spring.demo.services.Bill_ProductService;

/*
*  Dado un pedido REST, el controlador de Bill atiende el pedido y llama al servicio requerido.
*  Objetivo principal mapear las URL para acceder al recurso necesario.
*/


@RestController
@RequestMapping("/bill")
public class BillController {
	private static Logger LOG = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private BillService billService;
	@Autowired
	private Bill_ProductService billProductService;
	
	
	@GetMapping("")
	public List<Bill> getAll() {
		return this.billService.getBills();
	}
	
	@GetMapping("/report")
	public List<BillReportDTO> report(){
		return this.billService.report();
	}
	
	@PostMapping("")
	public ResponseEntity<Bill> addBillAndProducts(@RequestBody Bill bill) {
		
		
		System.out.println(bill);
		//System.out.println("lista productos " + listProd);
		// forEach(p -> this.billProductService.insert(p));
		//this.billService.insert(bill);
		//this.billProductService.
		boolean ok = this.billService.insert(bill);
		if(!ok) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
		
	}
	
}
