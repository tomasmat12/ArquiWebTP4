package ArquiWeb.Spring.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ArquiWeb.Spring.demo.services.ClientService;
import ArquiWeb.Spring.demo.entities.Client;

@RestController
@RequestMapping("/client")
class ClientController {
private static Logger LOG = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("")
	public List<Client> getAll() {
		return this.clientService.getClients();
	}
	
	@PostMapping("")
	public ResponseEntity<Client> addClient(@RequestBody Client c) {
		/*
		boolean ok = this.clientService.insert(c);
		if(!ok) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Client>(c, HttpStatus.OK);
		*/
		System.out.println(c);
		return new ResponseEntity<Client>(c, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable("id") int id) {
		boolean ok = this.clientService.delete(id);
		if(!ok) return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		else return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateClient(@PathVariable( "id" ) int id, @RequestBody Client client) {
		boolean ok = false;
		if(client != null) {
			ok = this.clientService.update(client.getDni(),client.getName(), client.getLastname(), client.getAddress(), id);
		}
		if(!ok) return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		else return new ResponseEntity<>(id, HttpStatus.OK);
	}
}

