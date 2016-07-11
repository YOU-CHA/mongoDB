package com.kata.banque.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kata.banque.dao.ClientRepository;
import com.kata.banque.dao.SequenceDao;
import com.kata.banque.entities.Client;
import com.kata.banque.entities.Compte;
import com.kata.banque.entities.Operation;
import com.kata.banque.entities.Retrait;
import com.kata.banque.entities.Versement;
import com.kata.banque.metier.ClientMetierImpl;
/**
 * 
 * @author Youssef CHAHID
 *
 */
@RestController
@RequestMapping("/api/operations")
public class OperationRestService {
	
	@Autowired
	private ClientMetierImpl clientMetier;
	@Autowired
	private SequenceDao sequenceDao;
	
	@RequestMapping(value="{idClient}/comptes/{codeCompte}/versement/{montant}",method=RequestMethod.PUT)
	public Client versement(@PathVariable Long idClient,@PathVariable String codeCompte,@PathVariable double montant) {
		Client client = clientMetier.findClientById(idClient);
		List<Compte> comptes = client.getComptes();
		
		int i = 0;
		boolean found = false;
		Compte compte;
		for (; i < comptes.size() && !found; i++) {
			compte = comptes.get(i);
			if (codeCompte != null && codeCompte.equalsIgnoreCase(compte.getCodeCompte())) {
				compte.setSolde(compte.getSolde() + montant);
				Operation op = new Versement();
				op.setDateOperation(new Date());
				op.setMontant(montant);
				op.setNumeroOperation((long) sequenceDao.getNextSequenceId(ClientRepository.OPERATION_SEQ_KEY));
				compte.getOperations().add(op);
				found = true;
			}
		}
		clientMetier.updateClient(client);
		return client;
	}
	@RequestMapping(value="{idClient}/comptes/{codeCompte}/retrait/{montant}",method=RequestMethod.PUT)
	public Client retrait(@PathVariable Long idClient,@PathVariable String codeCompte,@PathVariable double montant) {
		Client client = clientMetier.findClientById(idClient);
		List<Compte> comptes = client.getComptes();
		
		int i = 0;
		boolean found = false;
		Compte compte;
		for (; i < comptes.size() && !found; i++) {
			compte = comptes.get(i);
			if (codeCompte != null && codeCompte.equalsIgnoreCase(compte.getCodeCompte())) {
				compte.setSolde(compte.getSolde() - montant);
				Operation op = new Retrait();
				op.setDateOperation(new Date());
				op.setMontant(montant);
				op.setNumeroOperation((long) sequenceDao.getNextSequenceId(ClientRepository.OPERATION_SEQ_KEY));
				compte.getOperations().add(op);
				found = true;
			}
		}
		clientMetier.updateClient(client);
		return client;
	}
	
	@RequestMapping(value="{idClient}/comptes/{codeCompte}",method=RequestMethod.GET)
	public Collection<Operation> showOperationCompte(@PathVariable Long idClient,@PathVariable String codeCompte) {
		Client client = clientMetier.findClientById(idClient);
		List<Compte> comptes = client.getComptes();
		int i = 0;
		boolean found = false;
		Compte compte;
		List<Operation> operations = new ArrayList<Operation>();
		for (; i < comptes.size() && !found; i++) {
			compte = comptes.get(i);
			if (codeCompte != null && codeCompte.equalsIgnoreCase(compte.getCodeCompte())) {
				operations = (List<Operation>) compte.getOperations();
				found = true;
			}
		}
		return operations;
	}
	
}
