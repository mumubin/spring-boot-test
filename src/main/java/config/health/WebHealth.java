package config.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthIndicator;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hzhubin15 on 2016/8/22.
 */
@Configuration
public class WebHealth {
	@Autowired
	private HealthAggregator healthAggregator;
	@Bean
	public HealthIndicator dbCountHealthIndicator() {
		CompositeHealthIndicator compositeHealthIndicator = new
				CompositeHealthIndicator(healthAggregator);
		compositeHealthIndicator.addHealthIndicator("health-name", new TestHealthIndicator());
		return compositeHealthIndicator;
	}
}
