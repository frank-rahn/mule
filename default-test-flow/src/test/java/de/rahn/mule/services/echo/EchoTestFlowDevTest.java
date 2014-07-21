package de.rahn.mule.services.echo;

import static de.frank_rahn.xmlns.types.error._1.ErrorCategory.ERROR;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mule.api.config.MuleProperties.SYSTEM_PROPERTY_PREFIX;

import org.junit.Rule;
import org.junit.Test;
import org.mule.api.registry.RegistrationException;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.SystemProperty;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.frank_rahn.xmlns.services.echo._1.EchoRequest;
import de.frank_rahn.xmlns.services.echo._1.EchoResponse;
import de.frank_rahn.xmlns.services.echo._1.ObjectFactory;
import de.frank_rahn.xmlns.types.error._1.ErrorFault;
import de.frank_rahn.xmlns.types.error._1.ErrorMessage;

/**
 * Tests für den Flow: EchoTestFlow
 * 
 * @author Frank Rahn
 */
public class EchoTestFlowDevTest extends FunctionalTestCase {

	private static final ObjectFactory FACTORY = new ObjectFactory();

	private static final String INPUT_1 = "Hallo Mule!";
	private static final String ECHO = "Echo: ";
	private static final String FAULTINFO_MSG = "Die Eingabe war leer";
	private static final String FAULT_MSG = "Keine Eingabe vorhanden";

	/**
	 * Timeouts ausschalten.
	 */
	@Rule
	public SystemProperty disableTimeouts = new SystemProperty(
			SYSTEM_PROPERTY_PREFIX + "timeout.disable", "true");

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getConfigResources() {
		return "EchoTestFlowDevTest-config.xml,src/main/app/default-test-flow.xml";
	}

	/**
	 * Ein Test, der keinen Fehler produziert.
	 */
	@Test
	public void echo11_01_AufrufOhneFehler() {
		EchoRequest request = FACTORY.createEchoRequest().withInput(INPUT_1);

		EchoResponse response;
		try {
			WebServiceTemplate webServiceTemplate = muleContext.getRegistry()
					.lookupObject(WebServiceTemplate.class);

			response = (EchoResponse) webServiceTemplate
					.marshalSendAndReceive(request);
		} catch (ErrorFaultException e) {
			fail("Die EchoFault darf nicht geworfen werden. msg="
					+ e.getMessage() + ", error=" + e.getFaultInfo());
			return;
		} catch (RegistrationException e) {
			fail("WebServiceTemplate nicht gefunden: " + e);
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
			WebServiceTemplate webServiceTemplate = muleContext.getRegistry()
					.lookupObject(WebServiceTemplate.class);

			webServiceTemplate.marshalSendAndReceive(request);
			fail("Es sollte eine Exception geworfen werden");
		} catch (ErrorFaultException fault) {
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
		} catch (RegistrationException e) {
			fail("WebServiceTemplate nicht gefunden: " + e);
		}
	}

}