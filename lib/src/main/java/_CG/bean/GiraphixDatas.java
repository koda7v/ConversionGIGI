//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package _CG.bean;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Utilisateurs" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Utilisateur" type="{giraphix}utilisateurType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="Entreprises" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Entreprise" type="{giraphix}entrepriseType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="Personnes" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Personne" type="{giraphix}personneType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="Habilitations" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Habilitation" type="{giraphix}habilitationType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="SystemesInformations" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="SystemeInformations" type="{giraphix}systemeInformationsType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="Annexes" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Annexe" type="{giraphix}annexeType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="Supports" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Support" type="{giraphix}supportType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="Formations" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Formation" type="{giraphix}formationType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="DacssiList" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="DACSSI" type="{giraphix}dacssiType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="Badges" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Badge" type="{giraphix}badgeType" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *       <attribute name="ModelVersion" use="required" type="{giraphix}ModelVersionType" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "utilisateurs",
    "entreprises",
    "personnes",
    "habilitations",
    "systemesInformations",
    "annexes",
    "supports",
    "formations",
    "dacssiList",
    "badges"
})
@XmlRootElement(name = "GiraphixDatas")
public class GiraphixDatas {

    @XmlElement(name = "Utilisateurs")
    protected GiraphixDatas.Utilisateurs utilisateurs;
    @XmlElement(name = "Entreprises")
    protected GiraphixDatas.Entreprises entreprises;
    @XmlElement(name = "Personnes")
    protected GiraphixDatas.Personnes personnes;
    @XmlElement(name = "Habilitations")
    protected GiraphixDatas.Habilitations habilitations;
    @XmlElement(name = "SystemesInformations")
    protected GiraphixDatas.SystemesInformations systemesInformations;
    @XmlElement(name = "Annexes")
    protected GiraphixDatas.Annexes annexes;
    @XmlElement(name = "Supports")
    protected GiraphixDatas.Supports supports;
    @XmlElement(name = "Formations")
    protected GiraphixDatas.Formations formations;
    @XmlElement(name = "DacssiList")
    protected GiraphixDatas.DacssiList dacssiList;
    @XmlElement(name = "Badges")
    protected GiraphixDatas.Badges badges;
    @XmlAttribute(name = "ModelVersion", required = true)
    protected String modelVersion;

