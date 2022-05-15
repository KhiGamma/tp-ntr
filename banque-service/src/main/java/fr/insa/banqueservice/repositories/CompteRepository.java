package fr.insa.banqueservice.repositories;

import fr.insa.banqueservice.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

    public Compte findCompteByNumCompte(String numCompte);
}
