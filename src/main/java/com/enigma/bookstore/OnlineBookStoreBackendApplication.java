package com.enigma.bookstore;

import com.enigma.bookstore.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class OnlineBookStoreBackendApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OnlineBookStoreBackendApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreBackendApplication.class, args);
    }
}
