package com.example.kafkabasics.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class ProducerDemoWithCallback {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemoWithCallback.class.getSimpleName());

    public static void main(String[] args) throws IOException, InterruptedException {
        log.info("Started Producer demo with callback");
        Properties prop = new Properties();
        prop.load(ProducerDemo.class.getClassLoader().getResourceAsStream("application.properties"));
        //create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 10; i++) {
                String topic = "demo_java";
                String key = "id_" + i;
                String value = "hello_world" + i;
                //create a producer record
                ProducerRecord<String, String> producerRecord =
                        new ProducerRecord<>(topic, key, value);
                //send data
                producer.send(producerRecord, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        log.info("In kafka call back");
                        //executed every time a record successfully sent or an exception is thrown
                        if (e == null) {
                            //record success
                            log.info(
                                    "key: " + key + "\n" +
                                            "Partition: " + metadata.partition());
                        } else {
                            log.error("Error while producing" + e.getMessage());
                        }
                    }
                });
                Thread.sleep(500);
                //send data
                producer.send(producerRecord);
            }
        }




        //tell the producer to send all the data and block until done- synchronous
        producer.flush();

        //flush and close the producer
        producer.close();

    }

}
