package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.CrearJugador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearJugadorUseCase extends UseCase<RequestCommand<CrearJugador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearJugador> crearJugadorRequestCommand) {
        var command = crearJugadorRequestCommand.getCommand();
        var jugador = new Jugador(command.getEntityId(), command.getNombre(), command.getEmail());
        emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));
    }
}
