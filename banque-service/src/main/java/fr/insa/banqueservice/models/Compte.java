package fr.insa.banqueservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonIgnore
    private Client proprio;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Operation> operations;
}
