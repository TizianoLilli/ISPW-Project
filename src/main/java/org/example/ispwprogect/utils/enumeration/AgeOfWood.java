package org.example.ispwprogect.utils.enumeration;

public enum AgeOfWood {

    TWENTY(1.5),
    THIRTY(2),
    FIFTY(2.5);

    private final double multiplier;

    AgeOfWood(double multi) {
        this.multiplier = multi;
    }

    public double getMultiplier() {return multiplier;}
}
