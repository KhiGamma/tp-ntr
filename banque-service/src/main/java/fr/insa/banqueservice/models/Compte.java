package fr.insa.banqueservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String numCompte;

    private double solde;

    private double decouvert;

    private double plafond;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client proprio;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.REMOVE)
    private List<Operation> operation;
}
