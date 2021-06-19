package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.Consumo;
import co.com.sofka.domain.generic.Command;

public class CrearConsumo implements Command {
    private final Consumo consumo;

    public CrearConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public Consumo getConsumo() {
        return consumo;
    }
}
