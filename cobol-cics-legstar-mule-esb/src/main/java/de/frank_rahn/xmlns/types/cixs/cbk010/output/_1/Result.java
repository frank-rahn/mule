
package de.frank_rahn.xmlns.types.cixs.cbk010.output._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fehlercode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fehlertext">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="72"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sqlcode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="5"/>
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
@XmlType(name = "Result", propOrder = {
    "fehlercode",
    "fehlertext",
    "sqlcode"
})
public class Result
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "FEHLERCODE", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 10, picture = "X(02)", srceLine = 3)
    protected String fehlercode;
    @XmlElement(required = true)
    @CobolElement(cobolName = "FEHLERTEXT", type = CobolType.ALPHANUMERIC_ITEM, levelNumber = 10, picture = "X(72)", srceLine = 4)
    protected String fehlertext;
    @CobolElement(cobolName = "SQLCODE", type = CobolType.BINARY_ITEM, levelNumber = 10, isSigned = true, totalDigits = 5, picture = "S9(5)", usage = "BINARY", srceLine = 5)
    protected int sqlcode;

    /**
     * Gets the value of the fehlercode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFehlercode() {
        return fehlercode;
    }

    /**
     * Sets the value of the fehlercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFehlercode(String value) {
        this.fehlercode = value;
    }

    public boolean isSetFehlercode() {
        return (this.fehlercode!= null);
    }

    /**
     * Gets the value of the fehlertext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFehlertext() {
        return fehlertext;
    }

    /**
     * Sets the value of the fehlertext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFehlertext(String value) {
        this.fehlertext = value;
    }

    public boolean isSetFehlertext() {
        return (this.fehlertext!= null);
    }

    /**
     * Gets the value of the sqlcode property.
     * 
     */
    public int getSqlcode() {
        return sqlcode;
    }

    /**
     * Sets the value of the sqlcode property.
     * 
     */
    public void setSqlcode(int value) {
        this.sqlcode = value;
    }

    public boolean isSetSqlcode() {
        return true;
    }

}
