package com.edge1.kamil.rewardapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edge1.kamil.rewardapp.service.CustomerPointsRecord;

@RestController("")
@RequestMapping("api/reward-program")
class RewardController {

    @GetMapping ("/{userId}")
    CustomerPointsRecord getUserMonthScore(@PathVariable String userId){
        return new CustomerPointsRecord();
    }

}
