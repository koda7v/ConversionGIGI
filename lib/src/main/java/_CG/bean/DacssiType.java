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
 * <p>Classe Java pour dacssiType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="dacssiType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="NumeroInterne" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="NumeroSophia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Motif" type="{giraphix}motifDacssiType"/>
 *         <element name="Fonction" type="{giraphix}fonctionDacssiType"/>
 *         <element name="Niveau" type="{giraphix}niveauType"/>
 *         <element name="Nature" type="{giraphix}natureType"/>
 *         <element name="Avis" type="{giraphix}avisHabilitationType"/>
 *         <element name="DateValidite" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateEngagement" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateDesengagement" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateRemiseDossier" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateProvisoireDebut" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateProvisoireFin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="DateCloture" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="Etat" type="{giraphix}etatDacssiType"/>
 *         <element name="IdentifiantACSSI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="IdPersonne" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="IdAnnexe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="IdFormation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="Workflow" type="{giraphix}workflowDacssiType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dacssiType", propOrder = {
    "numeroInterne",
    "numeroSophia",
    "motif",
    "fonction",
    "niveau",
    "nature",
    "avis",
    "dateValidite",
    "dateEngagement",
    "dateDesengagement",
    "dateRemiseDossier",
    "dateProvisoireDebut",
    "dateProvisoireFin",
    "dateCloture",
    "etat",
    "identifiantACSSI",
    "idPersonne",
    "idAnnexe",
    "idFormation",
    "workflow"
})
public class DacssiType {

    @XmlElement(name = "NumeroInterne", required = true)
    protected String numeroInterne;
    @XmlElement(name = "NumeroSophia")
    protected String numeroSophia;
    @XmlElement(name = "Motif", required = true)
    @XmlSchemaType(name = "string")
    protected MotifDacssiType motif;
    @XmlElement(name = "Fonction", required = true)
    @XmlSchemaType(name = "string")
    protected FonctionDacssiType fonction;
    @XmlElement(name = "Niveau", required = true)
    @XmlSchemaType(name = "string")
    protected NiveauType niveau;
    @XmlElement(name = "Nature", required = true)
    @XmlSchemaType(name = "string")
    protected NatureType nature;
    @XmlElement(name = "Avis", required = true)
    @XmlSchemaType(name = "string")
    protected AvisHabilitationType avis;
    @XmlElement(name = "DateValidite")
    protected Long dateValidite;
    @XmlElement(name = "DateEngagement")
    protected Long dateEngagement;
    @XmlElement(name = "DateDesengagement")
    protected Long dateDesengagement;
    @XmlElement(name = "DateRemiseDossier")
    protected Long dateRemiseDossier;
    @XmlElement(name = "DateProvisoireDebut")
    protected Long dateProvisoireDebut;
    @XmlElement(name = "DateProvisoireFin")
    protected Long dateProvisoireFin;
    @XmlElement(name = "DateCloture")
    protected Long dateCloture;
    @XmlElement(name = "Etat", required = true)
    @XmlSchemaType(name = "string")
    protected EtatDacssiType etat;
    @XmlElement(name = "IdentifiantACSSI")
    protected String identifiantACSSI;
    @XmlElement(name = "IdPersonne", required = true)
    protected String idPersonne;
    @XmlElement(name = "IdAnnexe", required = true)
    protected String idAnnexe;
    @XmlElement(name = "IdFormation", required = true)
    protected String idFormation;
    @XmlElement(name = "Workflow")
    protected WorkflowDacssiType workflow;

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
     * Obtient la valeur de la propriété motif.
     * 
     * @return
     *     possible object is
     *     {@link MotifDacssiType }
     *     
     */
    public MotifDacssiType getMotif() {
        return motif;
    }

    /**
     * Définit la valeur de la propriété motif.
     * 
     * @param value
     *     allowed object is
     *     {@link MotifDacssiType }
     *     
     */
    public void setMotif(MotifDacssiType value) {
        this.motif = value;
    }

    /**
     * Obtient la valeur de la propriété fonction.
     * 
     * @return
     *     possible object is
     *     {@link FonctionDacssiType }
     *     
     */
    public FonctionDacssiType getFonction() {
        return fonction;
    }

    /**
     * Définit la valeur de la propriété fonction.
     * 
     * @param value
     *     allowed object is
     *     {@link FonctionDacssiType }
     *     
     */
    public void setFonction(FonctionDacssiType value) {
        this.fonction = value;
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
     * Obtient la valeur de la propriété dateRemiseDossier.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateRemiseDossier() {
        return dateRemiseDossier;
    }

    /**
     * Définit la valeur de la propriété dateRemiseDossier.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateRemiseDossier(Long value) {
        this.dateRemiseDossier = value;
    }

    /**
     * Obtient la valeur de la propriété dateProvisoireDebut.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateProvisoireDebut() {
        return dateProvisoireDebut;
    }

    /**
     * Définit la valeur de la propriété dateProvisoireDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateProvisoireDebut(Long value) {
        this.dateProvisoireDebut = value;
    }

    /**
     * Obtient la valeur de la propriété dateProvisoireFin.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateProvisoireFin() {
        return dateProvisoireFin;
    }

    /**
     * Définit la valeur de la propriété dateProvisoireFin.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateProvisoireFin(Long value) {
        this.dateProvisoireFin = value;
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
     * Obtient la valeur de la propriété etat.
     * 
     * @return
     *     possible object is
     *     {@link EtatDacssiType }
     *     
     */
    public EtatDacssiType getEtat() {
        return etat;
    }

    /**
     * Définit la valeur de la propriété etat.
     * 
     * @param value
     *     allowed object is
     *     {@link EtatDacssiType }
     *     
     */
    public void setEtat(EtatDacssiType value) {
        this.etat = value;
    }

    /**
     * Obtient la valeur de la propriété identifiantACSSI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifiantACSSI() {
        return identifiantACSSI;
    }

    /**
     * Définit la valeur de la propriété identifiantACSSI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifiantACSSI(String value) {
        this.identifiantACSSI = value;
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
     * Obtient la valeur de la propriété idAnnexe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAnnexe() {
        return idAnnexe;
    }

    /**
     * Définit la valeur de la propriété idAnnexe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAnnexe(String value) {
        this.idAnnexe = value;
    }

    /**
     * Obtient la valeur de la propriété idFormation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFormation() {
        return idFormation;
    }

    /**
     * Définit la valeur de la propriété idFormation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFormation(String value) {
        this.idFormation = value;
    }

    /**
     * Obtient la valeur de la propriété workflow.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowDacssiType }
     *     
     */
    public WorkflowDacssiType getWorkflow() {
        return workflow;
    }

    /**
     * Définit la valeur de la propriété workflow.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowDacssiType }
     *     
     */
    public void setWorkflow(WorkflowDacssiType value) {
        this.workflow = value;
    }

}
