package org.example.ispwprogect.utils.enumeration;

public enum AgeOfWood {

    TWENTY(1.5),
    THIRTY(2),
    FIFTY(2.5);

    private final double MULTIPLIER;

    AgeOfWood(double multi) {
        this.MULTIPLIER = multi;
    }

    public double getMultiplier() {return MULTIPLIER;}
}
