package com.edge1.kamil.rewardapp.controller;

import java.util.function.Supplier;

class CustomApiException extends RuntimeException {

    public CustomApiException() {
        super();
    }

    public CustomApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CustomApiException(final String message) {
        super(message);
    }

    public CustomApiException(final Throwable cause) {
        super(cause);
    }
}
