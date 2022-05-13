package fr.insa.banqueservice.resources.payload;

import fr.insa.banqueservice.models.Client;
import fr.insa.banqueservice.models.Operation;

import java.util.List;

public class CompteCreateModel {

    private String id;

    private String numCompte;

    private double solde;

    private double decouvert;

    private double plafond;

    private Client proprio;

    private List<Operation> operations;
}
