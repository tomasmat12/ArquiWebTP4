package services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Client;
import Repositories.ClientRepository;


@Service
public
class ClientService {
	@Autowired
	private ClientRepository clients;
	
	public List<Client> getClients() {
		return this.clients.findAll();
	}
	
	@Transactional
	public boolean insert(Client c) {
		this.clients.save(c);
		return true;
	}
	@Transactional
	public boolean delete(int dni) {
		this.clients.deleteById(dni);
		return true;
	}
	@Transactional
	public boolean update(int new_dni, String name, String lastname,String address, int dni) {
		this.clients.updateClient(new_dni, name, lastname,address, dni);
		return true;
	}
}
