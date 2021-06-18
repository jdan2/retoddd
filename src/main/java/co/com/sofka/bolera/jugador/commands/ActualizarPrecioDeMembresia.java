package co.com.sofka.bolera.jugador.commands;

import co.com.sofka.bolera.jugador.values.MembresiaId;
import co.com.sofka.bolera.jugador.values.Precio;
import co.com.sofka.domain.generic.Command;

public class ActualizarPrecioDeMembresia implements Command {
    private final MembresiaId entityId;
    private final Precio precio;

    public ActualizarPrecioDeMembresia(MembresiaId entityId, Precio precio) {
        this.entityId = entityId;
        this.precio = precio;
    }

    public MembresiaId getEntityId() {
        return entityId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
