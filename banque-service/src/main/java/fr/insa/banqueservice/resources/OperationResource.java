package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.models.Operation;
import fr.insa.banqueservice.resources.payload.CompteCreateModel;
import fr.insa.banqueservice.resources.payload.OperationCreateModel;
import fr.insa.banqueservice.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("operations")
public class OperationResource {

    @Autowired
    private OperationService operationService;

    /**
     * récupérer une opération depuis son ID
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("{id}")
    public Operation getOperation(@PathVariable("id") String id) throws Exception {
        return operationService.getOperationById(id);
    }

    /**
     * créer une opération (sans vérifications)
     * @param operationToCreate
     * @return
     * @throws Exception
     */
    @PostMapping
    public Operation createOperation(@RequestBody OperationCreateModel operationToCreate) throws Exception {
        return this.operationService.saveOperation(operationToCreate);
    }

    /**
     * créer une opération de débit d'un compte
     * @param operationToCreate
     * @return
     * @throws Exception
     */
    @PostMapping("/debit")
    public Operation createOperationDebit(@RequestBody OperationCreateModel operationToCreate) throws Exception {
        return this.operationService.saveOperationDebit(operationToCreate);
    }

    /**
     * créer une opération de remboursement d'un compte
     * @param operationToCreate
     * @return
     * @throws Exception
     */
    @PostMapping("/remboursement")
    public Operation createOperationRemboursement(@RequestBody OperationCreateModel operationToCreate) throws Exception {
        return this.operationService.saveOperationRemboursement(operationToCreate);
    }

    /**
     * supprimer une opération
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity deleteOperation(@PathVariable("id") String id) {
        operationService.deleteOperation(id);
        return ResponseEntity.ok().build();
    }
}
