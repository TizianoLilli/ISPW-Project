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

        public DreamGuitar(double price){
                this.totalPrice = price;
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
