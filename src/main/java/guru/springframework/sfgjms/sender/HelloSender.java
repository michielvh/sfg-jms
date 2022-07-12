package guru.springframework.sfgjms.sender;

import java.util.UUID;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import guru.springframework.sfgjms.config.JmsConfig;
import guru.springframework.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HelloSender {

    // Pre-configured JMS Template to talk to ActiveMQ instance
    // Pre-configured with all the credentials for the ActiveMQ server
    private final JmsTemplate jmsTemplate;

    // The @Scheduled uses the TaskConfig
    @Scheduled(fixedRate = 2000)
    public void sendMessage(){

        System.out.println("i'm sending a message");
        HelloWorldMessage message =HelloWorldMessage.builder()
                .uuid(UUID.randomUUID())
                .message("Hello World!")
                .build();

        // convert and send is going to be using the message converter that we provided (in JmsConfig)
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Message Sent!");
    }
}
