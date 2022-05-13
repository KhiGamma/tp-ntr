package fr.insa.banqueservice.resources.payload;

import fr.insa.banqueservice.models.Compte;

public class OperationCreateModel {

    private String id;

    private String type;

    private double montant;

    private Compte compte;
}
