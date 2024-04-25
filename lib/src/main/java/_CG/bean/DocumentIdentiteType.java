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
 * <p>Classe Java pour documentIdentiteType complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="documentIdentiteType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="DelivrePar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="DateDeDelivrance" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="TypeDocument" type="{giraphix}documentType"/>
 *         <element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="DateDeValidite" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentIdentiteType", propOrder = {
    "delivrePar",
    "dateDeDelivrance",
    "typeDocument",
    "numero",
    "dateDeValidite"
})
public class DocumentIdentiteType {

    @XmlElement(name = "DelivrePar")
    protected String delivrePar;
    @XmlElement(name = "DateDeDelivrance")
    protected Long dateDeDelivrance;
    @XmlElement(name = "TypeDocument", required = true)
    @XmlSchemaType(name = "string")
    protected DocumentType typeDocument;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "DateDeValidite")
    protected Long dateDeValidite;

    /**
     * Obtient la valeur de la propriété delivrePar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelivrePar() {
        return delivrePar;
    }

    /**
     * Définit la valeur de la propriété delivrePar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelivrePar(String value) {
        this.delivrePar = value;
    }

    /**
     * Obtient la valeur de la propriété dateDeDelivrance.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateDeDelivrance() {
        return dateDeDelivrance;
    }

    /**
     * Définit la valeur de la propriété dateDeDelivrance.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateDeDelivrance(Long value) {
        this.dateDeDelivrance = value;
    }

    /**
     * Obtient la valeur de la propriété typeDocument.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType }
     *     
     */
    public DocumentType getTypeDocument() {
        return typeDocument;
    }

    /**
     * Définit la valeur de la propriété typeDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType }
     *     
     */
    public void setTypeDocument(DocumentType value) {
        this.typeDocument = value;
    }

    /**
     * Obtient la valeur de la propriété numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Définit la valeur de la propriété numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtient la valeur de la propriété dateDeValidite.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDateDeValidite() {
        return dateDeValidite;
    }

    /**
     * Définit la valeur de la propriété dateDeValidite.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDateDeValidite(Long value) {
        this.dateDeValidite = value;
    }

}
