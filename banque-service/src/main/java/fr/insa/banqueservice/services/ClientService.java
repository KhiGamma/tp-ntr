package fr.insa.banqueservice.services;

import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(String id) throws Exception {
        return this.clientRepository.findById(id).orElseThrow(Exception::new);
    }
}
