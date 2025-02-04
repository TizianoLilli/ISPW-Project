// ConcreteObserver.java
package org.example.ispwproject.observer;

import java.util.List;

public class ConcreteObserver implements org.example.ispwproject.observer.Observer {

    @Override
    public void update(List<String> selectedArtists) {
        // Implementa qui cosa deve fare l'observer quando viene notificato
        // Ad esempio, puoi stampare gli artisti selezionati
        System.out.println("Gli artisti selezionati sono: " + selectedArtists);
    }
}


