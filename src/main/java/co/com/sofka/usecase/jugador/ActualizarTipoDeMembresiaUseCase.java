package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeEquipamiento;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeMembresia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarTipoDeMembresiaUseCase extends UseCase<RequestCommand<ActualizarTipoDeMembresia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoDeMembresia> actualizarTipoDeMembresiaRequestCommand) {
        var command = actualizarTipoDeMembresiaRequestCommand.getCommand();
        var jugador =  Jugador.from(command.getJugadorId(), retrieveEvents());

        jugador.actualizarTipoDeMembresia(command.getEntityId(), command.getTipo());
        emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));
    }
}
