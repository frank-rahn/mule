
package de.frank_rahn.xmlns.services.echo._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import de.frank_rahn.xmlns.types.error._1.ErrorFault;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.frank_rahn.xmlns.services.echo._2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EchoFault_QNAME = new QName("http://xmlns.frank-rahn.de/services/echo/2.0", "echoFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.frank_rahn.xmlns.services.echo._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EchoRequest }
     * 
     */
    public EchoRequest createEchoRequest() {
        return new EchoRequest();
    }

    /**
     * Create an instance of {@link EchoResponse }
     * 
     */
    public EchoResponse createEchoResponse() {
        return new EchoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.frank-rahn.de/services/echo/2.0", name = "echoFault")
    public JAXBElement<ErrorFault> createEchoFault(ErrorFault value) {
        return new JAXBElement<ErrorFault>(_EchoFault_QNAME, ErrorFault.class, null, value);
    }

}
