package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.Identity;

public class TurnoId extends Identity {
    public TurnoId() {
    }
    private TurnoId(String id){
        super(id);
    }
    public static TurnoId of(String id){
        return new TurnoId(id);
    }
}
