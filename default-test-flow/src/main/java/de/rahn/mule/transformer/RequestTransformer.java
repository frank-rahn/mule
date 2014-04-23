package de.rahn.mule.transformer;

import static org.mule.transformer.types.DataTypeFactory.create;

import org.mule.api.transformer.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import de.frank_rahn.xmlns.services.echo._1.ObjectFactory;
import de.frank_rahn.xmlns.services.echo._2.EchoRequest;

/**
 * Ein {@link Transformer}, der den {@link EchoRequest} aus der version 2.0 in
 * die Version 1.1 konvertiert.
 * 
 * @author Frank Rahn
 */
public class RequestTransformer extends AbstractTransformer {

	private static final ObjectFactory FACTORY = new ObjectFactory();

	/**
	 * Konstruktor.
	 */
	public RequestTransformer() {
		super();

		registerSourceType(create(EchoRequest.class));
		setReturnDataType(DataTypeFactory
				.create(de.frank_rahn.xmlns.services.echo._1.EchoRequest.class));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		EchoRequest request = (EchoRequest) src;

		logger.info("Transform EchoRequest! Remove CurrentDate="
				+ request.getCurrentDate());

		return FACTORY.createEchoRequest().withInput(request.getInput());
	}

}