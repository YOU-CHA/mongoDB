package com.kata.banque.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kata.banque.entities.Client;
import com.kata.banque.entities.Compte;
import com.kata.banque.metier.ClientMetierImpl;
import com.kata.banque.metier.CompteMetierImpl;
/**
 * 
 * @author Youssef CHAHID
 *
 */
@RestController
@RequestMapping("/api/comptes")
public class CompteRestService {
	@Autowired
	private CompteMetierImpl compteMetier;
	@Autowired
	private ClientMetierImpl clientMetier;

	@RequestMapping(method=RequestMethod.GET)
	public List<Compte> listComptes() {
		return compteMetier.listComptes();
	}
	
	@RequestMapping(value="{idClient}",method=RequestMethod.POST)
	public Client saveCompte(@RequestBody Compte cp,@PathVariable Long idClient) {
		Client client = clientMetier.findClientById(idClient);
		cp.setDateCreation(new Date());
		client.getComptes().add(cp);
		clientMetier.updateClient(client);
		return client;
	}

	@RequestMapping(value="{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
}
