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
 * <p>Classe Java pour fonctionDacssiType.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="fonctionDacssiType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="OSSI"/>
 *     <enumeration value="OSSI_SUPPLEANT"/>
 *     <enumeration value="ADMINISTRATION"/>
 *     <enumeration value="ETUDE_DEVELOPPEMENT_EVALUTAION"/>
 *     <enumeration value="ELABORATION_MANIPULATION"/>
 *     <enumeration value="MISE_EN_OEUVRE"/>
 *     <enumeration value="MAINTENANCE_EN_OEUVRE"/>
 *     <enumeration value="GESTION_EN_OEUVRE"/>
 *     <enumeration value="FABRICATION_INDUSTRIALISATION_TEST"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "fonctionDacssiType")
@XmlEnum
public enum FonctionDacssiType {

    OSSI,
    OSSI_SUPPLEANT,
    ADMINISTRATION,
    ETUDE_DEVELOPPEMENT_EVALUTAION,
    ELABORATION_MANIPULATION,
    MISE_EN_OEUVRE,
    MAINTENANCE_EN_OEUVRE,
    GESTION_EN_OEUVRE,
    FABRICATION_INDUSTRIALISATION_TEST;

    public String value() {
        return name();
    }

    public static FonctionDacssiType fromValue(String v) {
        return valueOf(v);
    }

}
