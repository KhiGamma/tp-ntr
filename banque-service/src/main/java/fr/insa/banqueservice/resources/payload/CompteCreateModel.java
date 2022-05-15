package fr.insa.banqueservice.resources.payload;

import fr.insa.banqueservice.models.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompteCreateModel {

    private String numCompte;

    private double solde;

    private double decouvert;

    private double plafond;

    private String proprio;
}
