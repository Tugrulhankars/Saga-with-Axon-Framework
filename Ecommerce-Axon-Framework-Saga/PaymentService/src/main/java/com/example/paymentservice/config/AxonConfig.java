package com.example.paymentservice.config;

import com.thoughtworks.xstream.XStream;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {

    @Bean
    @Primary
    public Serializer xStreamSerializer() {
        XStream xStream = new XStream();

        // XStream güvenliğini devre dışı bırakıyoruz (Tüm sınıflara izin verir)
        xStream.allowTypesByWildcard(new String[]{"com.example.**", "com.thoughtworks.xstream.**"});

        return XStreamSerializer.builder()
                .xStream(xStream)
                .build();
    }
}
