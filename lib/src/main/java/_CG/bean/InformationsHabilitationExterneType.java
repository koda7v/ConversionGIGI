//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package _CG.bean;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour informationsHabilitationExterneType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="informationsHabilitationExterneType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="NumeroSophia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Niveau" type="{giraphix}niveauType" minOccurs="0"/>
 *         <element name="Nature" type="{giraphix}natureType" minOccurs="0"/>
 *         <element name="DateValidite" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "informationsHabilitationExterneType", propOrder = {
    "numeroSophia",
    "niveau",
    "nature",
    "dateValidite"
})
public class InformationsHabilitationExterneType {

    @XmlElement(name = "NumeroSophia")
    protected String numeroSophia;
    @XmlElement(name = "Niveau")
    @XmlSchemaType(name = "string")
    protected NiveauType niveau;
    @XmlElement(name = "Nature")
    @XmlSchemaType(name = "string")
    protected NatureType nature;
    @XmlElement(name = "DateValidite")
    protected Long dateValidite;

    /**
     * Obtient la valeur de la propriété numeroSophia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSophia() {
        return numeroSophia;
    }

    /**
     * Définit la valeur de la propriété numeroSophia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSophia(String value) {
        this.numeroSophia = value;
    }

    /**
     * Obtient la valeur de la propriété niveau.
     * 
     * @return
     *     possible object is
     *     {@link NiveauType }
     *     
     */
    public NiveauType getNiveau() {
        return niveau;
    }

    /**
     * Définit la valeur de la propriété niveau.
     * 
     * @param value
     *     allowed object is
     *     {@link NiveauType }
     *     
     */
    public void setNiveau(NiveauType value) {
        this.niveau = value;
    }

    /**
     * Obtient la valeur de la propriété nature.
     * 
     * @return
     *     possible object is
     *     {@link NatureType }
     *     
     */
    public NatureType getNature() {
        return nature;
    }

    /**
     * Définit la valeur de la propriété nature.
     * 
     * @param value
     *     allowed object is
     *     {@link NatureType }
     *     
     */
    public void setNature(NatureType value) {
        this.nature = value;
    }

    /**
     * Obtient la valeur de la propriété dateValidite.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateValidite() {
        return dateValidite;
    }

    /**
     * Définit la valeur de la propriété dateValidite.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateValidite(Long value) {
        this.dateValidite = value;
    }

}
