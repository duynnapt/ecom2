package com.ecom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

@SpringBootApplication
public class EcomCoreApplication {
    private static final Logger log = LoggerFactory.getLogger(EcomCoreApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        log.info("Start core application ...");
        SpringApplication app = new SpringApplication(EcomCoreApplication.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        log.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}\n\t"
                        + "External: \t{}://{}:{}\n\t"
                        + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol,
                InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), env.getActiveProfiles());
    }

    @PostConstruct
    public void applicationStartHook() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
