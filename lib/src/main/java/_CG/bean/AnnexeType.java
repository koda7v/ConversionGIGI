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
 * <p>Classe Java pour annexeType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="annexeType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="NumeroAnnexeSecurite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="NumeroOperationProtegee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="IdentifiantAnnexeSecurite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="DateDebut" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateFin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Classification" type="{giraphix}classificationType"/>
 *         <element name="Mention" type="{giraphix}mentionsType" minOccurs="0"/>
 *         <element name="Ficas" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="IdSystemeInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="IdEmetteur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="IdTitulaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annexeType", propOrder = {
    "id",
    "nom",
    "numeroAnnexeSecurite",
    "numeroOperationProtegee",
    "identifiantAnnexeSecurite",
    "dateDebut",
    "dateFin",
    "description",
    "classification",
    "mention",
    "ficas",
    "idSystemeInformation",
    "idEmetteur",
    "idTitulaire"
})
public class AnnexeType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Nom", required = true)
    protected String nom;
    @XmlElement(name = "NumeroAnnexeSecurite", required = true)
    protected String numeroAnnexeSecurite;
    @XmlElement(name = "NumeroOperationProtegee", required = true)
    protected String numeroOperationProtegee;
    @XmlElement(name = "IdentifiantAnnexeSecurite")
    protected String identifiantAnnexeSecurite;
    @XmlElement(name = "DateDebut")
    protected Long dateDebut;
    @XmlElement(name = "DateFin")
    protected Long dateFin;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Classification", required = true)
    @XmlSchemaType(name = "string")
    protected ClassificationType classification;
    @XmlElement(name = "Mention")
    protected MentionsType mention;
    @XmlElement(name = "Ficas")
    protected boolean ficas;
    @XmlElement(name = "IdSystemeInformation")
    protected String idSystemeInformation;
    @XmlElement(name = "IdEmetteur")
    protected String idEmetteur;
    @XmlElement(name = "IdTitulaire")
    protected String idTitulaire;

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
     * Obtient la valeur de la propriété numeroAnnexeSecurite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroAnnexeSecurite() {
        return numeroAnnexeSecurite;
    }

    /**
     * Définit la valeur de la propriété numeroAnnexeSecurite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroAnnexeSecurite(String value) {
        this.numeroAnnexeSecurite = value;
    }

    /**
     * Obtient la valeur de la propriété numeroOperationProtegee.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroOperationProtegee() {
        return numeroOperationProtegee;
    }

    /**
     * Définit la valeur de la propriété numeroOperationProtegee.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroOperationProtegee(String value) {
        this.numeroOperationProtegee = value;
    }

    /**
     * Obtient la valeur de la propriété identifiantAnnexeSecurite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifiantAnnexeSecurite() {
        return identifiantAnnexeSecurite;
    }

    /**
     * Définit la valeur de la propriété identifiantAnnexeSecurite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifiantAnnexeSecurite(String value) {
        this.identifiantAnnexeSecurite = value;
    }

    /**
     * Obtient la valeur de la propriété dateDebut.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la valeur de la propriété dateDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateDebut(Long value) {
        this.dateDebut = value;
    }

    /**
     * Obtient la valeur de la propriété dateFin.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateFin() {
        return dateFin;
    }

    /**
     * Définit la valeur de la propriété dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateFin(Long value) {
        this.dateFin = value;
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
     * Obtient la valeur de la propriété classification.
     * 
     * @return
     *     possible object is
     *     {@link ClassificationType }
     *     
     */
    public ClassificationType getClassification() {
        return classification;
    }

    /**
     * Définit la valeur de la propriété classification.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassificationType }
     *     
     */
    public void setClassification(ClassificationType value) {
        this.classification = value;
    }

    /**
     * Obtient la valeur de la propriété mention.
     * 
     * @return
     *     possible object is
     *     {@link MentionsType }
     *     
     */
    public MentionsType getMention() {
        return mention;
    }

    /**
     * Définit la valeur de la propriété mention.
     * 
     * @param value
     *     allowed object is
     *     {@link MentionsType }
     *     
     */
    public void setMention(MentionsType value) {
        this.mention = value;
    }

    /**
     * Obtient la valeur de la propriété ficas.
     * 
     */
    public boolean isFicas() {
        return ficas;
    }

    /**
     * Définit la valeur de la propriété ficas.
     * 
     */
    public void setFicas(boolean value) {
        this.ficas = value;
    }

    /**
     * Obtient la valeur de la propriété idSystemeInformation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSystemeInformation() {
        return idSystemeInformation;
    }

    /**
     * Définit la valeur de la propriété idSystemeInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSystemeInformation(String value) {
        this.idSystemeInformation = value;
    }

    /**
     * Obtient la valeur de la propriété idEmetteur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEmetteur() {
        return idEmetteur;
    }

    /**
     * Définit la valeur de la propriété idEmetteur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEmetteur(String value) {
        this.idEmetteur = value;
    }

    /**
     * Obtient la valeur de la propriété idTitulaire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTitulaire() {
        return idTitulaire;
    }

    /**
     * Définit la valeur de la propriété idTitulaire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTitulaire(String value) {
        this.idTitulaire = value;
    }

}
