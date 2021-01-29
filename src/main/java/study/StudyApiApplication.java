package study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.config.AppConfig;

@SpringBootApplication
public class StudyApiApplication extends AppConfig {

	public static void main(String[] args) {
		SpringApplication.run(StudyApiApplication.class, args);
	}

}
