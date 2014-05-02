
package de.frank_rahn.xmlns.types.cixs.cbk010.input._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for System complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="System">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prog">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "System", propOrder = {
    "prog"
})
public class System
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "PROG", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 10, picture = "X(08)", srceLine = 3)
    protected String prog;

    /**
     * Gets the value of the prog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProg() {
        return prog;
    }

    /**
     * Sets the value of the prog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProg(String value) {
        this.prog = value;
    }

    public boolean isSetProg() {
        return (this.prog!= null);
    }

}
