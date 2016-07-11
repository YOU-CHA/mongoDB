package com.kata.banque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kata.banque.entities.Client;
import com.kata.banque.metier.ClientMetierImpl;
/**
 * 
 * @author Youssef CHAHID
 *
 */
@RestController
@RequestMapping("/api/clients")
public class ClientRestService {
	@Autowired
	private ClientMetierImpl clientMetier;

	@RequestMapping(method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
	@RequestMapping(method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}
	
}
