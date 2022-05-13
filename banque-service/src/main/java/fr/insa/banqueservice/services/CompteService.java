package fr.insa.banqueservice.services;

import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public Compte getCompteById(String id) throws  Exception {
        return this.compteRepository.findById(id).orElseThrow(Exception::new);
    }
}
