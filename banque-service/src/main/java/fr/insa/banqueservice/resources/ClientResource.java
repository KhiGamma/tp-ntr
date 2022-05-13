package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comptes")
public class ClientResource {

    @Autowired
    public ClientService clientService;

    @GetMapping("{id}")
    public Client getClient(@PathVariable("id") String id) throws Exception {
        return clientService.getClientById(id);
    }
}
