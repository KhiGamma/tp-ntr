package fr.insa.gatewaysoap.repostories;

import fr.insa.gatewaysoap.models.Compte;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CompteRepository {
    private static final Map<String, Compte> comptes = new HashMap<>();

    @PostConstruct
    public void initData() {
        Compte c1 = Compte.builder()
                .numCompte("123456")
                .decouvert(5)
                .solde(2)
                .build();

        comptes.put(c1.getNumCompte(), c1);

        Compte c2 = Compte.builder()
                .numCompte("654321")
                .decouvert(5)
                .solde(2)
                .build();

        comptes.put(c2.getNumCompte(), c2);

        Compte c3 = Compte.builder()
                .numCompte("135246")
                .decouvert(5)
                .solde(2)
                .build();

        comptes.put(c3.getNumCompte(), c3);
    }

    public Compte findCompte(String numCompte) {
        Assert.notNull(numCompte, "Numero de compte ne doit pas être null");
        return comptes.get(numCompte);
    }
}
