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
 * <p>Classe Java pour actionType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="actionType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CREATION"/>
 *     <enumeration value="AFFECTATION"/>
 *     <enumeration value="RECEPTION"/>
 *     <enumeration value="EMISSION"/>
 *     <enumeration value="DESTRUCTION"/>
 *     <enumeration value="TRANSFERT"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "actionType")
@XmlEnum
public enum ActionType {

    CREATION,
    AFFECTATION,
    RECEPTION,
    EMISSION,
    DESTRUCTION,
    TRANSFERT;

    public String value() {
        return name();
    }

    public static ActionType fromValue(String v) {
        return valueOf(v);
    }

}
