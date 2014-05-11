package de.rahn.mule.component;

import static de.frank_rahn.xmlns.types.error.ErrorHelper.createErrorFault;
import static de.frank_rahn.xmlns.types.error.ErrorHelper.createErrorMessage;
import static de.frank_rahn.xmlns.types.error._1.ErrorCategory.ERROR;
import static java.util.Calendar.getInstance;
import static java.util.Locale.GERMANY;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.frank_rahn.xmlns.services.echo._1.EchoRequest;
import de.frank_rahn.xmlns.services.echo._1.EchoResponse;
import de.frank_rahn.xmlns.services.echo._1.ObjectFactory;
import de.frank_rahn.xmlns.ws.echo._1_1.EchoFault;
import de.frank_rahn.xmlns.ws.echo._1_1.EchoService;

/**
 * Die JAX-WS Implementierung des Echo-Services v1.1.
 * 
 * @author Fank Rahn
 */
public class EchoServiceV11Component implements EchoService {
	
	private static final Log LOGGER = LogFactory.getLog(EchoServiceV11Component.class);

	private static final ObjectFactory FACTORY = new ObjectFactory();

	/**
	 * @see EchoService#echo(EchoRequest)
	 */
	@Override
	public EchoResponse echo(EchoRequest echoRequest) throws EchoFault {
		LOGGER.info("EchoRequest receive! echoRequest=" + echoRequest);
		
		if (StringUtils.isBlank(echoRequest.getInput())) {
			final EchoFault echoFault = new EchoFault("Keine Eingabe vorhanden", createErrorFault()
					.withId(4711).withMessages(
							createErrorMessage().withErrorNumber(1)
									.withErrorCategory(ERROR)
									.withErrorText("Die Eingabe war leer")));
			LOGGER.info("EchoFault throw! echoFault=" + echoFault);
			throw echoFault;
		}

		final EchoResponse echoResponse= FACTORY.createEchoResponse()
				.withCurrentDate(getInstance(GERMANY))
				.withOutput("Echo: " + echoRequest.getInput());
		LOGGER.info("EchoResponse send! echoResponse=" + echoResponse);
		return echoResponse;
	}

}