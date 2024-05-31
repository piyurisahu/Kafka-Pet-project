package com.example.kafkabasics.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;


public class ProducerDemo {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());
    public static void main(String[] args) throws IOException {
        log.info("hello");

        //create producer property

        Properties prop = new Properties();
        prop.load(ProducerDemo.class.getClassLoader().getResourceAsStream("application.properties"));

        //create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

        //create a producer record
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("demo_java", "Hello_world");


        //send data
        producer.send(producerRecord);

        //tell the producer to send all the data and block until done- synchronous
        producer.flush();

        //flush and close the producer
        producer.close();

    }

}
