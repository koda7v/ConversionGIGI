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
 * <p>Classe Java pour fonctionType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="fonctionType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="INGENIEURS_ET_CADRE"/>
 *     <enumeration value="EMPLOYES"/>
 *     <enumeration value="OUVRIERS"/>
 *     <enumeration value="TECHNICIENS"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "fonctionType")
@XmlEnum
public enum FonctionType {

    INGENIEURS_ET_CADRE,
    EMPLOYES,
    OUVRIERS,
    TECHNICIENS;

    public String value() {
        return name();
    }

    public static FonctionType fromValue(String v) {
        return valueOf(v);
    }

}
