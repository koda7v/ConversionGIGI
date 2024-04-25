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
 * <p>Classe Java pour habilitationType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="habilitationType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="NumeroInterne" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="NumeroSophia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="IdPersonne" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="DateRemiseDossier" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="DateValidite" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateEngagement" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateDesengagement" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateCloture" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="Actif" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="Etat" type="{giraphix}etatType"/>
 *         <element name="Motif" type="{giraphix}motifType"/>
 *         <element name="Niveau" type="{giraphix}niveauType"/>
 *         <element name="Nature" type="{giraphix}natureType"/>
 *         <element name="Avis" type="{giraphix}avisHabilitationType" minOccurs="0"/>
 *         <element name="Workflow" type="{giraphix}workflowType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "habilitationType", propOrder = {
    "numeroInterne",
    "numeroSophia",
    "idPersonne",
    "dateRemiseDossier",
    "dateValidite",
    "dateEngagement",
    "dateDesengagement",
    "dateCloture",
    "actif",
    "etat",
    "motif",
    "niveau",
    "nature",
    "avis",
    "workflow"
})
public class HabilitationType {

    @XmlElement(name = "NumeroInterne", required = true)
    protected String numeroInterne;
    @XmlElement(name = "NumeroSophia")
    protected String numeroSophia;
    @XmlElement(name = "IdPersonne", required = true)
    protected String idPersonne;
    @XmlElement(name = "DateRemiseDossier")
    protected long dateRemiseDossier;
    @XmlElement(name = "DateValidite")
    protected Long dateValidite;
    @XmlElement(name = "DateEngagement")
    protected Long dateEngagement;
    @XmlElement(name = "DateDesengagement")
    protected Long dateDesengagement;
    @XmlElement(name = "DateCloture")
    protected Long dateCloture;
    @XmlElement(name = "Actif")
    protected boolean actif;
    @XmlElement(name = "Etat", required = true)
    @XmlSchemaType(name = "string")
    protected EtatType etat;
    @XmlElement(name = "Motif", required = true)
    @XmlSchemaType(name = "string")
    protected MotifType motif;
    @XmlElement(name = "Niveau", required = true)
    @XmlSchemaType(name = "string")
    protected NiveauType niveau;
    @XmlElement(name = "Nature", required = true)
    @XmlSchemaType(name = "string")
    protected NatureType nature;
    @XmlElement(name = "Avis")
    @XmlSchemaType(name = "string")
    protected AvisHabilitationType avis;
    @XmlElement(name = "Workflow")
    protected WorkflowType workflow;

    /**
     * Obtient la valeur de la propriété numeroInterne.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroInterne() {
        return numeroInterne;
    }

    /**
     * Définit la valeur de la propriété numeroInterne.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroInterne(String value) {
        this.numeroInterne = value;
    }

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
     * Obtient la valeur de la propriété dateRemiseDossier.
     * 
     */
    public long getDateRemiseDossier() {
        return dateRemiseDossier;
    }

    /**
     * Définit la valeur de la propriété dateRemiseDossier.
     * 
     */
    public void setDateRemiseDossier(long value) {
        this.dateRemiseDossier = value;
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

    /**
     * Obtient la valeur de la propriété dateEngagement.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateEngagement() {
        return dateEngagement;
    }

    /**
     * Définit la valeur de la propriété dateEngagement.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateEngagement(Long value) {
        this.dateEngagement = value;
    }

    /**
     * Obtient la valeur de la propriété dateDesengagement.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateDesengagement() {
        return dateDesengagement;
    }

    /**
     * Définit la valeur de la propriété dateDesengagement.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateDesengagement(Long value) {
        this.dateDesengagement = value;
    }

    /**
     * Obtient la valeur de la propriété dateCloture.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateCloture() {
        return dateCloture;
    }

    /**
     * Définit la valeur de la propriété dateCloture.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateCloture(Long value) {
        this.dateCloture = value;
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
     * Obtient la valeur de la propriété etat.
     * 
     * @return
     *     possible object is
     *     {@link EtatType }
     *     
     */
    public EtatType getEtat() {
        return etat;
    }

    /**
     * Définit la valeur de la propriété etat.
     * 
     * @param value
     *     allowed object is
     *     {@link EtatType }
     *     
     */
    public void setEtat(EtatType value) {
        this.etat = value;
    }

    /**
     * Obtient la valeur de la propriété motif.
     * 
     * @return
     *     possible object is
     *     {@link MotifType }
     *     
     */
    public MotifType getMotif() {
        return motif;
    }

    /**
     * Définit la valeur de la propriété motif.
     * 
     * @param value
     *     allowed object is
     *     {@link MotifType }
     *     
     */
    public void setMotif(MotifType value) {
        this.motif = value;
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
     * Obtient la valeur de la propriété avis.
     * 
     * @return
     *     possible object is
     *     {@link AvisHabilitationType }
     *     
     */
    public AvisHabilitationType getAvis() {
        return avis;
    }

    /**
     * Définit la valeur de la propriété avis.
     * 
     * @param value
     *     allowed object is
     *     {@link AvisHabilitationType }
     *     
     */
    public void setAvis(AvisHabilitationType value) {
        this.avis = value;
    }

    /**
     * Obtient la valeur de la propriété workflow.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowType }
     *     
     */
    public WorkflowType getWorkflow() {
        return workflow;
    }

    /**
     * Définit la valeur de la propriété workflow.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowType }
     *     
     */
    public void setWorkflow(WorkflowType value) {
        this.workflow = value;
    }

}
