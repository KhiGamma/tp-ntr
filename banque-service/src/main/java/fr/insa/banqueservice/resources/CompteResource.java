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

    /**
     * récupérer un compte depuis son ID
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("{id}")
    public Compte getCompte(@PathVariable("id") String id) throws Exception {
        return compteService.getCompteById(id);
    }

    /**
     * récupérer les opérations depuis l'ID d'un compte
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("{id}/operations")
    public List<Operation> getOperationCompte(@PathVariable("id") String id) throws Exception {
        return compteService.getCompteById(id).getOperations();
    }

    /**
     * récupérer un compte depuis un numéro de compte
     * @param numCompte
     * @return
     * @throws FonctionnalProcessException
     */
    @GetMapping()
    public Compte getCompteByNumCompte(
            @RequestParam(
                    name = "numCompte",
                    required = true) String numCompte) throws FonctionnalProcessException {
        return compteService.getCompteByNumCompte(numCompte);
    }

    /**
     * créer un compte
     * @param compteToCreate
     * @return
     * @throws Exception
     */
    @PostMapping
    public Compte createCompte(@RequestBody CompteCreateModel compteToCreate) throws Exception {
        return this.compteService.saveCompte(compteToCreate);
    }

    /**
     * supprimer un compte
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity deleteCompte(@PathVariable("id") String id) {
        compteService.deleteCompte(id);
        return ResponseEntity.ok().build();
    }
}
