
package de.frank_rahn.xmlns.types.cixs.cbk010.output._1;

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
 *         &lt;element name="result" type="{http://xmlns.frank-rahn.de/types/cixs/cbk010/output/1.0}Result"/>
 *         &lt;element name="ausgabe" type="{http://xmlns.frank-rahn.de/types/cixs/cbk010/output/1.0}Ausgabe"/>
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
    "result",
    "ausgabe"
})
public class Dfhcommarea
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "RESULT", type = CobolType.GROUP_ITEM, levelNumber = 5, srceLine = 2)
    protected Result result;
    @XmlElement(required = true)
    @CobolElement(cobolName = "AUSGABE", type = CobolType.GROUP_ITEM, levelNumber = 5, srceLine = 6)
    protected Ausgabe ausgabe;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setResult(Result value) {
        this.result = value;
    }

    public boolean isSetResult() {
        return (this.result!= null);
    }

    /**
     * Gets the value of the ausgabe property.
     * 
     * @return
     *     possible object is
     *     {@link Ausgabe }
     *     
     */
    public Ausgabe getAusgabe() {
        return ausgabe;
    }

    /**
     * Sets the value of the ausgabe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ausgabe }
     *     
     */
    public void setAusgabe(Ausgabe value) {
        this.ausgabe = value;
    }

    public boolean isSetAusgabe() {
        return (this.ausgabe!= null);
    }

}
