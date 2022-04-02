package com.natwest.queue.reciever;

import com.google.gson.Gson;
import com.natwest.queue.transaction.TransactionDto;
import com.natwest.queue.transaction.TransactionEntity;
import com.natwest.queue.transaction.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("receiver")
@Slf4j
public class ReceiverController {

    private final TransactionRepository transactionRepository;

    public ReceiverController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/payload")
    public void savePayloadData(@RequestBody final String payload) {
        log.info("received payload: {}", payload);
        final String transactionJson = new String(Base64.getDecoder().decode(payload));
        log.info("data after decoding: {}", transactionJson);
        final Gson gson = new Gson();
        final TransactionDto transactionDto = gson.fromJson(transactionJson, TransactionDto.class);
        final TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(transactionDto.getAmount());
        transactionEntity.setFromAccount(transactionDto.getFromAccount());
        transactionEntity.setCurrency(transactionDto.getCurrency());
        transactionEntity.setType(transactionDto.getType());
        transactionEntity.setToAccount(transactionDto.getToAccount());
        transactionRepository.save(transactionEntity);
    }
}
