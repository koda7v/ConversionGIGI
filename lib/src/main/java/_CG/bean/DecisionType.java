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
 * <p>Classe Java pour decisionType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="decisionType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Date" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="Mail" type="{giraphix}mailSophiaType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "decisionType", propOrder = {
    "date",
    "mail"
})
public class DecisionType {

    @XmlElement(name = "Date")
    protected Long date;
    @XmlElement(name = "Mail")
    protected MailSophiaType mail;

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDate(Long value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété mail.
     * 
     * @return
     *     possible object is
     *     {@link MailSophiaType }
     *     
     */
    public MailSophiaType getMail() {
        return mail;
    }

    /**
     * Définit la valeur de la propriété mail.
     * 
     * @param value
     *     allowed object is
     *     {@link MailSophiaType }
     *     
     */
    public void setMail(MailSophiaType value) {
        this.mail = value;
    }

}
