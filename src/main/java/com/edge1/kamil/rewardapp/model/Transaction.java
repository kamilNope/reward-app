package com.edge1.kamil.rewardapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @Column(name = "transactionId")
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
