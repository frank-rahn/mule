package de.rahn.legstar.cixs.bk010;

import static org.mule.transformer.types.DataTypeFactory.create;

import org.mule.api.transformer.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import de.frank_rahn.xmlns.services.bic._1.BicRequest;
import de.frank_rahn.xmlns.types.cixs.cbk010.input._1.Bank;
import de.frank_rahn.xmlns.types.cixs.cbk010.input._1.Dfhcommarea;
import de.frank_rahn.xmlns.types.cixs.cbk010.input._1.Eingabe;
import de.frank_rahn.xmlns.types.cixs.cbk010.input._1.ObjectFactory;

/**
 * Der {@link Transformer} wandelt den eingehenden {@link BicRequest} in die
 * Eingabe Copystrecke {@link Dfhcommarea}.
 * 
 * @author Frank Rahn
 */
public class PBK010JavaToWebserviceTransformer extends AbstractTransformer {
	
	private static final ObjectFactory FACTORY = new ObjectFactory();
	
	/**
	 * Konstruktor.
	 */
	public PBK010JavaToWebserviceTransformer() {
		registerSourceType(create(BicRequest.class));
		setReturnDataType(create(Dfhcommarea.class));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		BicRequest request = (BicRequest) src;
		
		// Elemente der Copystrecke erzeugen und füllen
		Bank bank = FACTORY.createBank();
		bank.setName(request.getName());
		bank.setBlz(request.getBlz());
		bank.setOrt(request.getOrt());
		
		Eingabe eingabe = FACTORY.createEingabe();
		eingabe.setBank(bank);
		
		de.frank_rahn.xmlns.types.cixs.cbk010.input._1.System system = FACTORY.createSystem();
		system.setProg("PBK010");
		
		Dfhcommarea dfhcommarea = FACTORY.createDfhcommarea();
		dfhcommarea.setSystem(system);
		dfhcommarea.setEingabe(eingabe);
		return dfhcommarea;
	}

}