
package fr.insa.gatewaysoap.obj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour operation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="operation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numCompte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operation", namespace = "http://spring.io/guides/gs-producing-web-service", propOrder = {
    "numCompte",
    "montant"
})
public class Operation {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String numCompte;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected double montant;

    /**
     * Obtient la valeur de la propriété numCompte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCompte() {
        return numCompte;
    }

    /**
     * Définit la valeur de la propriété numCompte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCompte(String value) {
        this.numCompte = value;
    }

    /**
     * Obtient la valeur de la propriété montant.
     * 
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Définit la valeur de la propriété montant.
     * 
     */
    public void setMontant(double value) {
        this.montant = value;
    }

}
