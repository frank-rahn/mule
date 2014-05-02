package de.frank_rahn.xmlns.types.cixs.cbk010.input._1.bind;

import com.legstar.coxb.transform.AbstractXmlTransformers;
import com.legstar.coxb.transform.HostTransformException;

/**
 * XML Transformers provider for Dfhcommarea.
 *
 */
public class DfhcommareaXmlTransformers extends AbstractXmlTransformers {

    /**
     * Create a set of directional transformers.
     * @throws HostTransformException if transformer cannot be created
     */
    public DfhcommareaXmlTransformers() throws HostTransformException {
        super(new DfhcommareaXmlToHostTransformer(),
                new DfhcommareaHostToXmlTransformer());
    }

}
