package fr.insa.banqueservice.repositories;

import fr.insa.banqueservice.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRespository extends JpaRepository<Compte, String> {
    Optional<Compte> findCompteByNumCompte(String numCompte);
}
