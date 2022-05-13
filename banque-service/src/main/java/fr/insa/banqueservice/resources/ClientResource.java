package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.exceptions.FonctionnalProcessException;
import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.resources.payload.ClientCreateModel;
import fr.insa.banqueservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientResource {

    @Autowired
    public ClientService clientService;

    @GetMapping("{id}")
    public Client getClient(@PathVariable("id") String id) throws Exception {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody ClientCreateModel clientToCreate) throws FonctionnalProcessException {
        return this.clientService.saveClient(clientToCreate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteClient(@PathVariable("id") String id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
