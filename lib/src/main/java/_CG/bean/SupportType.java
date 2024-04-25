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
 * <p>Classe Java pour supportType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="supportType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Reference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Classification" type="{giraphix}classificationType"/>
 *         <element name="DateCreation" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="DateMaj" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="ReferenceSupport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="TypeSupport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Statut" type="{giraphix}statutType"/>
 *         <element name="Localisation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Checksum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="VersionAntiVirus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="NumeroSerie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ReferenceBordereauReception" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ReferenceBDSExterne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Historique" type="{giraphix}historiqueType"/>
 *         <element name="IdPersonne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="IdAnnexeSecurite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supportType", propOrder = {
    "reference",
    "classification",
    "dateCreation",
    "dateMaj",
    "referenceSupport",
    "description",
    "typeSupport",
    "statut",
    "localisation",
    "checksum",
    "versionAntiVirus",
    "numeroSerie",
    "referenceBordereauReception",
    "referenceBDSExterne",
    "historique",
    "idPersonne",
    "idAnnexeSecurite"
})
public class SupportType {

    @XmlElement(name = "Reference", required = true)
    protected String reference;
    @XmlElement(name = "Classification", required = true)
    @XmlSchemaType(name = "string")
    protected ClassificationType classification;
    @XmlElement(name = "DateCreation")
    protected long dateCreation;
    @XmlElement(name = "DateMaj")
    protected long dateMaj;
    @XmlElement(name = "ReferenceSupport", required = true)
    protected String referenceSupport;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "TypeSupport", required = true)
    protected String typeSupport;
    @XmlElement(name = "Statut", required = true)
    @XmlSchemaType(name = "string")
    protected StatutType statut;
    @XmlElement(name = "Localisation")
    protected String localisation;
    @XmlElement(name = "Checksum")
    protected String checksum;
    @XmlElement(name = "VersionAntiVirus")
    protected String versionAntiVirus;
    @XmlElement(name = "NumeroSerie")
    protected String numeroSerie;
    @XmlElement(name = "ReferenceBordereauReception")
    protected String referenceBordereauReception;
    @XmlElement(name = "ReferenceBDSExterne")
    protected String referenceBDSExterne;
    @XmlElement(name = "Historique", required = true)
    protected HistoriqueType historique;
    @XmlElement(name = "IdPersonne")
    protected String idPersonne;
    @XmlElement(name = "IdAnnexeSecurite", required = true)
    protected String idAnnexeSecurite;

    /**
     * Obtient la valeur de la propriété reference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Définit la valeur de la propriété reference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
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
     * Obtient la valeur de la propriété dateCreation.
     * 
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Définit la valeur de la propriété dateCreation.
     * 
     */
    public void setDateCreation(long value) {
        this.dateCreation = value;
    }

    /**
     * Obtient la valeur de la propriété dateMaj.
     * 
     */
    public long getDateMaj() {
        return dateMaj;
    }

    /**
     * Définit la valeur de la propriété dateMaj.
     * 
     */
    public void setDateMaj(long value) {
        this.dateMaj = value;
    }

    /**
     * Obtient la valeur de la propriété referenceSupport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceSupport() {
        return referenceSupport;
    }

    /**
     * Définit la valeur de la propriété referenceSupport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceSupport(String value) {
        this.referenceSupport = value;
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
     * Obtient la valeur de la propriété typeSupport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeSupport() {
        return typeSupport;
    }

    /**
     * Définit la valeur de la propriété typeSupport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeSupport(String value) {
        this.typeSupport = value;
    }

    /**
     * Obtient la valeur de la propriété statut.
     * 
     * @return
     *     possible object is
     *     {@link StatutType }
     *     
     */
    public StatutType getStatut() {
        return statut;
    }

    /**
     * Définit la valeur de la propriété statut.
     * 
     * @param value
     *     allowed object is
     *     {@link StatutType }
     *     
     */
    public void setStatut(StatutType value) {
        this.statut = value;
    }

    /**
     * Obtient la valeur de la propriété localisation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * Définit la valeur de la propriété localisation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalisation(String value) {
        this.localisation = value;
    }

    /**
     * Obtient la valeur de la propriété checksum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * Définit la valeur de la propriété checksum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChecksum(String value) {
        this.checksum = value;
    }

    /**
     * Obtient la valeur de la propriété versionAntiVirus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionAntiVirus() {
        return versionAntiVirus;
    }

    /**
     * Définit la valeur de la propriété versionAntiVirus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionAntiVirus(String value) {
        this.versionAntiVirus = value;
    }

    /**
     * Obtient la valeur de la propriété numeroSerie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Définit la valeur de la propriété numeroSerie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSerie(String value) {
        this.numeroSerie = value;
    }

    /**
     * Obtient la valeur de la propriété referenceBordereauReception.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceBordereauReception() {
        return referenceBordereauReception;
    }

    /**
     * Définit la valeur de la propriété referenceBordereauReception.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceBordereauReception(String value) {
        this.referenceBordereauReception = value;
    }

    /**
     * Obtient la valeur de la propriété referenceBDSExterne.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceBDSExterne() {
        return referenceBDSExterne;
    }

    /**
     * Définit la valeur de la propriété referenceBDSExterne.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceBDSExterne(String value) {
        this.referenceBDSExterne = value;
    }

    /**
     * Obtient la valeur de la propriété historique.
     * 
     * @return
     *     possible object is
     *     {@link HistoriqueType }
     *     
     */
    public HistoriqueType getHistorique() {
        return historique;
    }

    /**
     * Définit la valeur de la propriété historique.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoriqueType }
     *     
     */
    public void setHistorique(HistoriqueType value) {
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

    /**
     * Obtient la valeur de la propriété idAnnexeSecurite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAnnexeSecurite() {
        return idAnnexeSecurite;
    }

    /**
     * Définit la valeur de la propriété idAnnexeSecurite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAnnexeSecurite(String value) {
        this.idAnnexeSecurite = value;
    }

}
