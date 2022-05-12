package fr.insa.banqueservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String type;

    private double montant;

    @ManyToOne
    @JsonIgnore
    private Compte compte;
}
