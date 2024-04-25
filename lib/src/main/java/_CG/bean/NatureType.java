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
 * <p>Classe Java pour natureType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="natureType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="FRANCE"/>
 *     <enumeration value="DEFENSE"/>
 *     <enumeration value="UNION_EUROPEENNE"/>
 *     <enumeration value="OTAN"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "natureType")
@XmlEnum
public enum NatureType {

    FRANCE,
    DEFENSE,
    UNION_EUROPEENNE,
    OTAN;

    public String value() {
        return name();
    }

    public static NatureType fromValue(String v) {
        return valueOf(v);
    }

}
