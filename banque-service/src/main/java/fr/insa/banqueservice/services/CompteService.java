package fr.insa.banqueservice.services;

import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.repositories.CompteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    public CompteRespository compteRespository;

    public Compte getCompteById(String id) {
        return this.compteRespository.getById(id);
    }

    public Optional<Compte> getCompteByNumCompte(String numCompte) {
        return this.compteRespository.findCompteByNumCompte(numCompte);
    }
}
