package org.example.ispwprogect.utils.enumeration;

public enum FretboardType {

        MAPLE(100.0, "Fretboard", "Coming soon..."),
        ROSEWOOD(50.0, "Fretboard", "Coming soon..."),
        EBONY(20.0, "Fretboard", "Coming soon...");

        private final double price;
        private final String type;
        private final String info;

        FretboardType(double price, String type, String info) {
            this.price = price;
            this.type = type;
            this.info = info;
        }

        public double price() {
            return price;
        }

        public String type() {
            return type;
        }

        public String info() {
            return info;
        }

}
