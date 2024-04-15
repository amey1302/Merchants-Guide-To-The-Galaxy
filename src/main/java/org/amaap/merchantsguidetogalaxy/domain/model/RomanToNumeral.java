package org.amaap.merchantsguidetogalaxy.domain.model;

public enum RomanToNumeral {
    M(1000),
    D(500),
    C(100),
    L(50),
    X(10),
    V(5),

    I(1);

    private final int value;

    RomanToNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
