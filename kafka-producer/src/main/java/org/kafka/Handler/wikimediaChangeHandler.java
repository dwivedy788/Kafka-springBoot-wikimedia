package org.kafka.Handler;

import com.launchdarkly.eventsource.MessageEvent;

import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;



public class wikimediaChangeHandler implements BackgroundEventHandler {
    private static final Logger LOGGER= LoggerFactory.getLogger(wikimediaChangeHandler.class);
    public KafkaTemplate<String,String> kafkaTemplate;
    String topic;

    public wikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    public void onMessage(String s, MessageEvent messageEvent){
        LOGGER.info(String.format("Event Data --> %s",messageEvent.getData()));
        //to send message to topic
        kafkaTemplate.send(topic,messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }

}
