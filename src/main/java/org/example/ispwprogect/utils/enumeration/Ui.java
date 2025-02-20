package org.example.ispwprogect.utils.enumeration;

public enum Ui {
    NONE(-1), GUI(1), CLI(0);

    private final int value;

    Ui(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Ui fromInt(int i) {
        for (Ui u : Ui.values()) {
            if (u.getValue() == i) {
                return u;
            }
        }
        return NONE;
    }
}
