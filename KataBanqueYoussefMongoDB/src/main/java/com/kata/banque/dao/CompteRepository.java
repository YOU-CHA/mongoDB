package com.kata.banque.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kata.banque.entities.Compte;

public interface CompteRepository extends MongoRepository<Compte, String> {

}
