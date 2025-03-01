package post_office.simulAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SimulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulApiApplication.class, args);
	}

}
