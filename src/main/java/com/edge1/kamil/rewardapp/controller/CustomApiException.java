package com.edge1.kamil.rewardapp.controller;

class CustomApiException extends RuntimeException {

    public CustomApiException(final String message) {
        super(message);
    }
}
