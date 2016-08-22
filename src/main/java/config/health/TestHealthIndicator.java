package config.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * Created by hzhubin15 on 2016/8/22.
 */
public class TestHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		double a = Math.random();
		if(a > 0.5){
			return Health.up().withDetail("mmb-health",a).build();
		}else {
			return Health.unknown().withDetail("mmb-health",a).build();
		}
	}
}
