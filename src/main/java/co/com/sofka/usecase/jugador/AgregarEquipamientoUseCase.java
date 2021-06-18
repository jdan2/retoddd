package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.AgregarEquipamiento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEquipamientoUseCase extends UseCase<RequestCommand<AgregarEquipamiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEquipamiento> agregarEquipamientoRequestCommand) {
        var command = agregarEquipamientoRequestCommand.getCommand();
        var jugador =  Jugador.from(command.getJugadorId(), retrieveEvents(command.getJugadorId().value()));

        jugador.agregarEquipamiento(command.getEntityId(), command.getTipo(), command.getDescripcion(),command.getJugadorId());
        emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));
    }
}
