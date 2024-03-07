package com.deliveryPerson.DeliveryPersonApp.service;

import com.deliveryPerson.DeliveryPersonApp.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean updateLocation(String location){
        this.kafkaTemplate.send(AppConstant.UPDATED_LOCATION_TOPIC, location);
        return true;
    }
}
