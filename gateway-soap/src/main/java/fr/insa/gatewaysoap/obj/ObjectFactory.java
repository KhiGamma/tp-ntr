
package fr.insa.gatewaysoap.obj;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.insa.gatewaysoap.obj package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.insa.gatewaysoap.obj
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemboursementResponse }
     * 
     */
    public RemboursementResponse createRemboursementResponse() {
        return new RemboursementResponse();
    }

    /**
     * Create an instance of {@link RemboursementRequest }
     * 
     */
    public RemboursementRequest createRemboursementRequest() {
        return new RemboursementRequest();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link DebitResponse }
     * 
     */
    public DebitResponse createDebitResponse() {
        return new DebitResponse();
    }

    /**
     * Create an instance of {@link DebitRequest }
     * 
     */
    public DebitRequest createDebitRequest() {
        return new DebitRequest();
    }

}
