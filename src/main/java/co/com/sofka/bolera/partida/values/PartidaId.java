package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.Identity;

public class PartidaId extends Identity {
    public PartidaId() {
    }
    private PartidaId(String id){
        super(id);
    }
    public static PartidaId of(String id){
        return new PartidaId(id);
    }
}
