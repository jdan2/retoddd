package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.ActualizarTipoDeEquipamiento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarTipoDeEquipamientoUseCase extends UseCase<RequestCommand<ActualizarTipoDeEquipamiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoDeEquipamiento> actualizarTipoDeEquipamientoRequestCommand) {
        var command = actualizarTipoDeEquipamientoRequestCommand.getCommand();
        var jugador =  Jugador.from(command.getJugadorId(), retrieveEvents());

        jugador.actualizarTipoDeEquipamiento(command.getEntityId(), command.getTipo());
        emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));
    }
}
