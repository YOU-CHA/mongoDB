package com.kata.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.banque.dao.CompteRepository;
import com.kata.banque.dao.OperationRepository;
import com.kata.banque.entities.Compte;
import com.kata.banque.entities.Operation;
import com.kata.banque.entities.Retrait;
import com.kata.banque.entities.Versement;

@Service
public class OperationMetierImpl implements IOperationMetier {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	public boolean versement(String codeCompte, double montant) {
		Compte cp  = compteRepository.findOne(codeCompte);
		Operation op = new Versement();
		op.setDateOperation(new Date());
		op.setMontant(montant);
		
		operationRepository.save(op);
		
		
		cp.setSolde(cp.getSolde()+montant);
		
		compteRepository.save(cp);
		
		return true;
	}
	public boolean retrait(String codeCompte, double montant) {
		Compte cp  = compteRepository.findOne(codeCompte);
		
		if (cp.getSolde()<montant) throw new RuntimeException("Solde insufisant");
		
		Operation op = new Retrait();
		op.setDateOperation(new Date());
		op.setMontant(montant);
		
		operationRepository.save(op);
		
		cp.setSolde(cp.getSolde()-montant);
		
		return true;
	}
	
	public List<Operation> getOperationByCodeCompte(String codeCompte) {
//		return operationRepository.fi
		return null;
	}
	
	public List<Operation> listOperations() {
		return operationRepository.findAll();
	}
	
	
	

	

}
