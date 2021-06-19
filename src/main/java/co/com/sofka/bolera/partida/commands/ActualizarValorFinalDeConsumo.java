package co.com.sofka.bolera.partida.commands;

import co.com.sofka.bolera.partida.values.ConsumoId;
import co.com.sofka.bolera.partida.values.ValorFinal;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorFinalDeConsumo implements Command {
    private final ConsumoId consumoId;
    private final ValorFinal valorFinal;

    public ActualizarValorFinalDeConsumo(ConsumoId consumoId, ValorFinal valorFinal) {
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
