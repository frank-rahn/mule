
package de.frank_rahn.xmlns.types.cixs.cbk010.input._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for Dfhcommarea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Dfhcommarea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="system" type="{http://xmlns.frank-rahn.de/types/cixs/cbk010/input/1.0}System"/>
 *         &lt;element name="eingabe" type="{http://xmlns.frank-rahn.de/types/cixs/cbk010/input/1.0}Eingabe"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dfhcommarea", propOrder = {
    "system",
    "eingabe"
})
public class Dfhcommarea
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "SYSTEM", type = CobolType.GROUP_ITEM, levelNumber = 5, srceLine = 2)
    protected System system;
    @XmlElement(required = true)
    @CobolElement(cobolName = "EINGABE", type = CobolType.GROUP_ITEM, levelNumber = 5, srceLine = 4)
    protected Eingabe eingabe;

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link System }
     *     
     */
    public System getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link System }
     *     
     */
    public void setSystem(System value) {
        this.system = value;
    }

    public boolean isSetSystem() {
        return (this.system!= null);
    }

    /**
     * Gets the value of the eingabe property.
     * 
     * @return
     *     possible object is
     *     {@link Eingabe }
     *     
     */
    public Eingabe getEingabe() {
        return eingabe;
    }

    /**
     * Sets the value of the eingabe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Eingabe }
     *     
     */
    public void setEingabe(Eingabe value) {
        this.eingabe = value;
    }

    public boolean isSetEingabe() {
        return (this.eingabe!= null);
    }

}
