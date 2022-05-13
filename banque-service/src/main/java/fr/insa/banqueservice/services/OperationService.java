package fr.insa.banqueservice.services;

import fr.insa.banqueservice.models.Operation;
import fr.insa.banqueservice.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public Operation getOperationById(String id) throws  Exception {
        return this.operationRepository.findById(id).orElseThrow(Exception::new);
    }
}
