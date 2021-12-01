package com.edge1.kamil.rewardapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.edge1.kamil.rewardapp"})
public class RewardAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardAppApplication.class, args);
    }

}
