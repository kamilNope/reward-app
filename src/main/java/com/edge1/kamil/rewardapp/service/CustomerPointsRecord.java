package com.edge1.kamil.rewardapp.service;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CustomerPointsRecord {

    Double totalUserScore;
    Double monthUserScore;
    String userID;
}
