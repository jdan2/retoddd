package co.com.sofka.bolera.partida.events;

import co.com.sofka.bolera.partida.values.ConsumoId;
import co.com.sofka.bolera.partida.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorDeConsumoActualizado extends DomainEvent {
    private final ConsumoId consumoId;
    private final Valor valor;

    public ValorDeConsumoActualizado(ConsumoId consumoId, Valor valor) {
        super("sofka.partida.valordeconsumoactualizaddo");
        this.consumoId = consumoId;
        this.valor = valor;
    }

    public ConsumoId getConsumoId() {
        return consumoId;
    }

    public Valor getValor() {
        return valor;
    }
}
