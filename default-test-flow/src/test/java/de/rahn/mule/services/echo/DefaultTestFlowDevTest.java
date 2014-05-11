package de.rahn.mule.services.echo;

import static java.util.Calendar.getInstance;
import static java.util.Locale.GERMANY;
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
import org.springframework.ws.soap.client.SoapFaultClientException;

import de.frank_rahn.xmlns.services.echo._2.EchoRequest;
import de.frank_rahn.xmlns.services.echo._2.EchoResponse;
import de.frank_rahn.xmlns.services.echo._2.ObjectFactory;

/**
 * Tests für den Flow: DefaultTestFlow
 * 
 * @author Frank Rahn
 */
public class DefaultTestFlowDevTest extends FunctionalTestCase {

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
		return "DefaultTestFlowDevTest-config.xml,src/main/app/default-test-flow.xml";
	}

	/**
	 * Ein Test, der keinen Fehler produziert.
	 */
	@Test
	public void echo20_01_AufrufOhneFehler() {
		EchoRequest request = FACTORY.createEchoRequest().withInput(INPUT_1)
				.withCurrentDate(getInstance(GERMANY));

		EchoResponse response;
		try {
			WebServiceTemplate webServiceTemplate = muleContext.getRegistry()
					.lookupObject(WebServiceTemplate.class);

			response = (EchoResponse) webServiceTemplate
					.marshalSendAndReceive(request);
		} catch (SoapFaultClientException e) {
			fail("Die EchoFault darf nicht geworfen werden. msg="
					+ e.getFaultStringOrReason() + ", error="
					+ e.getSoapFault().getFaultDetail());
			return;
		} catch (RegistrationException e) {
			fail("WebServiceTemplate nicht gefunden: " + e);
			return;
		}

		assertThat(response, notNullValue());
		assertThat(response.getOutput(), notNullValue());
		assertThat(response.getOutput(), is(ECHO + INPUT_1));
		assertThat(response.getCurrentDate(), notNullValue());
		assertThat(response.getNumberOfReplay(), is(0));
	}

	/**
	 * Ein Test, der einen Fehler produziert.
	 */
	@Test
	public void echo20_02_AufrufMitFehler() {
		EchoRequest request = FACTORY.createEchoRequest().withInput("");

		try {
			WebServiceTemplate webServiceTemplate = muleContext.getRegistry()
					.lookupObject(WebServiceTemplate.class);

			webServiceTemplate.marshalSendAndReceive(request);
			fail("Es sollte eine Exception geworfen werden");
			// } catch (EchoFault fault) {
			// assertThat(fault.getMessage(), is(FAULT_MSG));
			//
			// ErrorFault info = fault.getFaultInfo();
			//
			// assertThat(info, notNullValue());
			// assertThat(info.getId(), is(4711L));
			// assertThat(info.getMessages(), notNullValue());
			// assertThat(info.getMessages().size(), is(1));
			//
			// ErrorMessage msg = info.getMessages().get(0);
			// assertThat(msg, notNullValue());
			// assertThat(msg.getErrorNumber(), is(1));
			// assertThat(msg.getErrorCategory(), is(ERROR));
			// assertThat(msg.getErrorText(), is(FAULTINFO_MSG));
		} catch (SoapFaultClientException e) {
			assertThat(e.getFaultStringOrReason(), is(FAULT_MSG));
			return;
		} catch (RegistrationException e) {
			fail("WebServiceTemplate nicht gefunden: " + e);
			return;
		}
	}

}