package org.kafka.Producer;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import okio.Timeout;
import org.kafka.Handler.wikimediaChangeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangeProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangeProducer.class);
    // to send message to kafka topic
    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        String topic ="wikimedia_recentChange";
        BackgroundEventHandler eventHandler= new wikimediaChangeHandler(kafkaTemplate,topic);
        String url="https://stream.wikimedia.org/v2/stream/recentchange";
        URI uriUrl=URI.create(url);
        EventSource.Builder esBuilder = new EventSource.Builder(uriUrl);
        BackgroundEventSource.Builder eventSource=new BackgroundEventSource.Builder(eventHandler,esBuilder);
        BackgroundEventSource source = eventSource.build();
        source.start();

        TimeUnit.MINUTES.sleep(10);

    }

}
