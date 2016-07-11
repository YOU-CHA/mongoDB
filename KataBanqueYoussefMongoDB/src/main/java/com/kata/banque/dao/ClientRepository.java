package com.kata.banque.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kata.banque.entities.Client;
@Repository
public interface ClientRepository extends MongoRepository<Client, Long> {
	static final String CLIENT_SEQ_KEY = "CLIENT";
	static final String OPERATION_SEQ_KEY = "OPERATION";

}
