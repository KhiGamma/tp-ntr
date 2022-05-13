package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.exceptions.FonctionnalProcessException;
import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.resources.payload.ClientCreateModel;
import fr.insa.banqueservice.resources.payload.CompteCreateModel;
import fr.insa.banqueservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comptes")
public class CompteResource {

    @Autowired
    public CompteService compteService;

    @GetMapping("{id}")
    public Compte getCompte(@PathVariable("id") String id) throws Exception {
        return compteService.getCompteById(id);
    }

    @PostMapping
    public Compte createCompte(@RequestBody CompteCreateModel compteToCreate) throws Exception {
        return this.compteService.saveCompte(compteToCreate);
    }
}
