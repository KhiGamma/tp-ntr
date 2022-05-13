package fr.insa.banqueservice.services;

import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.models.Operation;
import fr.insa.banqueservice.repositories.OperationRepository;
import fr.insa.banqueservice.resources.payload.OperationCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private CompteService compteService;

    public Operation getOperationById(String id) throws  Exception {
        return this.operationRepository.findById(id).orElseThrow(Exception::new);
    }

    public Operation saveOperation(OperationCreateModel operationToCreate) throws Exception {

        Compte compte = compteService.getCompteById(operationToCreate.getCompte());

        Operation o = Operation.builder()
                .type(operationToCreate.getType())
                .montant(operationToCreate.getMontant())
                .compte(compte)
                .build();

        return this.operationRepository.save(o);
    }

    public void deleteOperation(String id) {
        this.operationRepository.deleteById(id);
    }
}
