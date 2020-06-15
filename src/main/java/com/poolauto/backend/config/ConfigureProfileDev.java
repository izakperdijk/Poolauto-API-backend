package com.poolauto.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* Get and set URL system properties RDW */
@Configuration()
@Profile("dev")
public class ConfigureProfileDev {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {

        FileInputStream propFile = new FileInputStream(
                System.getProperty("user.home")
                        + "/Documents/Poolauto-API-configs/Poolauto-API-dev.properties"
        );

        Properties p = new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);

        return new PropertySourcesPlaceholderConfigurer();

    }

}
