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
 * <p>Classe Java pour personneType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="personneType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Civilite" type="{giraphix}civiliteType"/>
 *         <element name="Nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Actif" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="Interne" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="DateDeNaissance" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="VilleDeNaissance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Nationalites" type="{giraphix}nationalitesType" minOccurs="0"/>
 *         <element name="Fonction" type="{giraphix}fonctionType" minOccurs="0"/>
 *         <element name="DocumentIdentite" type="{giraphix}documentIdentiteType" minOccurs="0"/>
 *         <element name="InformationsHabilitationExterne" type="{giraphix}informationsHabilitationExterneType" minOccurs="0"/>
 *         <element name="IdEntreprise" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personneType", propOrder = {
    "id",
    "civilite",
    "nom",
    "prenom",
    "actif",
    "interne",
    "dateDeNaissance",
    "villeDeNaissance",
    "nationalites",
    "fonction",
    "documentIdentite",
    "informationsHabilitationExterne",
    "idEntreprise"
})
public class PersonneType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Civilite", required = true)
    @XmlSchemaType(name = "string")
    protected CiviliteType civilite;
    @XmlElement(name = "Nom", required = true)
    protected String nom;
    @XmlElement(name = "Prenom", required = true)
    protected String prenom;
    @XmlElement(name = "Actif")
    protected boolean actif;
    @XmlElement(name = "Interne")
    protected boolean interne;
    @XmlElement(name = "DateDeNaissance")
    protected Long dateDeNaissance;
    @XmlElement(name = "VilleDeNaissance")
    protected String villeDeNaissance;
    @XmlElement(name = "Nationalites")
    protected NationalitesType nationalites;
    @XmlElement(name = "Fonction")
    @XmlSchemaType(name = "string")
    protected FonctionType fonction;
    @XmlElement(name = "DocumentIdentite")
    protected DocumentIdentiteType documentIdentite;
    @XmlElement(name = "InformationsHabilitationExterne")
    protected InformationsHabilitationExterneType informationsHabilitationExterne;
    @XmlElement(name = "IdEntreprise", required = true)
    protected String idEntreprise;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

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
     * Obtient la valeur de la propriété interne.
     * 
     */
    public boolean isInterne() {
        return interne;
    }

    /**
     * Définit la valeur de la propriété interne.
     * 
     */
    public void setInterne(boolean value) {
        this.interne = value;
    }

    /**
     * Obtient la valeur de la propriété dateDeNaissance.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateDeNaissance() {
        return dateDeNaissance;
    }

    /**
     * Définit la valeur de la propriété dateDeNaissance.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateDeNaissance(Long value) {
        this.dateDeNaissance = value;
    }

    /**
     * Obtient la valeur de la propriété villeDeNaissance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVilleDeNaissance() {
        return villeDeNaissance;
    }

    /**
     * Définit la valeur de la propriété villeDeNaissance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVilleDeNaissance(String value) {
        this.villeDeNaissance = value;
    }

    /**
     * Obtient la valeur de la propriété nationalites.
     * 
     * @return
     *     possible object is
     *     {@link NationalitesType }
     *     
     */
    public NationalitesType getNationalites() {
        return nationalites;
    }

    /**
     * Définit la valeur de la propriété nationalites.
     * 
     * @param value
     *     allowed object is
     *     {@link NationalitesType }
     *     
     */
    public void setNationalites(NationalitesType value) {
        this.nationalites = value;
    }

    /**
     * Obtient la valeur de la propriété fonction.
     * 
     * @return
     *     possible object is
     *     {@link FonctionType }
     *     
     */
    public FonctionType getFonction() {
        return fonction;
    }

    /**
     * Définit la valeur de la propriété fonction.
     * 
     * @param value
     *     allowed object is
     *     {@link FonctionType }
     *     
     */
    public void setFonction(FonctionType value) {
        this.fonction = value;
    }

    /**
     * Obtient la valeur de la propriété documentIdentite.
     * 
     * @return
     *     possible object is
     *     {@link DocumentIdentiteType }
     *     
     */
    public DocumentIdentiteType getDocumentIdentite() {
        return documentIdentite;
    }

    /**
     * Définit la valeur de la propriété documentIdentite.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentIdentiteType }
     *     
     */
    public void setDocumentIdentite(DocumentIdentiteType value) {
        this.documentIdentite = value;
    }

    /**
     * Obtient la valeur de la propriété informationsHabilitationExterne.
     * 
     * @return
     *     possible object is
     *     {@link InformationsHabilitationExterneType }
     *     
     */
    public InformationsHabilitationExterneType getInformationsHabilitationExterne() {
        return informationsHabilitationExterne;
    }

    /**
     * Définit la valeur de la propriété informationsHabilitationExterne.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationsHabilitationExterneType }
     *     
     */
    public void setInformationsHabilitationExterne(InformationsHabilitationExterneType value) {
        this.informationsHabilitationExterne = value;
    }

    /**
     * Obtient la valeur de la propriété idEntreprise.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEntreprise() {
        return idEntreprise;
    }

    /**
     * Définit la valeur de la propriété idEntreprise.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEntreprise(String value) {
        this.idEntreprise = value;
    }

}
