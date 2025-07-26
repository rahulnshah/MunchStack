package org.example.munchstack.enums;

import lombok.Getter;

@Getter
public enum STATUS {
    PENDING("Pending"),
    READY("Ready");

    private final String status;

    STATUS(String status) {
        this.status = status;
    }

}
