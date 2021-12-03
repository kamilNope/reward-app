package com.edge1.kamil.rewardapp.service;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomerTotalPointsRecord {
    Integer totalUserScore;
    String userName;
}
