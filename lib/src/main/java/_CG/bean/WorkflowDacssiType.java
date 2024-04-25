//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package _CG.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour workflowDacssiType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="workflowDacssiType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Transmission" type="{giraphix}transmissionType" minOccurs="0"/>
 *         <element name="Reception" type="{giraphix}receptionType" minOccurs="0"/>
 *         <element name="Decision" type="{giraphix}decisionType" minOccurs="0"/>
 *         <element name="Clos" type="{giraphix}closType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflowDacssiType", propOrder = {
    "transmission",
    "reception",
    "decision",
    "clos"
})
public class WorkflowDacssiType {

    @XmlElement(name = "Transmission")
    protected TransmissionType transmission;
    @XmlElement(name = "Reception")
    protected ReceptionType reception;
    @XmlElement(name = "Decision")
    protected DecisionType decision;
    @XmlElement(name = "Clos")
    protected ClosType clos;

    /**
     * Obtient la valeur de la propriété transmission.
     * 
     * @return
     *     possible object is
     *     {@link TransmissionType }
     *     
     */
    public TransmissionType getTransmission() {
        return transmission;
    }

    /**
     * Définit la valeur de la propriété transmission.
     * 
     * @param value
     *     allowed object is
     *     {@link TransmissionType }
     *     
     */
    public void setTransmission(TransmissionType value) {
        this.transmission = value;
    }

    /**
     * Obtient la valeur de la propriété reception.
     * 
     * @return
     *     possible object is
     *     {@link ReceptionType }
     *     
     */
    public ReceptionType getReception() {
        return reception;
    }

    /**
     * Définit la valeur de la propriété reception.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceptionType }
     *     
     */
    public void setReception(ReceptionType value) {
        this.reception = value;
    }

    /**
     * Obtient la valeur de la propriété decision.
     * 
     * @return
     *     possible object is
     *     {@link DecisionType }
     *     
     */
    public DecisionType getDecision() {
        return decision;
    }

    /**
     * Définit la valeur de la propriété decision.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionType }
     *     
     */
    public void setDecision(DecisionType value) {
        this.decision = value;
    }

    /**
     * Obtient la valeur de la propriété clos.
     * 
     * @return
     *     possible object is
     *     {@link ClosType }
     *     
     */
    public ClosType getClos() {
        return clos;
    }

    /**
     * Définit la valeur de la propriété clos.
     * 
     * @param value
     *     allowed object is
     *     {@link ClosType }
     *     
     */
    public void setClos(ClosType value) {
        this.clos = value;
    }

}
