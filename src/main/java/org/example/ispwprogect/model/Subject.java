// model/observer/Subject.java
package org.example.ispwproject.model.observer;

import org.example.ispwproject.observer.Observer;

public interface Subject {
    void addObserver(Observer observer);  // Aggiungi un osservatore
    void removeObserver(Observer observer);  // Rimuovi un osservatore
    void notifyObservers();  // Notifica tutti gli osservatori
}

