package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.model.decorator.Component;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.GenericType;

import java.util.HashMap;
import java.util.Map;

public class DreamGuitar extends Component {

        private double totalPrice;
        private int id;

        private Map<String, GenericType> all = new HashMap<>();
//        private String[] components;
//        private String[] infos;
//        private boolean[] alternatives;

        public DreamGuitar(){
                this.totalPrice = 0.0;
//                this.components = new String[6];
//                this.infos = new String[6];
//                this.alternatives = new boolean[6];
        }

        public DreamGuitar(DreamGuitarBean guitar){
                this.totalPrice = guitar.getPrice();
                this.id = guitar.getId();
                this.all = new HashMap<>(guitar.getAllComponents());
        }

        public DreamGuitar(double price, int id, Map<String, GenericType> all){
                this.totalPrice = price;
                this.id = id;
                this.all = all;
        }

        @Override
        public double price(){
                return this.totalPrice;
        }

        public int id(){return this.id;}

        public Map<String, GenericType> allComponents(){return all;}
}
