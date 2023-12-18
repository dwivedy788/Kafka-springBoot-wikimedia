package org.kafka;

import org.kafka.Producer.WikimediaChangeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainSpringBootProducerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MainSpringBootProducerApplication.class);
    }
    @Autowired
    private WikimediaChangeProducer wikimediaChangeProducer;


    @Override
    public void run(String... args) throws Exception {
        wikimediaChangeProducer.sendMessage();

    }
}