package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.models.Operation;
import fr.insa.banqueservice.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("operations")
public class OperationResource {

    @Autowired
    private OperationService operationService;

    @GetMapping("{id}")
    public Operation getOperation(@PathVariable("id") String id) throws Exception {
        return operationService.getOperationById(id);
    }
}
