package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.values.ConsumoId;
import co.com.sofka.bolera.partida.values.Valor;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorDeConsumo implements Command {
    private final ConsumoId consumoId;
    private final Valor valor;

    public ActualizarValorDeConsumo(ConsumoId consumoId, Valor valor) {
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
