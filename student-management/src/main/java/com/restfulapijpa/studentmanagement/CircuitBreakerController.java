package com.restfulapijpa.studentmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {



private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

@GetMapping("/sample-api")
@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
@Bulkhead(name="default")
public String sampleApi() {
logger.info("Sample API call recieved");
ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8090/contact", String.class);
return forEntity.getBody();
}

public String hardcodedResponse(Exception ex) {
return "fallback-response";

}
}