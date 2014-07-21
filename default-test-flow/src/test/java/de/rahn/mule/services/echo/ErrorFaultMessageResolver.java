package de.rahn.mule.services.echo;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;
import javax.xml.transform.dom.DOMSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.FaultMessageResolver;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.client.core.SoapFaultMessageResolver;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.frank_rahn.xmlns.types.error._1.ErrorFault;

/**
 * Ein {@link FaultMessageResolver} für das {@link WebServiceTemplate}.
 * 
 * @author Frank Rahn
 */
public class ErrorFaultMessageResolver extends SoapFaultMessageResolver {

	private static final Log LOG = LogFactory
			.getLog(ErrorFaultMessageResolver.class);

	/**
	 * @see FaultMessageResolver#resolveFault(WebServiceMessage)
	 */
	@Override
	public void resolveFault(WebServiceMessage message) throws IOException {
		if (message instanceof SoapMessage) {
			SoapMessage soapMessage = (SoapMessage) message;

			SoapFault soapFault = soapMessage.getSoapBody().getFault();
			if (soapFault.getFaultDetail() != null) {
				StringBuilder out = new StringBuilder("SoapFaultDetail: ")
						.append(soapFault.getFaultDetail().getName().toString());

				Iterator<SoapFaultDetailElement> iter = soapFault
						.getFaultDetail().getDetailEntries();
				while (iter.hasNext()) {
					out.append("\n\tSoapFaultDetailElement: ").append(
							iter.next().getName().toString());
				}
				LOG.info(out.toString());

				DOMSource source = (DOMSource) soapFault.getFaultDetail()
						.getSource();
				if (source != null) {
					try {
						source = findErrorFault(source);

						ErrorFault errorFault = JAXB.unmarshal(source,
								ErrorFault.class);
						throw new ErrorFaultException(
								soapFault.getFaultStringOrReason(), errorFault);
					} catch (DataBindingException exception) {
						LOG.error(
								"Die Fault-Details konnten nicht ausgewertet werden",
								exception);
					}
				}
			}
		}

		super.resolveFault(message);
	}

	private DOMSource findErrorFault(DOMSource source) {
		NodeList childs = source.getNode().getChildNodes();

		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);

			if ("echoFault".equals(child.getLocalName())) {
				return new DOMSource(child);
			}
		}

		return source;
	}

}