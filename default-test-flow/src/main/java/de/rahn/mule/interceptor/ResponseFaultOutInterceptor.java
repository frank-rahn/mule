package de.rahn.mule.interceptor;

import static org.apache.cxf.phase.Phase.MARSHAL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;

/**
 * Ein {@link Interceptor} zur Konvertierung der Fehlermeldung im {@link Fault}.
 * 
 * @author Frank Rahn
 */
public class ResponseFaultOutInterceptor extends AbstractSoapInterceptor {
	
	private static final Log LOGGER = LogFactory.getLog(ResponseFaultOutInterceptor.class);

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
			// Nichts zu tun dieser Interceptor wurde falsch eingesetzt
			return;
		}

		Throwable originalCause = getOriginalCause(exceptionFault);
		
		LOGGER.info(originalCause);
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