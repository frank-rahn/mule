
package de.frank_rahn.xmlns.types.error._1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * Eine Fehlermeldung.
 * 
 * <p>Java-Klasse für errorMessage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="errorMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCategory" type="{http://xmlns.frank-rahn.de/types/error/1.0}errorCategory"/>
 *         &lt;element name="errorText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorMessage", propOrder = {
    "errorCategory",
    "errorText",
    "errorNumber"
})
public class ErrorMessage
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true, defaultValue = "ERROR")
    protected ErrorCategory errorCategory;
    @XmlElement(required = true)
    protected String errorText;
    protected Integer errorNumber;

    /**
     * Ruft den Wert der errorCategory-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ErrorCategory }
     *     
     */
    public ErrorCategory getErrorCategory() {
        return errorCategory;
    }

    /**
     * Legt den Wert der errorCategory-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorCategory }
     *     
     */
    public void setErrorCategory(ErrorCategory value) {
        this.errorCategory = value;
    }

    /**
     * Ruft den Wert der errorText-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     * Legt den Wert der errorText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorText(String value) {
        this.errorText = value;
    }

    /**
     * Ruft den Wert der errorNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorNumber() {
        return errorNumber;
    }

    /**
     * Legt den Wert der errorNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorNumber(Integer value) {
        this.errorNumber = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
    }

    public ErrorMessage withErrorCategory(ErrorCategory value) {
        setErrorCategory(value);
        return this;
    }

    public ErrorMessage withErrorText(String value) {
        setErrorText(value);
        return this;
    }

    public ErrorMessage withErrorNumber(Integer value) {
        setErrorNumber(value);
        return this;
    }

}
