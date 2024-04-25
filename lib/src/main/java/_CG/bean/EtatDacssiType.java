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
 * <p>Classe Java pour etatDacssiType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="etatDacssiType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="NON_TRANSMISE"/>
 *     <enumeration value="TRANSMISE"/>
 *     <enumeration value="RECUE"/>
 *     <enumeration value="DECISION"/>
 *     <enumeration value="ENGAGEMENT"/>
 *     <enumeration value="CLOS"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "etatDacssiType")
@XmlEnum
public enum EtatDacssiType {

    NON_TRANSMISE,
    TRANSMISE,
    RECUE,
    DECISION,
    ENGAGEMENT,
    CLOS;

    public String value() {
        return name();
    }

    public static EtatDacssiType fromValue(String v) {
        return valueOf(v);
    }

}
