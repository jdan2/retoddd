package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.ActualizarPrecioDeMembresia;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeEquipamiento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarPrecioDeMembresiaUseCase extends UseCase<RequestCommand<ActualizarPrecioDeMembresia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPrecioDeMembresia> actualizarPrecioDeMembresiaRequestCommand) {

        var command = actualizarPrecioDeMembresiaRequestCommand.getCommand();
        var jugador =  Jugador.from(command.getJugadorId(), retrieveEvents() );

        jugador.actualizarPrecioDeMembresia(command.getEntityId(), command.getPrecio());
        emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));

    }
}
