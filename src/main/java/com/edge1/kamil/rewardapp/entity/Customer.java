package com.edge1.kamil.rewardapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CUSTOMER") public
class Customer {
    @Id @Column(name = "ID_C", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

}
