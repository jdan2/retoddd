package co.com.sofka.bolera.partida;

import co.com.sofka.bolera.partida.values.ConsumoId;
import co.com.sofka.bolera.partida.values.Descuento;
import co.com.sofka.bolera.partida.values.Valor;
import co.com.sofka.bolera.partida.values.ValorFinal;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Consumo extends Entity<ConsumoId> {

    private Valor valor;
    private Descuento descuento;
    private ValorFinal valorFinal;

    public Consumo(ConsumoId entityId, Valor valor, Descuento descuento, ValorFinal valorFinal) {
        super(entityId);
        this.valor = valor;
        this.descuento = descuento;
        this.valorFinal = valorFinal;
    }

    public void actualizarValor( Valor valor){
        this.valor = Objects.requireNonNull(valor);
    }

    public void actualizarValorFinal( ValorFinal valorFinal){
        this.valorFinal = Objects.requireNonNull(valorFinal);
    }

    public void actualizarDescuento(Descuento descuento){
        this.descuento = Objects.requireNonNull(descuento);
    }


    public Valor valor() {
        return valor;
    }

    public Descuento descuento() {
        return descuento;
    }

    public ValorFinal valorFinal() {
        return valorFinal;
    }
}
