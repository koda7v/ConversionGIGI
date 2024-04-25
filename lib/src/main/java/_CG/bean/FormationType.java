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
 * <p>Classe Java pour formationType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="formationType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Libelle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Type" type="{giraphix}typeFormationType"/>
 *         <element name="Programme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Organisateur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="DateDeDebut" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="Duree" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Lieu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Termine" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="Participant" type="{giraphix}participantsType"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "formationType", propOrder = {
    "id",
    "libelle",
    "type",
    "programme",
    "organisateur",
    "dateDeDebut",
    "duree",
    "lieu",
    "termine",
    "participant"
})
public class FormationType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Libelle", required = true)
    protected String libelle;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected TypeFormationType type;
    @XmlElement(name = "Programme", required = true)
    protected String programme;
    @XmlElement(name = "Organisateur", required = true)
    protected String organisateur;
    @XmlElement(name = "DateDeDebut")
    protected Long dateDeDebut;
    @XmlElement(name = "Duree", required = true)
    protected String duree;
    @XmlElement(name = "Lieu", required = true)
    protected String lieu;
    @XmlElement(name = "Termine")
    protected boolean termine;
    @XmlElement(name = "Participant", required = true)
    protected ParticipantsType participant;

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
     * Obtient la valeur de la propriété libelle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Définit la valeur de la propriété libelle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelle(String value) {
        this.libelle = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link TypeFormationType }
     *     
     */
    public TypeFormationType getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeFormationType }
     *     
     */
    public void setType(TypeFormationType value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriété programme.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * Définit la valeur de la propriété programme.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramme(String value) {
        this.programme = value;
    }

    /**
     * Obtient la valeur de la propriété organisateur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisateur() {
        return organisateur;
    }

    /**
     * Définit la valeur de la propriété organisateur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisateur(String value) {
        this.organisateur = value;
    }

    /**
     * Obtient la valeur de la propriété dateDeDebut.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateDeDebut() {
        return dateDeDebut;
    }

    /**
     * Définit la valeur de la propriété dateDeDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateDeDebut(Long value) {
        this.dateDeDebut = value;
    }

    /**
     * Obtient la valeur de la propriété duree.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuree() {
        return duree;
    }

    /**
     * Définit la valeur de la propriété duree.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuree(String value) {
        this.duree = value;
    }

    /**
     * Obtient la valeur de la propriété lieu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Définit la valeur de la propriété lieu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLieu(String value) {
        this.lieu = value;
    }

    /**
     * Obtient la valeur de la propriété termine.
     * 
     */
    public boolean isTermine() {
        return termine;
    }

    /**
     * Définit la valeur de la propriété termine.
     * 
     */
    public void setTermine(boolean value) {
        this.termine = value;
    }

    /**
     * Obtient la valeur de la propriété participant.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantsType }
     *     
     */
    public ParticipantsType getParticipant() {
        return participant;
    }

    /**
     * Définit la valeur de la propriété participant.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantsType }
     *     
     */
    public void setParticipant(ParticipantsType value) {
        this.participant = value;
    }

}
