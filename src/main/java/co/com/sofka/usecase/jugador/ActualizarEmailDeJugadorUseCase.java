package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.ActualizarEmailDeJugador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEmailDeJugadorUseCase extends UseCase<RequestCommand<ActualizarEmailDeJugador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEmailDeJugador> actualizarEmailDeJugadorRequestCommand) {
        var command = actualizarEmailDeJugadorRequestCommand.getCommand();
        var jugador =  Jugador.from(command.getJugadorId(), retrieveEvents(command.getJugadorId().value()) );

        jugador.actualizarEmailDeJugador(command.getJugadorId(), command.getEmail());
        emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));
    }
}
