
package de.frank_rahn.xmlns.types.cixs.cbk010.output._1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.legstar.coxb.CobolElement;
import com.legstar.coxb.CobolType;


/**
 * <p>Java class for Ausgabe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ausgabe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bank" type="{http://xmlns.frank-rahn.de/types/cixs/cbk010/output/1.0}Bank" maxOccurs="15" minOccurs="15"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ausgabe", propOrder = {
    "bank"
})
public class Ausgabe
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @CobolElement(cobolName = "BANK", type = CobolType.GROUP_ITEM, levelNumber = 7, minOccurs = 15, maxOccurs = 15, srceLine = 7)
    protected List<Bank> bank;

    /**
     * Gets the value of the bank property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bank property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBank().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bank }
     * 
     * 
     */
    public List<Bank> getBank() {
        if (bank == null) {
            bank = new ArrayList<Bank>();
        }
        return this.bank;
    }

    public boolean isSetBank() {
        return ((this.bank!= null)&&(!this.bank.isEmpty()));
    }

    public void unsetBank() {
        this.bank = null;
    }

}
