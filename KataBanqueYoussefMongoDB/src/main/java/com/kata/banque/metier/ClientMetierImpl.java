package com.kata.banque.metier;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.banque.dao.ClientRepository;
import com.kata.banque.dao.SequenceDao;
import com.kata.banque.entities.Client;
/**
 * 
 * @author Youssef CHAHID
 *
 */
@Service
public class ClientMetierImpl implements IClientMetier {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private SequenceDao sequenceDao;
	
	public Client saveClient(Client client) {
		client.setSeq(sequenceDao.getNextSequenceId(ClientRepository.CLIENT_SEQ_KEY));
		return clientRepository.save(client);
	}

	public List<Client> listClient() {
		return clientRepository.findAll();
	}

	public Client findClientById(Long id) {
		return clientRepository.findOne(id);
	}

	public void updateClient(Client client) {
		clientRepository.save(client);
		
	}

}
