package de.rahn.mule.transformer;

import static org.mule.transformer.types.DataTypeFactory.create;

import org.mule.api.transformer.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import de.frank_rahn.xmlns.services.echo._1.EchoResponse;
import de.frank_rahn.xmlns.services.echo._2.ObjectFactory;

/**
 * Ein {@link Transformer}, der den {@link EchoResponse} aus der Version 1.1 in
 * die Version 2.0 konvertiert.
 * 
 * @author Frank Rahn
 */
public class ResponseTransformer extends AbstractTransformer {

	private static final ObjectFactory FACTORY = new ObjectFactory();

	/**
	 * Konstruktor.
	 */
	public ResponseTransformer() {
		super();

		registerSourceType(create(EchoResponse.class));
		setReturnDataType(DataTypeFactory
				.create(de.frank_rahn.xmlns.services.echo._2.EchoResponse.class));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		EchoResponse response = (EchoResponse) src;
		
		logger.info("Transform EchoResponse!");

		return FACTORY.createEchoResponse().withOutput(response.getOutput())
				.withCurrentDate(response.getCurrentDate());
	}

}