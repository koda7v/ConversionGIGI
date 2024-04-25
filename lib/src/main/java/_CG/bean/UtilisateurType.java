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
 * <p>Classe Java pour utilisateurType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="utilisateurType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Civilite" type="{giraphix}civiliteType"/>
 *         <element name="Nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Titre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="MotDePasse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Admin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "utilisateurType", propOrder = {
    "civilite",
    "nom",
    "prenom",
    "titre",
    "motDePasse",
    "signature",
    "admin"
})
public class UtilisateurType {

    @XmlElement(name = "Civilite", required = true)
    @XmlSchemaType(name = "string")
    protected CiviliteType civilite;
    @XmlElement(name = "Nom", required = true)
    protected String nom;
    @XmlElement(name = "Prenom", required = true)
    protected String prenom;
    @XmlElement(name = "Titre", required = true)
    protected String titre;
    @XmlElement(name = "MotDePasse")
    protected String motDePasse;
    @XmlElement(name = "Signature")
    protected String signature;
    @XmlElement(name = "Admin")
    protected boolean admin;

    /**
     * Obtient la valeur de la propriété civilite.
     * 
     * @return
     *     possible object is
     *     {@link CiviliteType }
     *     
     */
    public CiviliteType getCivilite() {
        return civilite;
    }

    /**
     * Définit la valeur de la propriété civilite.
     * 
     * @param value
     *     allowed object is
     *     {@link CiviliteType }
     *     
     */
    public void setCivilite(CiviliteType value) {
        this.civilite = value;
    }

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
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    /**
     * Obtient la valeur de la propriété motDePasse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Définit la valeur de la propriété motDePasse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotDePasse(String value) {
        this.motDePasse = value;
    }

    /**
     * Obtient la valeur de la propriété signature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Définit la valeur de la propriété signature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Obtient la valeur de la propriété admin.
     * 
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Définit la valeur de la propriété admin.
     * 
     */
    public void setAdmin(boolean value) {
        this.admin = value;
    }

}
