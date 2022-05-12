package fr.insa.banqueservice.resources.payload;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private String numCompte;
    private double montant;
}
