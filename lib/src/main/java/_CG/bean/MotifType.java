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
 * <p>Classe Java pour motifType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="motifType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="ADMISSION"/>
 *     <enumeration value="RENOUVELLEMENT"/>
 *     <enumeration value="REVISION"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "motifType")
@XmlEnum
public enum MotifType {

    ADMISSION,
    RENOUVELLEMENT,
    REVISION;

    public String value() {
        return name();
    }

    public static MotifType fromValue(String v) {
        return valueOf(v);
    }

}
