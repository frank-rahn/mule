
package de.frank_rahn.xmlns.types.error._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * Der Datentyp für ein Standard-Fault
 * 
 * <p>Java-Klasse für errorFault complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="errorFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="messages" type="{http://xmlns.frank-rahn.de/types/error/1.0}errorMessage" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorFault", propOrder = {
    "id",
    "messages"
})
public class ErrorFault
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected long id;
    @XmlElement(required = true)
    protected List<ErrorMessage> messages;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorMessage }
     * 
     * 
     */
    public List<ErrorMessage> getMessages() {
        if (messages == null) {
            messages = new ArrayList<ErrorMessage>();
        }
        return this.messages;
    }

    public void setMessages(List<ErrorMessage> value) {
        this.messages = null;
        List<ErrorMessage> draftl = this.getMessages();
        draftl.addAll(value);
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

    public ErrorFault withId(long value) {
        setId(value);
        return this;
    }

    public ErrorFault withMessages(ErrorMessage... values) {
        if (values!= null) {
            for (ErrorMessage value: values) {
                getMessages().add(value);
            }
        }
        return this;
    }

    public ErrorFault withMessages(Collection<ErrorMessage> values) {
        if (values!= null) {
            getMessages().addAll(values);
        }
        return this;
    }

    public ErrorFault withMessages(List<ErrorMessage> value) {
        setMessages(value);
        return this;
    }

}
