package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.ActualizarNombreDeJugador;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeEquipamiento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarNombreDeJugadorUseCase extends UseCase<RequestCommand<ActualizarNombreDeJugador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeJugador> actualizarNombreDeJugadorRequestCommand) {
        var command = actualizarNombreDeJugadorRequestCommand.getCommand();
        var jugador =  Jugador.from(command.getJugadorId(), retrieveEvents(command.getJugadorId().value()) );

        jugador.actualizarNombreDeJugador(command.getJugadorId(), command.getNombre());
        emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));
    }
}
