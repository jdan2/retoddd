package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.ConsumoId;
import co.com.sofka.bolera.partida.values.ValorFinal;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorFinalDeConsumoActualizado extends DomainEvent {
    private ConsumoId consumoId;
    private ValorFinal valorFinal;

    public ValorFinalDeConsumoActualizado(ConsumoId consumoId, ValorFinal valorFinal) {
        super("sofka.partida.valorfinaldeconsumoactualizado");
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
