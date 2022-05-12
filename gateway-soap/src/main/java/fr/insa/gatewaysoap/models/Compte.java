package fr.insa.gatewaysoap.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {
    private String numCompte;
    private double solde;
    private double decouvert;
}
