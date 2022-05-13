package fr.insa.banqueservice.services;

import fr.insa.banqueservice.exceptions.FonctionnalProcessException;
import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.repositories.ClientRepository;
import fr.insa.banqueservice.resources.payload.ClientCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(String id) throws Exception {
        return this.clientRepository.findById(id).orElseThrow(Exception::new);
    }

    public Client saveClient(ClientCreateModel clientToCreate) throws FonctionnalProcessException {

        Client c = Client.builder()
                .nom(clientToCreate.getNom())
                .prenom(clientToCreate.getPrenom())
                .email(clientToCreate.getEmail())
                .build();

        return this.clientRepository.save(c);
    }

    public void deleteClient(String id) {
        this.clientRepository.deleteById(id);
    }
}
