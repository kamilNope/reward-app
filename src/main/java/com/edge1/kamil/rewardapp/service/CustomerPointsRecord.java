package com.edge1.kamil.rewardapp.service;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public final class CustomerPointsRecord {

    Integer totalUserScore;
    Integer monthUserScore;
    String userID;
}
