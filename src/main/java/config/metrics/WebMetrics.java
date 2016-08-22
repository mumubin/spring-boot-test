package config.metrics;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hzhubin15 on 2016/8/22.
 */
@Configuration
public class WebMetrics {
	@Bean
	public PublicMetrics testMetics() {
		return new TestMetrics();
	}
}
