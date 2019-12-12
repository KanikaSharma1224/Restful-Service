package restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(RestfulServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceApplication.class, args);
	}

}
