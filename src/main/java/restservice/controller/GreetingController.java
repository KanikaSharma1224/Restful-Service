package restservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import restservice.model.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello %s !";
	private final AtomicLong counter = new AtomicLong();
	
	@Value("${resource.endpoint}")
	private String endpoint;
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value ="/greeting", method= RequestMethod.GET)
	public Greeting getGreetings(@RequestParam(value ="name" ,defaultValue="World") String name) {
		System.out.println("Inside greeting");
		return new Greeting(counter.getAndIncrement(),String.format(template, name));	
	}
	
    @GetMapping("/getGreeting")
    public ResponseEntity<String> consumeGreetings() {
    	Greeting greet = restTemplate.getForObject(endpoint, Greeting.class);
    	System.out.println("Greeting object:: "+greet.toString());
    	return new ResponseEntity<String>("Passed",HttpStatus.OK);
	}
    
}
