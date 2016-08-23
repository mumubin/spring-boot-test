package config.server;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@Configuration
@PropertySource("classpath:/tomcat.https.properties")
@EnableConfigurationProperties(TomcatSslConnectorProperties.class)
public class WebServer extends WebMvcConfigurerAdapter {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false).
                setUseTrailingSlashMatch(true);
    }

    /**
     * 添加静态文件
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/internal/**")
                .addResourceLocations("classpath:/")
                .setCachePeriod(1000);
    }


    /**
     * 添加session
     *
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


    /**
     * 设置https连接
     * @param properties
     * @return
     */
    @Bean
    public EmbeddedServletContainerFactory
    servletContainer(TomcatSslConnectorProperties properties) {
        TomcatEmbeddedServletContainerFactory tomcat = new
                TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createSslConnector(properties)
        );
        return tomcat;
    }

    private Connector createSslConnector(TomcatSslConnectorProperties
                                                 properties) {
        Connector connector = new Connector();
        properties.configureConnector(connector);
        return connector;
    }


}
