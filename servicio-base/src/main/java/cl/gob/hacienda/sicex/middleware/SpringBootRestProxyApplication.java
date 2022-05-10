package cl.gob.hacienda.sicex.middleware;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import cl.gob.hacienda.sicex.middleware.procesadores.ProcesadorJMSAttributes;

@SpringBootApplication
@ImportResource({"classpath:/spring-camel-context.xml"})
public class SpringBootRestProxyApplication {

	private static final Logger logger = Logger.getLogger(ProcesadorJMSAttributes.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProxyApplication.class, args);
		logger.info("Entono Spring Boot Inicializado correctamente");
	}
}