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
 * <p>Classe Java pour classificationType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="classificationType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CONFIDENTIEL_DEFENSE"/>
 *     <enumeration value="SECRET_DEFENSE"/>
 *     <enumeration value="SECRET"/>
 *     <enumeration value="TRES_SECRET"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "classificationType")
@XmlEnum
public enum ClassificationType {

    CONFIDENTIEL_DEFENSE,
    SECRET_DEFENSE,
    SECRET,
    TRES_SECRET;

    public String value() {
        return name();
    }

    public static ClassificationType fromValue(String v) {
        return valueOf(v);
    }

}
