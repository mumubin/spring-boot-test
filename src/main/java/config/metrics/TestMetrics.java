package config.metrics;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hzhubin15 on 2016/8/22.
 */
public class TestMetrics implements PublicMetrics {
	@Override
	public Collection<Metric<?>> metrics() {
		List<Metric<?>> metrics = new LinkedList<>();
		metrics.add(new Metric("mmb-Test", Math.random()));
		return metrics;
	}
}
