package org.example.munchstack.enums;

public enum SIZE {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String size;

    SIZE(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
