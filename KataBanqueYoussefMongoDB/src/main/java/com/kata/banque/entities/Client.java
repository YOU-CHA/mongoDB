package com.kata.banque.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
	@Id
	private Long seq;
	private String nomClient;
	private List<Compte> comptes= new ArrayList<Compte>();
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(long code) {
		this.seq = code;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Client() {
		super();
	}
	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	    return String.format(
                "Customer[id=%d, nomClient='%s']",
                seq, nomClient);
	}
}