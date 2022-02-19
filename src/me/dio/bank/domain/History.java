package me.dio.bank.domain;

import java.time.LocalDateTime;

public class History {

    private final LocalDateTime timestamp;
    private final String operation;

    private History(String operation) {
        this.timestamp = LocalDateTime.now();
        this.operation = operation;
    }

    public static History create(String operation) {
        return new History(operation);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return String.format("%s %s", operation, timestamp);
    }
}
