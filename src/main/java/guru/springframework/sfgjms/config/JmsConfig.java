package guru.springframework.sfgjms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


///////////////////// Does all the serialization

//////////////////// When we send a message to JMS, Spring is going to convert that message that we send to a JMS text message
// and the payload is taking the Java Object and converting it to JSON payload



@Configuration
public class JmsConfig {

    public static final String MY_QUEUE= "my-hello-world";

@Bean
    public MessageConverter messageConverter(){

        MappingJackson2MessageConverter converter=new MappingJackson2MessageConverter();

        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");

        return converter;
    }
}

