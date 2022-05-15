package fr.insa.banqueservice.resources.payload;

import fr.insa.banqueservice.models.Compte;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCreateModel {

    private String nom;

    private String prenom;

    private String email;
}
