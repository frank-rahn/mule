package de.rahn.mule.interceptor;

import static org.apache.cxf.phase.Phase.MARSHAL;

import javax.xml.bind.JAXB;
import javax.xml.transform.dom.DOMResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.w3c.dom.Document;

import de.frank_rahn.xmlns.ws.echo._1_1.EchoFault;

/**
 * Ein {@link Interceptor} zur Konvertierung der Fehlermeldung im {@link Fault}.
 * 
 * @author Frank Rahn
 */
public class ResponseFaultOutInterceptor extends AbstractSoapInterceptor {

	private static final Log LOGGER = LogFactory
			.getLog(ResponseFaultOutInterceptor.class);

	/**
	 * Konstruktor.
	 */
	public ResponseFaultOutInterceptor() {
		super(MARSHAL);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Fault exceptionFault = (Fault) message.getContent(Exception.class);

		if (exceptionFault == null) {
			LOGGER.info("Nothing to do.");
			return;
		}
		Throwable originalCause = getOriginalCause(exceptionFault);

		LOGGER.info("\nFault: " + exceptionFault + "\nOriginalCause: "
				+ originalCause);

		if (originalCause instanceof EchoFault) {
			EchoFault echoFault = (EchoFault) originalCause;

			Fault fault = new Fault(
					new de.frank_rahn.xmlns.ws.echo._2_0.EchoFault(
							echoFault.getMessage(), echoFault.getFaultInfo()));
			DOMResult result = new DOMResult();
			JAXB.marshal(echoFault.getFaultInfo(), result);
			fault.setDetail(((Document) result.getNode()).getDocumentElement());

			message.setContent(Exception.class, fault);

			LOGGER.info("Neu Fault set");
		}
	}

	/**
	 * @param currentException
	 *            die aktuelle Exception
	 * @return die ursächliche Exception
	 */
	private Throwable getOriginalCause(Throwable currentException) {
		Throwable cause = currentException.getCause();
		if (cause == null || cause.equals(currentException)) {
			return currentException;
		}

		return getOriginalCause(cause);
	}

}