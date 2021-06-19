package co.com.sofka.usecase.partida;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.ActualizarEmailDeJugador;
import co.com.sofka.bolera.partida.Partida;
import co.com.sofka.bolera.partida.commands.ActualizarCapacidadPartida;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarCapacidadPartidaUseCase extends UseCase<RequestCommand<ActualizarCapacidadPartida>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCapacidadPartida> actualizarCapacidadPartidaRequestCommand) {
        var command = actualizarCapacidadPartidaRequestCommand.getCommand();
        var partida =  Partida.from(command.getPartidaId(), retrieveEvents(command.getPartidaId().value()) );

        partida.actualizarCapacidadDePartida(command.getPartidaId(), command.getCapacidad());
        emit().onResponse(new ResponseEvents(partida.getUncommittedChanges()));
    }
}
