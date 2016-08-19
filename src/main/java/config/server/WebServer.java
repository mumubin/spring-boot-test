package config.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Timestamp;
import java.util.Date;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@Configuration
public class WebServer extends WebMvcConfigurerAdapter {
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false).
				setUseTrailingSlashMatch(true);
	}

	/**
	 * 添加静态文件
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/internal/**")
				.addResourceLocations("classpath:/")
				.setCachePeriod(1000);
	}


}
