package gr.unisystems.ecm.microservices.core.product.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.unisystems.ecm.microservices.core.product.model.Product;

@RestController
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	Environment environment;

    @RequestMapping("/product/{productId}")
    public Product getProduct(@PathVariable int productId, HttpServletRequest request) {
    	logger.info("GetProduct called with ID:" + productId);
        return new Product(productId, "Product~" + productId, 123, Integer.parseInt(environment.getProperty("local.server.port")), request.getHeader("Custom-callID"));
    }
}
