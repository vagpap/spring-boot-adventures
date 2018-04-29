package gr.unisystems.ecm.microservises.core.review.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.unisystems.ecm.microservises.core.review.model.Review;
import gr.unisystems.ecm.microservises.core.review.service.util.SetProcTimeBean;

@RestController
public class ReviewService {

	private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

	@Autowired
	private SetProcTimeBean setProcTimeBean;
	
	@Autowired
	Environment environment;

	@RequestMapping("/review/{productId}")
	public List<Review> getReviews(@PathVariable int productId, HttpServletRequest request) {

		int pt = setProcTimeBean.calculateProcessingTime();
		logger.info("/reviews called, processing time: {}", pt);

		sleep(pt);
		
		List<Review> list = new ArrayList<>();
		list.add(new Review(productId, 1, "Author 1", "Subject 1", "Content 1", Integer.parseInt(environment.getProperty("local.server.port")), request.getHeader("Custom-callID")));
		list.add(new Review(productId, 2, "Author 2", "Subject 2", "Content 2", Integer.parseInt(environment.getProperty("local.server.port")), request.getHeader("Custom-callID")));
		list.add(new Review(productId, 3, "Author 3", "Subject 3", "Content 3", Integer.parseInt(environment.getProperty("local.server.port")), request.getHeader("Custom-callID")));

		logger.info("/reviews response size: {}", list.size());

		return list;
	}

	private void sleep(int pt) {
		try {
			Thread.sleep(pt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sample usage:
	 *
	 * curl "http://localhost:10002/set-processing-time?minMs=1000&maxMs=2000"
	 *
	 * @param minMs
	 * @param maxMs
	 */
	@RequestMapping("/set-processing-time")
	public void setProcessingTime(@RequestParam(value = "minMs", required = true) int minMs,
			@RequestParam(value = "maxMs", required = true) int maxMs) {

		logger.info("/set-processing-time called: {} - {} ms", minMs, maxMs);

		setProcTimeBean.setDefaultProcessingTime(minMs, maxMs);
	}
}
