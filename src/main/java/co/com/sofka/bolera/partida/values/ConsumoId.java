package co.com.sofka.bolera.partida.values;

import co.com.sofka.bolera.jugador.values.HistorialId;
import co.com.sofka.domain.generic.Identity;

public class ConsumoId extends Identity {

    public ConsumoId() {
    }
    private ConsumoId(String id){
        super(id);
    }
    public static ConsumoId of(String id){
        return new ConsumoId(id);
    }
}
