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
 * <p>Classe Java pour actionBadgeType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="actionBadgeType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CREATION"/>
 *     <enumeration value="ACTIVATION"/>
 *     <enumeration value="DESACTIVATION"/>
 *     <enumeration value="AFFECTATION"/>
 *     <enumeration value="DESAFFECTATION"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "actionBadgeType")
@XmlEnum
public enum ActionBadgeType {

    CREATION,
    ACTIVATION,
    DESACTIVATION,
    AFFECTATION,
    DESAFFECTATION;

    public String value() {
        return name();
    }

    public static ActionBadgeType fromValue(String v) {
        return valueOf(v);
    }

}