    /**
     * Obtient la valeur de la propriété utilisateurs.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Utilisateurs }
     *     
     */
    public GiraphixDatas.Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }

    /**
     * Définit la valeur de la propriété utilisateurs.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Utilisateurs }
     *     
     */
    public void setUtilisateurs(GiraphixDatas.Utilisateurs value) {
        this.utilisateurs = value;
    }

    /**
     * Obtient la valeur de la propriété entreprises.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Entreprises }
     *     
     */
    public GiraphixDatas.Entreprises getEntreprises() {
        return entreprises;
    }

    /**
     * Définit la valeur de la propriété entreprises.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Entreprises }
     *     
     */
    public void setEntreprises(GiraphixDatas.Entreprises value) {
        this.entreprises = value;
    }

    /**
     * Obtient la valeur de la propriété personnes.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Personnes }
     *     
     */
    public GiraphixDatas.Personnes getPersonnes() {
        return personnes;
    }

    /**
     * Définit la valeur de la propriété personnes.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Personnes }
     *     
     */
    public void setPersonnes(GiraphixDatas.Personnes value) {
        this.personnes = value;
    }

    /**
     * Obtient la valeur de la propriété habilitations.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Habilitations }
     *     
     */
    public GiraphixDatas.Habilitations getHabilitations() {
        return habilitations;
    }

    /**
     * Définit la valeur de la propriété habilitations.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Habilitations }
     *     
     */
    public void setHabilitations(GiraphixDatas.Habilitations value) {
        this.habilitations = value;
    }

    /**
     * Obtient la valeur de la propriété systemesInformations.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.SystemesInformations }
     *     
     */
    public GiraphixDatas.SystemesInformations getSystemesInformations() {
        return systemesInformations;
    }

    /**
     * Définit la valeur de la propriété systemesInformations.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.SystemesInformations }
     *     
     */
    public void setSystemesInformations(GiraphixDatas.SystemesInformations value) {
        this.systemesInformations = value;
    }

    /**
     * Obtient la valeur de la propriété annexes.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Annexes }
     *     
     */
    public GiraphixDatas.Annexes getAnnexes() {
        return annexes;
    }

    /**
     * Définit la valeur de la propriété annexes.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Annexes }
     *     
     */
    public void setAnnexes(GiraphixDatas.Annexes value) {
        this.annexes = value;
    }

    /**
     * Obtient la valeur de la propriété supports.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Supports }
     *     
     */
    public GiraphixDatas.Supports getSupports() {
        return supports;
    }

    /**
     * Définit la valeur de la propriété supports.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Supports }
     *     
     */
    public void setSupports(GiraphixDatas.Supports value) {
        this.supports = value;
    }

    /**
     * Obtient la valeur de la propriété formations.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Formations }
     *     
     */
    public GiraphixDatas.Formations getFormations() {
        return formations;
    }

    /**
     * Définit la valeur de la propriété formations.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Formations }
     *     
     */
    public void setFormations(GiraphixDatas.Formations value) {
        this.formations = value;
    }

    /**
     * Obtient la valeur de la propriété dacssiList.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.DacssiList }
     *     
     */
    public GiraphixDatas.DacssiList getDacssiList() {
        return dacssiList;
    }

    /**
     * Définit la valeur de la propriété dacssiList.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.DacssiList }
     *     
     */
    public void setDacssiList(GiraphixDatas.DacssiList value) {
        this.dacssiList = value;
    }

    /**
     * Obtient la valeur de la propriété badges.
     * 
     * @return
     *     possible object is
     *     {@link GiraphixDatas.Badges }
     *     
     */
    public GiraphixDatas.Badges getBadges() {
        return badges;
    }

    /**
     * Définit la valeur de la propriété badges.
     * 
     * @param value
     *     allowed object is
     *     {@link GiraphixDatas.Badges }
     *     
     */
    public void setBadges(GiraphixDatas.Badges value) {
        this.badges = value;
    }

    /**
     * Obtient la valeur de la propriété modelVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelVersion() {
        return modelVersion;
    }

    /**
     * Définit la valeur de la propriété modelVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelVersion(String value) {
        this.modelVersion = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Annexe" type="{giraphix}annexeType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "annexe"
    })
    public static class Annexes {

        @XmlElement(name = "Annexe")
        protected List<AnnexeType> annexe;

        /**
         * Gets the value of the annexe property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the annexe property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getAnnexe().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AnnexeType }
         * </p>
         * 
         * 
         * @return
         *     The value of the annexe property.
         */
        public List<AnnexeType> getAnnexe() {
            if (annexe == null) {
                annexe = new ArrayList<>();
            }
            return this.annexe;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Badge" type="{giraphix}badgeType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "badge"
    })
    public static class Badges {

        @XmlElement(name = "Badge")
        protected List<BadgeType> badge;

        /**
         * Gets the value of the badge property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the badge property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getBadge().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BadgeType }
         * </p>
         * 
         * 
         * @return
         *     The value of the badge property.
         */
        public List<BadgeType> getBadge() {
            if (badge == null) {
                badge = new ArrayList<>();
            }
            return this.badge;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="DACSSI" type="{giraphix}dacssiType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dacssi"
    })
    public static class DacssiList {

        @XmlElement(name = "DACSSI")
        protected List<DacssiType> dacssi;

        /**
         * Gets the value of the dacssi property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dacssi property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getDACSSI().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DacssiType }
         * </p>
         * 
         * 
         * @return
         *     The value of the dacssi property.
         */
        public List<DacssiType> getDACSSI() {
            if (dacssi == null) {
                dacssi = new ArrayList<>();
            }
            return this.dacssi;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Entreprise" type="{giraphix}entrepriseType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entreprise"
    })
    public static class Entreprises {

        @XmlElement(name = "Entreprise")
        protected List<EntrepriseType> entreprise;

        /**
         * Gets the value of the entreprise property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entreprise property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getEntreprise().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EntrepriseType }
         * </p>
         * 
         * 
         * @return
         *     The value of the entreprise property.
         */
        public List<EntrepriseType> getEntreprise() {
            if (entreprise == null) {
                entreprise = new ArrayList<>();
            }
            return this.entreprise;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Formation" type="{giraphix}formationType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "formation"
    })
    public static class Formations {

        @XmlElement(name = "Formation")
        protected List<FormationType> formation;

        /**
         * Gets the value of the formation property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the formation property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getFormation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FormationType }
         * </p>
         * 
         * 
         * @return
         *     The value of the formation property.
         */
        public List<FormationType> getFormation() {
            if (formation == null) {
                formation = new ArrayList<>();
            }
            return this.formation;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Habilitation" type="{giraphix}habilitationType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "habilitation"
    })
    public static class Habilitations {

        @XmlElement(name = "Habilitation")
        protected List<HabilitationType> habilitation;

        /**
         * Gets the value of the habilitation property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the habilitation property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getHabilitation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HabilitationType }
         * </p>
         * 
         * 
         * @return
         *     The value of the habilitation property.
         */
        public List<HabilitationType> getHabilitation() {
            if (habilitation == null) {
                habilitation = new ArrayList<>();
            }
            return this.habilitation;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Personne" type="{giraphix}personneType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "personne"
    })
    public static class Personnes {

        @XmlElement(name = "Personne")
        protected List<PersonneType> personne;

        /**
         * Gets the value of the personne property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the personne property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getPersonne().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PersonneType }
         * </p>
         * 
         * 
         * @return
         *     The value of the personne property.
         */
        public List<PersonneType> getPersonne() {
            if (personne == null) {
                personne = new ArrayList<>();
            }
            return this.personne;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Support" type="{giraphix}supportType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "support"
    })
    public static class Supports {

        @XmlElement(name = "Support")
        protected List<SupportType> support;

        /**
         * Gets the value of the support property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the support property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getSupport().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SupportType }
         * </p>
         * 
         * 
         * @return
         *     The value of the support property.
         */
        public List<SupportType> getSupport() {
            if (support == null) {
                support = new ArrayList<>();
            }
            return this.support;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="SystemeInformations" type="{giraphix}systemeInformationsType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "systemeInformations"
    })
    public static class SystemesInformations {

        @XmlElement(name = "SystemeInformations")
        protected List<SystemeInformationsType> systemeInformations;

        /**
         * Gets the value of the systemeInformations property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the systemeInformations property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getSystemeInformations().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SystemeInformationsType }
         * </p>
         * 
         * 
         * @return
         *     The value of the systemeInformations property.
         */
        public List<SystemeInformationsType> getSystemeInformations() {
            if (systemeInformations == null) {
                systemeInformations = new ArrayList<>();
            }
            return this.systemeInformations;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Utilisateur" type="{giraphix}utilisateurType" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "utilisateur"
    })
    public static class Utilisateurs {

        @XmlElement(name = "Utilisateur")
        protected List<UtilisateurType> utilisateur;

        /**
         * Gets the value of the utilisateur property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the utilisateur property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getUtilisateur().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UtilisateurType }
         * </p>
         * 
         * 
         * @return
         *     The value of the utilisateur property.
         */
        public List<UtilisateurType> getUtilisateur() {
            if (utilisateur == null) {
                utilisateur = new ArrayList<>();
            }
            return this.utilisateur;
        }

    }

}
