package co.com.sofka.bolera.jugador.values;

import co.com.sofka.domain.generic.Identity;

public class EquipamientoId extends Identity {
    public EquipamientoId() {
    }
    private EquipamientoId(String id){
        super(id);
    }
    public static EquipamientoId of(String id){
        return new EquipamientoId(id);
    }
}
