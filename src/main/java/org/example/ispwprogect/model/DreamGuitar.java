package org.example.ispwprogect.model;

public class DreamGuitar extends Component{

        private double basePrice;

        public DreamGuitar(){
                this.basePrice = 0.0;
        }

        @Override
        public double price(){
                return this.basePrice;
        }
}
