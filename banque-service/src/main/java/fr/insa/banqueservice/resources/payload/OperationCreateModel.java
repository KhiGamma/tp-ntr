package fr.insa.banqueservice.resources.payload;

import fr.insa.banqueservice.models.Compte;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationCreateModel {

    private String id;

    private String type;

    private double montant;

    private Compte compte;
}
