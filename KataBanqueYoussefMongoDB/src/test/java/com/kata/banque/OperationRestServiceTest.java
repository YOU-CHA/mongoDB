package com.kata.banque;

import java.util.Date;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.kata.banque.dao.SequenceDao;
import com.kata.banque.entities.Client;
import com.kata.banque.entities.Compte;
import com.kata.banque.entities.CompteCourant;
import com.kata.banque.metier.ClientMetierImpl;
import com.kata.banque.services.OperationRestService;

@RunWith(MockitoJUnitRunner.class)
public class OperationRestServiceTest {

	@InjectMocks
	private OperationRestService operationRestService;
	
	@Mock
	private ClientMetierImpl clientMetier;
	@Mock
	private SequenceDao sequenceDao;
	
	private Client client;
	
	@Before
	public void init(){
		client = new Client();
		Compte compte = new CompteCourant("CC1", new Date(), 1000, 0);
		client.getComptes().add(compte);
		
	}
	@Test
	public void versementSuccessTest() {
		
		Long idClient = 1l;
		String codeCompte = "CC1";
		double montant = 2000;
		Mockito.when(clientMetier.findClientById(idClient)).thenReturn(client);
		Mockito.when(sequenceDao.getNextSequenceId(Mockito.anyString())).thenReturn(0);
		Client client = operationRestService.versement(idClient, codeCompte, montant);
		Assertions.assertThat(client.getComptes().get(0).getSolde()).isEqualTo(3000);
	}
	@Test
	public void retraitSuccessTest() {
		
		Long idClient = 1l;
		String codeCompte = "CC1";
		double montant = 500;
		Mockito.when(clientMetier.findClientById(idClient)).thenReturn(client);
		Mockito.when(sequenceDao.getNextSequenceId(Mockito.anyString())).thenReturn(0);
		Client client = operationRestService.retrait(idClient, codeCompte, montant);
		Assertions.assertThat(client.getComptes().get(0).getSolde()).isEqualTo(500);
	}
}
