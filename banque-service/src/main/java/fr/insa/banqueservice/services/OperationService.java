package fr.insa.banqueservice.services;

import fr.insa.banqueservice.exceptions.BadRequestException;
import fr.insa.banqueservice.exceptions.FonctionnalProcessException;
import fr.insa.banqueservice.exceptions.ModelNotValidException;
import fr.insa.banqueservice.models.Compte;
import fr.insa.banqueservice.models.Operation;
import fr.insa.banqueservice.repositories.OperationRepository;
import fr.insa.banqueservice.resources.payload.OperationCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationService {

    private static final String NOT_ENOUGTH_SOLDE = "Montant trop important : %s";

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

    @Transactional(rollbackFor = Exception.class)
    public Operation saveOperationDebit(OperationCreateModel operationToCreate) throws Exception {

        validateTransactionModel(operationToCreate);

        Compte compte = compteService.getCompteById(operationToCreate.getCompte());

        if(compte.getSolde() < operationToCreate.getMontant() - compte.getDecouvert()) {
            throw new BadRequestException(String.format(NOT_ENOUGTH_SOLDE, operationToCreate.getMontant()));
        }

        Operation o = Operation.builder()
                .type(operationToCreate.getType())
                .montant(operationToCreate.getMontant())
                .compte(compte)
                .build();

        this.compteService.retirerSoldeCompte(operationToCreate.getCompte(), operationToCreate.getMontant());

        return this.operationRepository.save(o);
    }

    @Transactional(rollbackFor = Exception.class)
    public Operation saveOperationRemboursement(OperationCreateModel operationToCreate) throws Exception {

        validateTransactionModel(operationToCreate);

        Compte compte = compteService.getCompteById(operationToCreate.getCompte());

        if(compte.getPlafond() < operationToCreate.getMontant() + compte.getSolde()) {
            throw new BadRequestException(String.format(NOT_ENOUGTH_SOLDE, operationToCreate.getMontant()));
        }

        Operation o = Operation.builder()
                .type(operationToCreate.getType())
                .montant(operationToCreate.getMontant())
                .compte(compte)
                .build();

        this.compteService.ajouterSoldeCompte(operationToCreate.getCompte(), operationToCreate.getMontant());

        return this.operationRepository.save(o);
    }

    private void validateTransactionModel(OperationCreateModel operationToCreate) throws ModelNotValidException {

        ModelNotValidException ex = new ModelNotValidException();

        if(operationToCreate == null) {
            ex.getMessages().add("operationCreate : null");
        }

        if(operationToCreate.getType() == null) {
            ex.getMessages().add("aucun type de transaction");
        }
        if(operationToCreate.getMontant() <= 0) {
            ex.getMessages().add("montant incorrect");
        }
        if(operationToCreate.getCompte() == null) {
            ex.getMessages().add("aucun id de compte");
        }

        if(!ex.getMessages().isEmpty()) {
            throw ex;
        }
    }
}
