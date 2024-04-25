//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.5 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package _CG.bean;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Classe Java pour etatType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="etatType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="NON_TRANSMISE"/>
 *     <enumeration value="TRANSMISE"/>
 *     <enumeration value="RECUE"/>
 *     <enumeration value="ENQUETE"/>
 *     <enumeration value="AVIS"/>
 *     <enumeration value="DECISION"/>
 *     <enumeration value="ENGAGEMENT"/>
 *     <enumeration value="CLOS"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "etatType")
@XmlEnum
public enum EtatType {

    NON_TRANSMISE,
    TRANSMISE,
    RECUE,
    ENQUETE,
    AVIS,
    DECISION,
    ENGAGEMENT,
    CLOS;

    public String value() {
        return name();
    }

    public static EtatType fromValue(String v) {
        return valueOf(v);
    }

}
