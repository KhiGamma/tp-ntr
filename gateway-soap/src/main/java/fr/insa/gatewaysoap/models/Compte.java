package fr.insa.gatewaysoap.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Compte {
    private String numCompte;
    private double solde;
    private double plafond;
    private double decouvert;
}
