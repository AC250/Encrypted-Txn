package com.natwest.queue.sender;

import com.google.gson.Gson;
import com.natwest.queue.transaction.TransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@RestController
@RequestMapping("/sender")
@Slf4j
public class SenderController {

    @PostMapping
    public ResponseEntity<String> sendPayload(@RequestBody final TransactionDto transactionDto) {
        final RestTemplate restTemplate = new RestTemplate();
        log.info("transaction information: {}", new Gson().toJson(transactionDto));
        final String encryptedPayload = Base64.getEncoder().encodeToString(new Gson().toJson(transactionDto).getBytes());
        log.info("Sending data to queue: {}", encryptedPayload);
        restTemplate.postForObject("http://localhost:8080/receiver/payload", new HttpEntity<>(encryptedPayload), String.class);
        return new ResponseEntity<>("Data Pushed", HttpStatus.OK);
    }
}
