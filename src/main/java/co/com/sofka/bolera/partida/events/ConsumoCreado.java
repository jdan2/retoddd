package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.Consumo;
import co.com.sofka.domain.generic.DomainEvent;

public class ConsumoCreado extends DomainEvent {
    private Consumo consumo;

    public ConsumoCreado(Consumo consumo) {
        super("sofka.partida.consumocreado");
        this.consumo = consumo;
    }

    public Consumo getConsumo() {
        return consumo;
    }
}
