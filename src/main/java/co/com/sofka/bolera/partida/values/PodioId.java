package co.com.sofka.bolera.partida.values;

import co.com.sofka.domain.generic.Identity;

public class PodioId extends Identity {

    public PodioId() {
    }
    private PodioId(String id){
        super(id);
    }
    public static PodioId of(String id){
        return new PodioId(id);
    }
}
