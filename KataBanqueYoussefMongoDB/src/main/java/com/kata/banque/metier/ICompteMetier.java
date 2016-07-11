package com.kata.banque.metier;

import com.kata.banque.entities.Compte;

/**
 * 
 * @author Youssef CHAHID
 *
 */
public interface ICompteMetier {
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String code);
}
