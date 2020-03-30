package com.trucku.driverlistener.config;

import java.util.HashMap;
import java.util.Map;

import com.trucku.driverlistener.models.rest.DriverLocation;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import lombok.AllArgsConstructor;

@Configuration
@EnableKafka
@AllArgsConstructor
public class KafkaConfig {

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, DriverLocation>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, DriverLocation> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setAutoStartup(true);
        return factory;
    }

    @Bean
    public ConsumerFactory<Integer, DriverLocation> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new IntegerDeserializer(), new JsonDeserializer<>(DriverLocation.class));
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "dockerbox:9092");
        return props;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> props = new HashMap<>();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "dockerbox:9092");
        return new KafkaAdmin(props);
    }

    @Bean
    public NewTopic driverLocations() {
        return TopicBuilder.name("driver-locations")
                           .partitions(1)
                           .replicas(1)
                           .build();
    }
}