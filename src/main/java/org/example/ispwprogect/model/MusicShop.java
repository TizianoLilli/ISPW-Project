// model/MusicShop.java
package org.example.ispwproject.model;  // Verifica il pacchetto corretto

import org.example.ispwproject.observer.Observer;
import org.example.ispwproject.model.observer.Subject;

//import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class MusicShop implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private List<String> selectedArtists = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(selectedArtists);
        }
    }

    public void setSelectedArtists(List<String> artists) {
        this.selectedArtists = artists;
        notifyObservers();
    }
}
