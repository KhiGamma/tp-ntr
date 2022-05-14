package fr.insa.gatewaysoap.repostories;

import fr.insa.gatewaysoap.models.Compte;
import fr.insa.gatewaysoap.obj.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CompteRepository {
    private static final Map<String, Compte> comptes = new HashMap<>();

    /**
     * Methode permettant d'initialiser les données par defaut dans le repository
     */
    @PostConstruct
    public void initData() {
        Compte c1 = Compte.builder()
                .numCompte("123456")
                .decouvert(5)
                .solde(2)
                .plafond(5)
                .build();

        comptes.put(c1.getNumCompte(), c1);

        Compte c2 = Compte.builder()
                .numCompte("654321")
                .decouvert(5)
                .solde(2)
                .plafond(5)
                .build();

        comptes.put(c2.getNumCompte(), c2);

        Compte c3 = Compte.builder()
                .numCompte("135246")
                .decouvert(5)
                .solde(2)
                .plafond(5)
                .build();

        comptes.put(c3.getNumCompte(), c3);
    }

    /**
     * Retrouve un compte dans le repository à partir de son numéro de compte
     * @param numCompte Chaine de caractères correspondant au numéro de compte
     * @return Le compte recherché
     */
    public Compte findCompte(String numCompte) {
        Assert.notNull(numCompte, "Le numero de compte ne doit pas être null");
        return comptes.get(numCompte);
    }

    /**
     * Retir le montant specifié dans l'opération du compte specifié.
     * Verifie egalement si l'opération est possible en amont.
     * @param debitRequest Objet contenant l'opération avec le numéro de compte et le montant
     * @return Un ojet contant la chaine de caractère indiquant l'état de l'opération
     */
    public DebitResponse debiterCompte(DebitRequest debitRequest) {
        Compte compte = this.findCompte(debitRequest.getOperation().getNumCompte());
        DebitResponse response = new DebitResponse();

        if (debitRequest.getOperation().getMontant() < 0) {
            response.setResponse("Le montant doit être supérieur à 0");
            return response;
        }

        if (Math.abs(compte.getSolde() - debitRequest.getOperation().getMontant()) <= compte.getDecouvert()) {
            compte.setSolde(compte.getSolde() - debitRequest.getOperation().getMontant());
            response.setResponse("Operations effectuée !");
        }
        else {
            response.setResponse("Echec montant trop elevé");
        }

        return response;
    }

    /**
     * Rembourse le montant specifié dans l'opération du compte specifié.
     * Verifie egalement si l'opération est possible en amont.
     * @param remboursementRequest Objet contenant l'opération avec le numéro de compte et le montant
     * @return Un ojet contant la chaine de caractère indiquant l'état de l'opération
     */
    public RemboursementResponse rembourserCompte(RemboursementRequest remboursementRequest) {
        Compte compte = this.findCompte(remboursementRequest.getOperation().getNumCompte());
        RemboursementResponse response = new RemboursementResponse();

        if (remboursementRequest.getOperation().getMontant() < 0) {
            response.setResponse("Le montant doit être supérieur à 0");
            return response;
        }

        if (compte.getSolde() + remboursementRequest.getOperation().getMontant() <= compte.getPlafond()) {
            compte.setSolde(compte.getSolde() + remboursementRequest.getOperation().getMontant());
            comptes.put(compte.getNumCompte(), compte);
            response.setResponse("Operations effectuée !");
        }
        else {
            response.setResponse("Echec montant trop elevé");
        }

        return response;
    }
}
