
package de.frank_rahn.xmlns.services.bic._1;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.frank_rahn.xmlns.services.bic._1 package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.frank_rahn.xmlns.services.bic._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BicResponse }
     * 
     */
    public BicResponse createBicResponse() {
        return new BicResponse();
    }

    /**
     * Create an instance of {@link Bank }
     * 
     */
    public Bank createBank() {
        return new Bank();
    }

    /**
     * Create an instance of {@link BicRequest }
     * 
     */
    public BicRequest createBicRequest() {
        return new BicRequest();
    }

}
