package com.kata.banque.metier;

import java.util.List;

import com.kata.banque.entities.Client;

/**
 * 
 * @author Youssef CHAHID
 *
 */
public interface IClientMetier {
	public Client saveClient(Client client);
	public List<Client> listClient();
	public Client findClientById(Long id);
	
}
