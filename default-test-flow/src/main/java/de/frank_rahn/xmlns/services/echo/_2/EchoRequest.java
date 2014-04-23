
package de.frank_rahn.xmlns.services.echo._2;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;
import org.w3._2001.xmlschema.Adapter2;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="input" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="numberOfReplay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="reverse" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "input",
    "currentDate",
    "numberOfReplay",
    "reverse"
})
@XmlRootElement(name = "echoRequest")
public class EchoRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String input;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Calendar currentDate;
    protected Integer numberOfReplay;
    @XmlElement(defaultValue = "false")
    protected boolean reverse;

    /**
     * Ruft den Wert der input-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInput() {
        return input;
    }

    /**
     * Legt den Wert der input-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInput(String value) {
        this.input = value;
    }

    /**
     * Ruft den Wert der currentDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getCurrentDate() {
        return currentDate;
    }

    /**
     * Legt den Wert der currentDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentDate(Calendar value) {
        this.currentDate = value;
    }

    /**
     * Ruft den Wert der numberOfReplay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfReplay() {
        return numberOfReplay;
    }

    /**
     * Legt den Wert der numberOfReplay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfReplay(Integer value) {
        this.numberOfReplay = value;
    }

    /**
     * Ruft den Wert der reverse-Eigenschaft ab.
     * 
     */
    public boolean isReverse() {
        return reverse;
    }

    /**
     * Legt den Wert der reverse-Eigenschaft fest.
     * 
     */
    public void setReverse(boolean value) {
        this.reverse = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

    public EchoRequest withInput(String value) {
        setInput(value);
        return this;
    }

    public EchoRequest withCurrentDate(Calendar value) {
        setCurrentDate(value);
        return this;
    }

    public EchoRequest withNumberOfReplay(Integer value) {
        setNumberOfReplay(value);
        return this;
    }

    public EchoRequest withReverse(boolean value) {
        setReverse(value);
        return this;
    }

}
