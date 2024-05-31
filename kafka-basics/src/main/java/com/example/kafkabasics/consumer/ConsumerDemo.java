package com.example.kafkabasics.consumer;

import com.example.kafkabasics.producer.ProducerDemo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());
    public static void main(String[] args) throws IOException {
        log.info("hello");

        String group_id = "my_java_application";
        String topic = "demo_java";
        //create consumer property

        Properties prop = new Properties();
        prop.load(ProducerDemo.class.getClassLoader().getResourceAsStream("application.properties"));
        prop.setProperty("key.deserializer", StringDeserializer.class.getName());
        prop.setProperty("value.deserializer", StringDeserializer.class.getName());
        prop.setProperty("group.id", group_id);

        prop.setProperty("auto.offset.reset", "earliest");

        //create the consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);

        final Thread mainThread = Thread.currentThread();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                log.info("Detected a shutdown, lets exit by calling consumer.wakeup()....");
                consumer.wakeup();

                //join the main thread  to allow the execution of the code in the main thread
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        try {
            consumer.subscribe(Arrays.asList(topic));

            while (true) {
                ConsumerRecords<String, String>  records =  consumer.poll(Duration.ofMillis(1000));

                for (ConsumerRecord<String, String> record: records) {
                    log.info("Key : "+ record.key() + ",Value "+ record.value());
                    log.info("Partition : "+ record.partition() + ",Offset "+ record.offset());
                }
            }

        } catch (WakeupException e) {
            log.info("Consumer is shutting down");
        } catch (Exception e) {
            log.error("Exception occuered"+ e.getStackTrace());
        } finally {
            consumer.close(); // close the consumer with commitng offset
            log.info("Consumer successfully logged off");
        }
        //subscribe to topic


    }

}
