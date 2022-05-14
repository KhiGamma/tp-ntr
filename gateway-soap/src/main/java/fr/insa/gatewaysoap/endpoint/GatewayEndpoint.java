package fr.insa.gatewaysoap.endpoint;

import fr.insa.gatewaysoap.obj.DebitRequest;
import fr.insa.gatewaysoap.obj.DebitResponse;
import fr.insa.gatewaysoap.obj.RemboursementRequest;
import fr.insa.gatewaysoap.obj.RemboursementResponse;
import fr.insa.gatewaysoap.repostories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GatewayEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CompteRepository compteRepository;
    //private final RestTemplate restTemplate;

    @Autowired
    public GatewayEndpoint(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
        //this.restTemplate = new RestTemplate();
    }

    /*@PayloadRoot(namespace = NAMESPACE_URI, localPart = "debitRequest")
    @ResponsePayload
    public DebitResponse debiterCompte(@RequestPayload DebitRequest request) {
        return restTemplate.postForObject("http://localhost:8070/comptes/debit", request, DebitResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "remboursementRequest")
    @ResponsePayload
    public RemboursementResponse rembourserCompte(@RequestPayload RemboursementRequest request) {
        return restTemplate.postForObject("http://localhost:8070/comptes/remboursement", request, RemboursementResponse.class);
    }*/

    /**
     *  Methode permettant de debiter un compte
     * @param request Objet contentnant l'opération à effectuer
     * @return Un objet contenant la chaine de caractère indiquant si l'opération s'est bien déroulée
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "debitRequest")
    @ResponsePayload
    public DebitResponse debiterCompte(@RequestPayload DebitRequest request) {
        DebitResponse response = new DebitResponse();


        return response;
    }

    /**
     *  Methode permettant de rembourser un compte
     * @param request Objet contentnant l'opération à effectuer
     * @return Un objet contenant la chaine de caractère indiquant si l'opération s'est bien déroulée
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "remboursementRequest")
    @ResponsePayload
    public RemboursementResponse rembourserCompte(@RequestPayload RemboursementRequest request) {
        RemboursementResponse response = new RemboursementResponse();

        return response;
    }
}
