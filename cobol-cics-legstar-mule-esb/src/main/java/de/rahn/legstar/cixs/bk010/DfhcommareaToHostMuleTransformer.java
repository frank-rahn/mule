package de.rahn.legstar.cixs.bk010;
import org.mule.transformer.types.SimpleDataType;
import org.mule.transport.legstar.transformer.AbstractJavaToHostMuleTransformer;
import de.frank_rahn.xmlns.types.cixs.cbk010.output._1.Dfhcommarea;
import de.frank_rahn.xmlns.types.cixs.cbk010.output._1.bind.DfhcommareaTransformers;

/**
 * Dfhcommarea to Host Byte Array Mule Transformer.
 * <p/>
 * <code>DfhcommareaToHostMuleTransformer</code> takes a Dfhcommarea object as input
 * and turns it into a byte array in host format (EBCDIC), ready
 * to be sent to a target Mainframe.
 * <p/> 
 * Class generated by LegStar Mule Component generator.
 */
public class DfhcommareaToHostMuleTransformer extends AbstractJavaToHostMuleTransformer {

    /**
     * Constructs the transformer. Source is a Dfhcommarea object and result
     * will be a byte array.
     */
    public DfhcommareaToHostMuleTransformer() {
        super(new DfhcommareaTransformers());
        registerSourceType(new SimpleDataType<Object>(Dfhcommarea.class));
    }


}