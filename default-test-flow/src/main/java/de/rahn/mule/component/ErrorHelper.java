package de.rahn.mule.component;

import de.frank_rahn.xmlns.types.error._1.ErrorFault;
import de.frank_rahn.xmlns.types.error._1.ErrorMessage;
import de.frank_rahn.xmlns.types.error._1.ObjectFactory;

/**
 * Ein Helfer für die Erzeugung von Fehlermeldungen.
 * 
 * @author Frank Rahn
 */
public class ErrorHelper {

	private static final ObjectFactory FACTORY = new ObjectFactory();

	/**
	 * @return eine {@link ErrorFault}-Message
	 */
	public static ErrorFault createErrorFault() {
		return FACTORY.createErrorFault();
	}

	/**
	 * @return eine {@link ErrorMessage}
	 */
	public static ErrorMessage createErrorMessage() {
		return FACTORY.createErrorMessage();
	}

}