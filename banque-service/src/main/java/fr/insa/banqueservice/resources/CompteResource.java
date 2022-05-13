package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.exceptions.FonctionnalProcessException;
import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.models.Operation;
import fr.insa.banqueservice.resources.payload.ClientCreateModel;
import fr.insa.banqueservice.resources.payload.CompteCreateModel;
import fr.insa.banqueservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comptes")
public class CompteResource {

    @Autowired
    public CompteService compteService;

    @GetMapping("{id}")
    public Compte getCompte(@PathVariable("id") String id) throws Exception {
        return compteService.getCompteById(id);
    }

    @GetMapping("{id}/operations")
    public List<Operation> getOperationCompte(@PathVariable("id") String id) throws Exception {
        return compteService.getCompteById(id).getOperations();
    }

    @GetMapping()
    public Compte getCompteByNumCompte(
            @RequestParam(
                    name = "numCompte",
                    required = true) String numCompte) throws FonctionnalProcessException {
        return compteService.getCompteByNumCompte(numCompte);
    }

    @PostMapping
    public Compte createCompte(@RequestBody CompteCreateModel compteToCreate) throws Exception {
        return this.compteService.saveCompte(compteToCreate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCompte(@PathVariable("id") String id) {
        compteService.deleteCompte(id);
        return ResponseEntity.ok().build();
    }
}
