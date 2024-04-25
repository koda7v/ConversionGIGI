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
 * <p>Classe Java pour avisHabilitationType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="avisHabilitationType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="EN_ATTENTE"/>
 *     <enumeration value="REFUS"/>
 *     <enumeration value="FAVORABLE_AVEC_RESERVE"/>
 *     <enumeration value="FAVORABLE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "avisHabilitationType")
@XmlEnum
public enum AvisHabilitationType {

    EN_ATTENTE,
    REFUS,
    FAVORABLE_AVEC_RESERVE,
    FAVORABLE;

    public String value() {
        return name();
    }

    public static AvisHabilitationType fromValue(String v) {
        return valueOf(v);
    }

}
