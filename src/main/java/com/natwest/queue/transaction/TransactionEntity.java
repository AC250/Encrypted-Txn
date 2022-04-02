package com.natwest.queue.transaction;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "from_account")
    private String fromAccount;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "to_account")
    private String toAccount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "type")
    private String type;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
}
