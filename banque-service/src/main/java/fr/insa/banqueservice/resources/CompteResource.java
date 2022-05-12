package fr.insa.banqueservice.resources;

import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.resources.payload.DebitRequest;
import fr.insa.banqueservice.resources.payload.DebitResponse;
import fr.insa.banqueservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("comptes")
public class CompteResource {

    @Autowired
    public CompteService compteService;

    @PostMapping("/debit")
    public ResponseEntity<DebitResponse> debiterCompte(@RequestBody DebitRequest request) {
        Optional<Compte> compte = compteService.getCompteByNumCompte(request.getOperation().getNumCompte());

        if(compte.isPresent()) {
            DebitResponse response = DebitResponse.builder().response("Debit ok!").build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            DebitResponse response = DebitResponse.builder().response("Debit not ok!").build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO rembourser compte
}
