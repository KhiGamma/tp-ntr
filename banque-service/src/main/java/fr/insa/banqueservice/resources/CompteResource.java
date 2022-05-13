package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comptes")
public class CompteResource {

    @Autowired
    public CompteService compteService;

    @GetMapping("{id}")
    public Compte getCompte(@PathVariable("id") String id) throws Exception {
        return compteService.getCompteById(id);
    }
}
