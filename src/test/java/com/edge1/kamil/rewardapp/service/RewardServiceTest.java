package com.edge1.kamil.rewardapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.edge1.kamil.rewardapp.service.RewardService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RewardServiceTest {

    @Autowired
    RewardService rewardService;

    @Test
    void shouldNotSumRewardPointsIfPriceIsLower() {
        // given
        Double price = 40.99;
        // when & then
        assertEquals(0, rewardService.sumRewardPoints(price));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigher() {
        // given
        Double price = 99.99;
        // when & then
        assertEquals(49, rewardService.sumRewardPoints(price));
    }

    @Test
    void shouldSumRewardPointsIfPriceIsHigherPlusExtraPoints() {
        // given
        Double price = 120.01;
        // when & then
        assertEquals(90, rewardService.sumRewardPoints(price));
    }

    //    CustomerPointsRecord customerPointsRecord = new CustomerPointsRecord();
    //
    //    @BeforeEach
    //    public void setup(){
    //        customerPointsRecord.setUserID("any");
    //        customerPointsRecord.setUserScore(0.0);
    //    }
}