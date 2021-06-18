package co.com.sofka.bolera.jugador.values;

import co.com.sofka.domain.generic.Identity;

public class MembresiaId extends Identity {
    public MembresiaId() {
    }
    private MembresiaId(String id){
        super(id);
    }
    public static MembresiaId of(String id){
        return new MembresiaId(id);
    }
}
