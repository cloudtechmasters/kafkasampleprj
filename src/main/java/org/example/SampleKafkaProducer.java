package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleKafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(SampleKafkaProducer.class);
    private static final String TOPIC = "quickstart-events";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("#### -&gt; Producing message -&gt; %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
