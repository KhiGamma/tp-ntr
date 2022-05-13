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

    @GetMapping("{id}")
    public Operation getOperation(@PathVariable("id") String id) throws Exception {
        return operationService.getOperationById(id);
    }

    @PostMapping
    public Operation createOperation(@RequestBody OperationCreateModel operationToCreate) throws Exception {
        return this.operationService.saveOperation(operationToCreate);
    }

    @PostMapping("/debit")
    public Operation createOperationDebit(@RequestBody OperationCreateModel operationToCreate) throws Exception {
        return this.operationService.saveOperationDebit(operationToCreate);
    }

    @PostMapping("/remboursement")
    public Operation createOperationRemboursement(@RequestBody OperationCreateModel operationToCreate) throws Exception {
        return this.operationService.saveOperationRemboursement(operationToCreate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteOperation(@PathVariable("id") String id) {
        operationService.deleteOperation(id);
        return ResponseEntity.ok().build();
    }
}
