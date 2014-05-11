package de.frank_rahn.xmlns.types.error;

import de.frank_rahn.xmlns.types.error._1.ErrorFault;
import de.frank_rahn.xmlns.types.error._1.ErrorMessage;
import de.frank_rahn.xmlns.types.error._1.ObjectFactory;

/**
 * Eine Utility-Klasse für das Erzeugen von {@link ErrorFault}s.
 * 
 * @author Frank Rahn
 */
public class ErrorUtils {

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