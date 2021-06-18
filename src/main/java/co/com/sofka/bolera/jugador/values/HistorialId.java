package co.com.sofka.bolera.jugador.values;

import co.com.sofka.domain.generic.Identity;

public class HistorialId extends Identity {

    public HistorialId() {
    }
    private HistorialId(String id){
        super(id);
    }
    public static HistorialId of(String id){
        return new HistorialId(id);
    }
}
