package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.model.decorator.Component;

public class DreamGuitar extends Component {

        private double totalPrice;
//        private String[] components;
//        private String[] infos;
//        private boolean[] alternatives;

        public DreamGuitar(){
                this.totalPrice = 0.0;
//                this.components = new String[6];
//                this.infos = new String[6];
//                this.alternatives = new boolean[6];
        }

//        public DreamGuitar(DreamGuitarBean guitarBean){
//                this.totalPrice = guitarBean.getPickupBean().getPrice() + guitarBean.getFretboardBean().getPrice() + guitarBean.getStringsBean().getPrice();
//                this.components[i] = guitarBean.getPickupBean()
//        }

        @Override
        public double price(){
                return this.totalPrice;
        }
}
