package co.com.sofka.usecase.partida;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.CrearJugador;
import co.com.sofka.bolera.partida.Partida;
import co.com.sofka.bolera.partida.commands.CrearPartida;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPartidaUseCase extends UseCase<RequestCommand<CrearPartida>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPartida> crearPartidaRequestCommand) {
        var command = crearPartidaRequestCommand.getCommand();
        var partida = new Partida(command.getPartidaId(), command.getCapacidad());
        emit().onResponse(new ResponseEvents(partida.getUncommittedChanges()));
    }
}
