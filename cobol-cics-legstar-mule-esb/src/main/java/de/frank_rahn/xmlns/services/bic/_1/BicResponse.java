
package de.frank_rahn.xmlns.services.bic._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.frank_rahn.xmlns.types.error._1.ErrorFault;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


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
 *         &lt;element name="banken" type="{http://xmlns.frank-rahn.de/services/bic/1.0}bank" maxOccurs="15" minOccurs="0"/>
 *         &lt;element name="error" type="{http://xmlns.frank-rahn.de/types/error/1.0}errorFault"/>
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
    "banken",
    "error"
})
@XmlRootElement(name = "bicResponse")
public class BicResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected List<Bank> banken;
    @XmlElement(required = true)
    protected ErrorFault error;

    /**
     * Gets the value of the banken property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the banken property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBanken().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bank }
     * 
     * 
     */
    public List<Bank> getBanken() {
        if (banken == null) {
            banken = new ArrayList<Bank>();
        }
        return this.banken;
    }

    /**
     * Ruft den Wert der error-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ErrorFault }
     *     
     */
    public ErrorFault getError() {
        return error;
    }

    /**
     * Legt den Wert der error-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorFault }
     *     
     */
    public void setError(ErrorFault value) {
        this.error = value;
    }

    public void setBanken(List<Bank> value) {
        this.banken = null;
        List<Bank> draftl = this.getBanken();
        draftl.addAll(value);
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

    public BicResponse withBanken(Bank... values) {
        if (values!= null) {
            for (Bank value: values) {
                getBanken().add(value);
            }
        }
        return this;
    }

    public BicResponse withBanken(Collection<Bank> values) {
        if (values!= null) {
            getBanken().addAll(values);
        }
        return this;
    }

    public BicResponse withError(ErrorFault value) {
        setError(value);
        return this;
    }

    public BicResponse withBanken(List<Bank> value) {
        setBanken(value);
        return this;
    }

}
