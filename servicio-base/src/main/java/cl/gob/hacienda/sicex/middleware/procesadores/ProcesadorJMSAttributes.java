package cl.gob.hacienda.sicex.middleware.procesadores;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**

 * Clase que permite el setting de atributos particulares y customizado para el reencolamiento de mensajes
 * basado en situaciones de excepción controladas para desconexiones backend
 * @author: Red HAt
 * @version: 22/11/2020
 */
public class ProcesadorJMSAttributes implements Processor{

	private static final long EXPIRATION_TIME = 10000;
	
	@Override
	public void process(Exchange exchange)  {
		long JMSTimestamp = (Long) exchange.getIn().getHeader("JMSTimestamp");
		long JMSExpiration = (Long) exchange.getIn().getHeader("JMSExpiration");
		String JMSMessageID = (String) exchange.getIn().getHeader("JMSMessageID");
		
		if (JMSExpiration == 0) {
			exchange.getIn().setHeader("JMSExpiration", JMSTimestamp +EXPIRATION_TIME);
			exchange.getIn().setHeader("OriginIdMessage", JMSMessageID);	
		}
			
		exchange.getIn().setHeader("JMSPriority", 1);
	}
}
