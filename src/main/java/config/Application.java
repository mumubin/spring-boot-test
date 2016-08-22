package config;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@SpringBootApplication
//@EnableScheduling
//@ComponentScan
@EnableAutoConfiguration
//@EnableMmb
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Profile("logger")
	public StartupRunner schedulerRunner() {
		return new StartupRunner();
	}

	@Bean
	public CommandLineRunner configValuePrinter(@Value("${my.config.value:}") String configValue) {
		return args -> LogFactory.getLog(getClass()).info("Value of my.config.value property is: " + configValue);
	}

}
