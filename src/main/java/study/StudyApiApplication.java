package study;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import study.config.AppConfig;

@SpringBootApplication
public class StudyApiApplication extends AppConfig {

	public static void main(String[] args) {
		SpringApplication.run(StudyApiApplication.class, args);
	}

}
