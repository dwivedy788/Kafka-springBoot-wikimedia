package org.kafka.service;

import org.kafka.Entity.WikimediaData;
import org.kafka.Repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(kafkaConsumer.class);
    @Autowired
    public WikimediaDataRepository wikimediaDataRepository;
    @KafkaListener(topics = "wikimedia_recentChange",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Message Recieved -->%s",eventMessage));
        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikimediaData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);

    }
}
