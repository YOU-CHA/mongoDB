package com.kata.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.banque.dao.CompteRepository;
import com.kata.banque.entities.Compte;
/**
 * 
 * @author Youssef CHAHID
 *
 */
@Service
public class CompteMetierImpl implements ICompteMetier {
	@Autowired
	private CompteRepository compteRepository;
	
	public Compte saveCompte(Compte cp) {
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	public Compte getCompte(String code) {
		return compteRepository.findOne(code);
	}
	
	public List<Compte> listComptes() {
		return compteRepository.findAll();
	}

}
