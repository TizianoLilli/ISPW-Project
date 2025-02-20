package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.components.GenericType;

public class AddComponentBean {

    private String componentKey;
    private GenericType alternative;

    public AddComponentBean(String componentKey, GenericType alternative) {
        this.componentKey = componentKey;
        this.alternative = alternative;
    }

    public String getComponentKey() {return componentKey;}
    public GenericType getAlternative() {return alternative;}
}
