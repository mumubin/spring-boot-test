package config.formatters;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@Configuration
public class WebFormatter extends WebMvcConfigurerAdapter {
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new NameValueFormatter());
	}

}
