package com.manager.pet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@MapperScan("com.manager.pet.mapper")
public class PetApplication {

    private static final Logger log = LoggerFactory.getLogger(PetApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableEnvironment configurableEnvironment = SpringApplication.run(PetApplication.class, args).getEnvironment();
        String protocol = "http";
        if (configurableEnvironment.getProperty("server.ssl.key-store") != null)
            protocol = "https";
        log.info("\n---------------------------------------------------------------------------------------\n\tApplication '{}' is running! Access URLs:\n\tLocal: \t\t{}://localhost:{}\n\tExternal: \t{}://{}:{}\n\tProfile(s): \t{}\n---------------------------------------------------------------------------------------", configurableEnvironment

                .getProperty("spring.application.name"), protocol, configurableEnvironment

                .getProperty("server.port"), protocol,

                InetAddress.getLocalHost().getHostAddress(), configurableEnvironment
                .getProperty("server.port"), configurableEnvironment
                .getActiveProfiles());
    }

}
