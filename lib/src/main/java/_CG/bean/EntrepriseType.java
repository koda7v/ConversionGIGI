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
 * <p>Classe Java pour entrepriseType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="entrepriseType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Localite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Adresse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="CodePostal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="CodeSE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entrepriseType", propOrder = {
    "nom",
    "localite",
    "adresse",
    "codePostal",
    "codeSE"
})
public class EntrepriseType {

    @XmlElement(name = "Nom", required = true)
    protected String nom;
    @XmlElement(name = "Localite", required = true)
    protected String localite;
    @XmlElement(name = "Adresse", required = true)
    protected String adresse;
    @XmlElement(name = "CodePostal", required = true)
    protected String codePostal;
    @XmlElement(name = "CodeSE", required = true)
    protected String codeSE;

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
     * Obtient la valeur de la propriété localite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalite() {
        return localite;
    }

    /**
     * Définit la valeur de la propriété localite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalite(String value) {
        this.localite = value;
    }

    /**
     * Obtient la valeur de la propriété adresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Définit la valeur de la propriété adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Obtient la valeur de la propriété codePostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Définit la valeur de la propriété codePostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

    /**
     * Obtient la valeur de la propriété codeSE.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSE() {
        return codeSE;
    }

    /**
     * Définit la valeur de la propriété codeSE.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSE(String value) {
        this.codeSE = value;
    }

}
