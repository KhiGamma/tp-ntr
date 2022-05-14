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

    /**
     * selectionner le client depuis l'ID
     * @param id
     * @return
     * @throws Exception
     */
    public Client getClientById(String id) throws Exception {
        return this.clientRepository.findById(id).orElseThrow(Exception::new);
    }

    /**
     * build permettant la création dun nouveau client
     * @param clientToCreate
     * @return
     * @throws FonctionnalProcessException
     */
    public Client saveClient(ClientCreateModel clientToCreate) throws FonctionnalProcessException {

        Client c = Client.builder()
                .nom(clientToCreate.getNom())
                .prenom(clientToCreate.getPrenom())
                .email(clientToCreate.getEmail())
                .build();

        return this.clientRepository.save(c);
    }

    /**
     * supprimer un client depuis l'ID
     * @param id
     */
    public void deleteClient(String id) {
        this.clientRepository.deleteById(id);
    }
}
