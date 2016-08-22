package config.server;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

	/**
	 * 设置session时间为一分钟
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer
	embeddedServletContainerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void
			customize(ConfigurableEmbeddedServletContainer
					container) {
				container.setSessionTimeout(1, TimeUnit.MINUTES);
			}
		};
	}
}
