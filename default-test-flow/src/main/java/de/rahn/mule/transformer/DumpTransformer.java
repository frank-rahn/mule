package de.rahn.mule.transformer;

import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;
import static org.apache.cxf.jaxb.JAXBToStringStyle.DEFAULT_STYLE;

import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

/**
 * Ein {@link Transformer}, der die wichtigsten Daten aus der
 * {@link MuleMessage} ausgibt.
 * 
 * @author Frank Rahn
 */
public class DumpTransformer extends AbstractMessageTransformer {

	/**
	 * {@inheritDoc}
	 * 
	 * @see AbstractMessageTransformer#transform(Object, MuleEvent)
	 */
	@Override
	public Object transform(Object src, MuleEvent event)
			throws TransformerMessagingException {
		Object o = super.transform(src, event);

		MuleMessage message = event.getMessage();

		StringBuilder dump = new StringBuilder("\nFlow:\t")
				.append(event.getFlowConstruct().getName())
				.append("\nDumper:\t").append(getName()).append("\nPL:\t")
				.append(message.getPayload()).append("\nO-PL:\t")
				.append(message.getOriginalPayload()).append("\nEx-PL:\t")
				.append(reflectionToString(message.getExceptionPayload(), DEFAULT_STYLE))
				.append("\nProperties aus der Message:");

		for (PropertyScope scope : PropertyScope.ALL_SCOPES) {
			try {
				for (String name : message.getPropertyNames(scope)) {
					dump.append("\n\t").append(scope.getScopeName())
							.append("-->Name=").append(name).append(", value=")
							.append(message.getProperty(name, scope));
				}
			} catch (IllegalArgumentException e) {
				dump.append("\n\t").append(scope.getScopeName()).append("-->")
						.append(e.getMessage());
			}
		}

		logger.info(dump.toString());

		return o;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see AbstractMessageTransformer#transformMessage(MuleMessage, String)
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		return message.getPayload();
	}

}