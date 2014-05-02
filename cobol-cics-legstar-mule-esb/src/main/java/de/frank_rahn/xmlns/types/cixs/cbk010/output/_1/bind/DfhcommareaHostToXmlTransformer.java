package de.frank_rahn.xmlns.types.cixs.cbk010.output._1.bind;

import com.legstar.coxb.CobolContext;
import com.legstar.coxb.transform.AbstractHostToXmlTransformer;
import com.legstar.coxb.transform.HostTransformException;

/**
 * Transforms mainframe data to XML.
 * <p/>
 * This is a typical use of this class:
 * <pre>
 *  DfhcommareaHostToXmlTransformer transformer = new DfhcommareaHostToXmlTransformer();
 *  StringWriter writer = new StringWriter();
 *  transformer.transform(hostByteArray, writer);
 * </pre>
 *
 */
public class DfhcommareaHostToXmlTransformer extends AbstractHostToXmlTransformer {

    /**
     * Create a Host to XML transformer using a Host to Java transformer.
     * @throws HostTransformException if transformer cannot be created
     */
    public DfhcommareaHostToXmlTransformer() throws HostTransformException {
        super(new DfhcommareaHostToJavaTransformer());
    }
    
    /**
     * Create a Host to XML transformer using a specific COBOL parameters set.
     * @param cobolContext the COBOL parameters set.
     * @throws HostTransformException if transformer cannot be created
     */
    public DfhcommareaHostToXmlTransformer(
            final CobolContext cobolContext) throws HostTransformException {
        super(new DfhcommareaHostToJavaTransformer(cobolContext));
    }

    /**
     * Create a Host to XML transformer using a specific host character set while
     * other COBOL parameters are set by default.
     * @param hostCharset the host character set
     * @throws HostTransformException if transformer cannot be created
     */
    public DfhcommareaHostToXmlTransformer(
            final String hostCharset) throws HostTransformException {
        super(new DfhcommareaHostToJavaTransformer(hostCharset));
    }
    
    /** {@inheritDoc} */
    public String getElementName() {
        return "Dfhcommarea";
    }

    /** {@inheritDoc} */
    public String getNamespace() {
        return "http://xmlns.frank-rahn.de/types/cixs/cbk010/output/1.0";
    }

    /** {@inheritDoc} */
    public boolean isXmlRootElement() {
        return false;
    }
    
}
