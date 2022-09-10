package com.kuehne.nagel.test.contactlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.kuehne.nagel.test.contactlist.repository")
@EntityScan("com.kuehne.nagel.test.contactlist.model")
@SpringBootApplication
public class ServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
