package com.deliveryPerson.DeliveryPersonApp.controller;

import com.deliveryPerson.DeliveryPersonApp.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    private KafkaService kafkaService;
    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public LocationController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        this.kafkaService.updateLocation("( " + Math.round(Math.random()*100)+ " , " + Math.round(Math.random()*100) + " )");
        this.logger.info("location updated");
        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
    }
}
