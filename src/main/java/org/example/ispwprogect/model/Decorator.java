package org.example.ispwprogect.model;

public abstract class Decorator extends Component{

    private Component component;

    protected Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double price(){
        double resultsFromRedirection = this.component.price();
        return resultsFromRedirection;
    }
}
