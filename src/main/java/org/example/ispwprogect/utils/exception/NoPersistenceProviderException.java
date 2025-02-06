package org.example.ispwprogect.utils.exception;

import org.example.ispwprogect.utils.enumeration.PersistenceProvider;

public class NoPersistenceProviderException extends RuntimeException {

    public NoPersistenceProviderException(PersistenceProvider provider, Exception e) {
        super("Impossible to instantiate factory for provider " + provider.getClass().getName(), e);
    }
}
