package fr.insa.banqueservice.services;

import fr.insa.banqueservice.exceptions.FonctionnalProcessException;
import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.repositories.CompteRepository;
import fr.insa.banqueservice.resources.payload.CompteCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private ClientService clientService;

    public Compte getCompteById(String id) throws  Exception {
        return this.compteRepository.findById(id).orElseThrow(Exception::new);
    }

    public Compte saveCompte(CompteCreateModel compteToCreate) throws Exception {

        Client client = clientService.getClientById(compteToCreate.getProprio());

        Compte c = Compte.builder()
                .numCompte(compteToCreate.getNumCompte())
                .solde(compteToCreate.getSolde())
                .decouvert(compteToCreate.getDecouvert())
                .plafond(compteToCreate.getPlafond())
                .proprio(client)
                .build();

        return this.compteRepository.save(c);
    }

    public void deleteCompte(String id) {
        this.compteRepository.deleteById(id);
    }

    public Compte getCompteByNumCompte(String numCompte) {
        Compte compte = compteRepository.findCompteByNumCompte(numCompte);

        return compte;
    }

    public void retirerSoldeCompte(String compte, double montant) throws Exception {
        Compte c = this.getCompteById(compte);

        c.setSolde(c.getSolde() - montant);

        this.compteRepository.save(c);
    }

    public void ajouterSoldeCompte(String compte, double montant) throws Exception {
        Compte c = this.getCompteById(compte);

        c.setSolde(c.getSolde() + montant);

        this.compteRepository.save(c);
    }
}
