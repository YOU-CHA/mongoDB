package com.kata.banque.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kata.banque.entities.Operation;

public interface OperationRepository extends MongoRepository<Operation, String> {

}
