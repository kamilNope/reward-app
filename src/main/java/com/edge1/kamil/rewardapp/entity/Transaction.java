package com.edge1.kamil.rewardapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION") public
class Transaction {
    @Id
    @Column(name = "ID_T")
    private Long id;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "ID_C")
    private Customer customer;

}
