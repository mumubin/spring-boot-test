package config.server;

import lombok.Data;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

/**
 * Created by mmb on 2016/8/19.
 */
@PropertySource("classpath:/tomcat.https.properties")
@ConfigurationProperties(prefix = "custom.tomcat.https")
@Data
public class TomcatSslConnectorProperties {
    private Integer port;
    private Boolean ssl= true;
    private Boolean secure = true;
    private String scheme = "https";
    private File keystore;
    private String keystorePassword;
    //Skipping getters and setters to save space, but we do need them
    public void configureConnector(Connector connector) {
        if (port != null)
            connector.setPort(port);
        if (secure != null)
            connector.setSecure(secure);
        if (scheme != null)
            connector.setScheme(scheme);
        if (ssl!= null)
            connector.setProperty("SSLEnabled", ssl.toString());
        if (keystore!= null && keystore.exists()) {
            connector.setProperty("keystoreFile",
                    keystore.getAbsolutePath());
            connector.setProperty("keystorePassword", keystorePassword);
        }
    }
}
