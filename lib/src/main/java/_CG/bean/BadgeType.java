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
 * <p>Classe Java pour badgeType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="badgeType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Actif" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="Historique" type="{giraphix}historiqueBadgeType" minOccurs="0"/>
 *         <element name="IdPersonne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "badgeType", propOrder = {
    "numero",
    "actif",
    "historique",
    "idPersonne"
})
public class BadgeType {

    @XmlElement(name = "Numero", required = true)
    protected String numero;
    @XmlElement(name = "Actif")
    protected boolean actif;
    @XmlElement(name = "Historique")
    protected HistoriqueBadgeType historique;
    @XmlElement(name = "IdPersonne")
    protected String idPersonne;

    /**
     * Obtient la valeur de la propriété numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Définit la valeur de la propriété numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtient la valeur de la propriété actif.
     * 
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * Définit la valeur de la propriété actif.
     * 
     */
    public void setActif(boolean value) {
        this.actif = value;
    }

    /**
     * Obtient la valeur de la propriété historique.
     * 
     * @return
     *     possible object is
     *     {@link HistoriqueBadgeType }
     *     
     */
    public HistoriqueBadgeType getHistorique() {
        return historique;
    }

    /**
     * Définit la valeur de la propriété historique.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoriqueBadgeType }
     *     
     */
    public void setHistorique(HistoriqueBadgeType value) {
        this.historique = value;
    }

    /**
     * Obtient la valeur de la propriété idPersonne.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPersonne() {
        return idPersonne;
    }

    /**
     * Définit la valeur de la propriété idPersonne.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPersonne(String value) {
        this.idPersonne = value;
    }

}
