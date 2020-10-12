package net.sigmainfo.lf.automation.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by           : Shaishav.s on 18-04-2018.
 * Test class           : PortalConfig.java
 * Description          : Configuration and scanning packages within the automation suite
 * Includes             : 1. Scans within the base package mentioned
 *                        2. Reads the property file within base package
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.sigmainfo.lf.automation.portal,net.sigmainfo.lf.automation.common")
@PropertySource({"classpath:${envParam}/portal.properties","classpath:${envParam}/UIObject.properties"})
public class PortalConfig extends WebMvcConfigurerAdapter {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /*@Bean
    public PropertyPlaceholderConfigurer propertyConfigurer() throws IOException {
        PropertyPlaceholderConfigurer props = new PropertyPlaceholderConfigurer();
        String envParam=System.getProperty("envParam");
        props.setLocations(new Resource[] {new ClassPathResource(envParam+"/h2db.properties"),new ClassPathResource(envParam+"/mps.properties")});
        return props;
    }*/
}
