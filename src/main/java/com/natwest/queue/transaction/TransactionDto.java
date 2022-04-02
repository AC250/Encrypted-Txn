package com.natwest.queue.transaction;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class TransactionDto {

    @JsonAlias("AccountFrom")
    private String fromAccount;

    @JsonAlias("Amount")
    private Integer amount;

    @JsonAlias("Account Number")
    private String toAccount;

    @JsonAlias("Currency")
    private String currency;

    @JsonAlias("Type")
    private String type;
}
