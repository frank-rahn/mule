
package de.frank_rahn.xmlns.types.error._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für errorCategory.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="errorCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="FATAL"/>
 *     &lt;enumeration value="CONFIG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "errorCategory")
@XmlEnum
public enum ErrorCategory {


    /**
     * Diese Meldung dient nur zur Information
     * 
     */
    INFO,
    WARNING,
    ERROR,
    FATAL,

    /**
     * Diese Meldung ist im Rahmen einer Konfiguration aufgetreten
     * 
     */
    CONFIG;

    public String value() {
        return name();
    }

    public static ErrorCategory fromValue(String v) {
        return valueOf(v);
    }

}
