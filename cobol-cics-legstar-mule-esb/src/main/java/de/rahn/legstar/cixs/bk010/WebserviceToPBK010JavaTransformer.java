package de.rahn.legstar.cixs.bk010;

import static de.frank_rahn.xmlns.types.ErrorUtils.ERROR_FACTORY;
import static de.frank_rahn.xmlns.types.error._1.ErrorCategory.ERROR;
import static java.lang.Long.valueOf;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.mule.transformer.types.DataTypeFactory.create;

import java.util.List;

import org.mule.api.transformer.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import de.frank_rahn.xmlns.services.bic._1.BicResponse;
import de.frank_rahn.xmlns.services.bic._1.ObjectFactory;
import de.frank_rahn.xmlns.types.cixs.cbk010.output._1.Bank;
import de.frank_rahn.xmlns.types.cixs.cbk010.output._1.Dfhcommarea;
import de.frank_rahn.xmlns.types.cixs.cbk010.output._1.Result;
import de.frank_rahn.xmlns.types.error._1.ErrorFault;

/**
 * Der {@link Transformer} wandelt die Ausgabe Copystrecke {@link Dfhcommarea}
 * in die ausgehende {@link BicResponse}.
 * 
 * @author Frank Rahn
 */
public class WebserviceToPBK010JavaTransformer extends AbstractTransformer {

	private static final ObjectFactory FACTORY = new ObjectFactory();

	/**
	 * Konstruktor.
	 */
	public WebserviceToPBK010JavaTransformer() {
		registerSourceType(create(Dfhcommarea.class));
		setReturnDataType(create(BicResponse.class));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		Dfhcommarea dfhcommarea = (Dfhcommarea) src;

		// Elemente des Webservices erzeugen
		BicResponse response = FACTORY.createBicResponse();

		// Fehler aufgetreten?
		if (isNotEmpty(dfhcommarea.getResult().getFehlercode())) {
			response.setError(createErrorFault(dfhcommarea.getResult()));
		}

		// Ergebnisse da?
		if (!dfhcommarea.getAusgabe().getBank().isEmpty()) {
			createBanken(dfhcommarea.getAusgabe().getBank(), response);
		}

		return response;
	}

	private void createBanken(List<Bank> banks, BicResponse response) {
		for (Bank bank : banks) {
			response.withBanken(FACTORY.createBank().withName(bank.getName())
					.withBlz(bank.getBlz()).withBic(bank.getBic())
					.withOrt(bank.getOrt()).withPlz(bank.getPlz()));
		}
	}

	private ErrorFault createErrorFault(Result result) {
		return ERROR_FACTORY
				.createErrorFault()
				.withId(valueOf(result.getFehlercode()))
				.withMessages(
						ERROR_FACTORY.createErrorMessage()
								.withErrorCategory(ERROR)
								.withErrorText(result.getFehlertext())
								.withErrorNumber(result.getSqlcode()));
	}

}