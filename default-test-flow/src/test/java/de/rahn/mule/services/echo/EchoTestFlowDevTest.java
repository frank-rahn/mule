package de.rahn.mule.services.echo;

import static com.sun.xml.internal.ws.developer.JAXWSProperties.CONNECT_TIMEOUT;
import static com.sun.xml.internal.ws.developer.JAXWSProperties.REQUEST_TIMEOUT;
import static de.frank_rahn.xmlns.types.error._1.ErrorCategory.ERROR;
import static javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mule.api.config.MuleProperties.SYSTEM_PROPERTY_PREFIX;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.SystemProperty;

import de.frank_rahn.xmlns.services.echo._1.EchoRequest;
import de.frank_rahn.xmlns.services.echo._1.EchoResponse;
import de.frank_rahn.xmlns.services.echo._1.ObjectFactory;
import de.frank_rahn.xmlns.types.error._1.ErrorFault;
import de.frank_rahn.xmlns.types.error._1.ErrorMessage;
import de.frank_rahn.xmlns.ws.echo._1_1.EchoFault;
import de.frank_rahn.xmlns.ws.echo._1_1.EchoService;
import de.frank_rahn.xmlns.ws.echo._1_1.EchoService_Service;

/**
 * Tests für den Flow: EchoTestFlow
 * 
 * @author Frank Rahn
 */
public class EchoTestFlowDevTest extends FunctionalTestCase {

	private static final String ENDPOINT_URL = "http://localhost:8081/echo";
	private static final ObjectFactory FACTORY = new ObjectFactory();

	private static final String INPUT_1 = "Hallo Mule!";
	private static final String ECHO = "Echo: ";
	private static final String FAULTINFO_MSG = "Die Eingabe war leer";
	private static final String FAULT_MSG = "Keine Eingabe vorhanden";

	private EchoService echoService;
	
	/**
	 * Timeouts ausschalten.
	 */
	@Rule
	public SystemProperty disableTimeouts = new SystemProperty(SYSTEM_PROPERTY_PREFIX + "timeout.disable", "true");

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getConfigResources() {
		return "src/main/app/default-test-flow.xml";
	}

	/**
	 * Test initialisieren.
	 */
	@Before
	public void setUp() {
		// JAXWS Endpoint erzeugen
		echoService = new EchoService_Service().getEchoServiceSoap();
		Map<String, Object> requestContext = ((BindingProvider) echoService)
				.getRequestContext();

		// Neue URL setzen
		requestContext.put(ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_URL);
		
		// Timeout aussetzen
		requestContext.put(CONNECT_TIMEOUT, -1);
		requestContext.put(REQUEST_TIMEOUT, -1);
	}

	/**
	 * Ein Test, der keinen Fehler produziert.
	 */
	@Test
	public void echo11_01_AufrufOhneFehler() {
		EchoRequest request = FACTORY.createEchoRequest().withInput(INPUT_1);

		EchoResponse response;
		try {
			response = echoService.echo(request);
		} catch (EchoFault fault) {
			fail("Die EchoFault darf nicht geworfen werden. msg="
					+ fault.getMessage() + ", error=" + fault.getFaultInfo());
			return;
		}

		assertThat(response, notNullValue());
		assertThat(response.getOutput(), notNullValue());
		assertThat(response.getOutput(), is(ECHO + INPUT_1));
		assertThat(response.getCurrentDate(), notNullValue());
	}

	/**
	 * Ein Test, der einen Fehler produziert.
	 */
	@Test
	public void echo11_02_AufrufMitFehler() {
		EchoRequest request = FACTORY.createEchoRequest().withInput("");

		try {
			echoService.echo(request);
			fail("Es sollte eine Exception geworfen werden");
		} catch (EchoFault fault) {
			assertThat(fault.getMessage(), is(FAULT_MSG));

			ErrorFault info = fault.getFaultInfo();

			assertThat(info, notNullValue());
			assertThat(info.getId(), is(4711L));
			assertThat(info.getMessages(), notNullValue());
			assertThat(info.getMessages().size(), is(1));

			ErrorMessage msg = info.getMessages().get(0);
			assertThat(msg, notNullValue());
			assertThat(msg.getErrorNumber(), is(1));
			assertThat(msg.getErrorCategory(), is(ERROR));
			assertThat(msg.getErrorText(), is(FAULTINFO_MSG));
		}
	}

}