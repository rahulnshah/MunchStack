package org.example.munchstack.enums;

public enum STATUS {
    PENDING("Pending"),
    READY("Ready"),
    COMPLETED("Completed");

    private final String status;

    STATUS(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
