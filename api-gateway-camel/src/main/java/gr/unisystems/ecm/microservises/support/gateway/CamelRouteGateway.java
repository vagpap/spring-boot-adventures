package gr.unisystems.ecm.microservises.support.gateway;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.remote.ConsulConfigurationDefinition;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelRouteGateway extends RouteBuilder {

	@Autowired
	CamelContext context;

	@Value("${server.port}")
	private int serverPort;
	
	@Value("${spring.cloud.consul.protocol}")
	private String consulProtocol;
	
	@Value("${spring.cloud.consul.host}")
	private String consulHost;
	
	@Value("${spring.cloud.consul.port}")
	private int consulPort;
	
	@Override
	public void configure() throws Exception {
		
		ConsulConfigurationDefinition config = new ConsulConfigurationDefinition();
		config.setComponent("netty4-http");
		config.setUrl(consulProtocol + "://" + consulHost + ":" + consulPort);
		context.setServiceCallConfiguration(config);

		restConfiguration().component("netty4-http").bindingMode(RestBindingMode.json).port(serverPort);
		// Product Service routing
		from("rest:get:product:/{id}")
			.setHeader("Custom-callID", simple("custom header value"))
				.serviceCall("product-service");

		// Review service routing
		from("rest:get:review:/{productId}")
			.setHeader("Custom-callID", simple("custom header value"))
				.serviceCall("review-service");

	}

}
