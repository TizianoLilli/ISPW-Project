package org.example.ispwprogect.utils.enumeration;

public enum FretboardType implements GenericType {

        MAPLE(100.0, "Coming soon..."),
        ROSEWOOD(50.0,  "Coming soon..."),
        EBONY(20.0, "Coming soon...");

        private final double PRICE;
        private static final String TYPE = "Fretboard";
        private final String INFO;

        FretboardType(double price, String info) {
            this.PRICE = price;
            this.INFO = info;
        }

        @Override
        public double price() {
            return PRICE;
        }

        public String type() {
            return TYPE;
        }

        @Override
        public String info() {
            return INFO;
        }

}
