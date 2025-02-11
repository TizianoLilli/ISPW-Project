package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.model.decorator.Component;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.GenericType;

import java.util.Collection;

public class DreamGuitar extends Component {

        private double totalPrice;
        private Collection<GenericType> all;
//        private String[] components;
//        private String[] infos;
//        private boolean[] alternatives;

        public DreamGuitar(){
//                this.totalPrice = 0.0;
//                this.components = new String[6];
//                this.infos = new String[6];
//                this.alternatives = new boolean[6];
        }

        public DreamGuitar(DreamGuitarBean guitar){
                this.totalPrice = 0;
                all = guitar.getAllComponents();
                for (GenericType t : all) {
                        this.totalPrice += t.price();
                }
        }

        @Override
        public double price(){
                return this.totalPrice;
        }
}
