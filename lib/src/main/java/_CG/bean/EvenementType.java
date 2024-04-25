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
 * <p>Classe Java pour evenementType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="evenementType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Prenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Action" type="{giraphix}actionType"/>
 *         <element name="Date" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Commentaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evenementType", propOrder = {
    "nom",
    "prenom",
    "action",
    "date",
    "description",
    "commentaire"
})
public class EvenementType {

    @XmlElement(name = "Nom")
    protected String nom;
    @XmlElement(name = "Prenom")
    protected String prenom;
    @XmlElement(name = "Action", required = true)
    @XmlSchemaType(name = "string")
    protected ActionType action;
    @XmlElement(name = "Date")
    protected long date;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Commentaire")
    protected String commentaire;

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété prenom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit la valeur de la propriété prenom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Obtient la valeur de la propriété action.
     * 
     * @return
     *     possible object is
     *     {@link ActionType }
     *     
     */
    public ActionType getAction() {
        return action;
    }

    /**
     * Définit la valeur de la propriété action.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionType }
     *     
     */
    public void setAction(ActionType value) {
        this.action = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     */
    public long getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     */
    public void setDate(long value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété commentaire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Définit la valeur de la propriété commentaire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaire(String value) {
        this.commentaire = value;
    }

}
