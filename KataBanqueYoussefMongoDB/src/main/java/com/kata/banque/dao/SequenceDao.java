package com.kata.banque.dao;


public interface SequenceDao {

	int getNextSequenceId(String key);

}