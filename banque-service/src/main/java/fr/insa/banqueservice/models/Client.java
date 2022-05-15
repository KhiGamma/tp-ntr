package fr.insa.banqueservice.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nom;

    private String prenom;

    private String email;

    @OneToOne(mappedBy = "proprio", cascade = CascadeType.REMOVE)
    private Compte compte;
}
