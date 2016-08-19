package config.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@Configuration
public class WebConverter extends WebMvcConfigurerAdapter{

	@Bean
	public
	ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
		return new ByteArrayHttpMessageConverter();
	}

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>>
//			converters) {
//		converters.add(new ByteArrayHttpMessageConverter());
//	}

//	@Override
//	public void
//	extendMessageConverters(List<HttpMessageConverter<?>>
//			converters) {
//		converters.clear();
//		converters.add(new ByteArrayHttpMessageConverter());
//	}

}
