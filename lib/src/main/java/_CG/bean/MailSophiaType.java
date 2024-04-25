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
 * <p>Classe Java pour mailSophiaType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="mailSophiaType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Sujet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Corps" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailSophiaType", propOrder = {
    "sujet",
    "corps"
})
public class MailSophiaType {

    @XmlElement(name = "Sujet", required = true)
    protected String sujet;
    @XmlElement(name = "Corps", required = true)
    protected String corps;

    /**
     * Obtient la valeur de la propriété sujet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSujet() {
        return sujet;
    }

    /**
     * Définit la valeur de la propriété sujet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSujet(String value) {
        this.sujet = value;
    }

    /**
     * Obtient la valeur de la propriété corps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorps() {
        return corps;
    }

    /**
     * Définit la valeur de la propriété corps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorps(String value) {
        this.corps = value;
    }

}
