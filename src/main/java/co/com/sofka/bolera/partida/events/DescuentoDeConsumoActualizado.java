package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.ConsumoId;
import co.com.sofka.bolera.partida.values.ValorFinal;
import co.com.sofka.domain.generic.DomainEvent;

public class DescuentoDeConsumoActualizado extends DomainEvent {
    private final ConsumoId consumoId;
    private final ValorFinal valorFinal;

    public DescuentoDeConsumoActualizado(ConsumoId consumoId, ValorFinal valorFinal) {
        super("sofka.partida.descuentodeconsimoactualizado");
        this.consumoId = consumoId;
        this.valorFinal = valorFinal;
    }

    public ConsumoId getConsumoId() {
        return consumoId;
    }

    public ValorFinal getValorFinal() {
        return valorFinal;
    }
}
