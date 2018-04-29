package gr.unisystems.ecm.microservises.support.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelGatewayApplication {

	private static final Logger logger = LoggerFactory.getLogger(CamelGatewayApplication.class);

	public static void main(String[] args) {
        SpringApplication.run(CamelGatewayApplication.class, args);
        if (logger.isInfoEnabled()) {
        	logger.info("CamelGatewayApplication started");
        }
    }
}
