package co.com.sofka.usecase.jugador;

import co.com.sofka.bolera.jugador.Jugador;
import co.com.sofka.bolera.jugador.commands.CrearMembresia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.List;


public class CrearMembresiaUseCase extends UseCase<RequestCommand<CrearMembresia>, ResponseEvents> {

        @Override
        public void executeUseCase(RequestCommand<CrearMembresia> crearMembresiaRequestCommand) {
            var command = crearMembresiaRequestCommand.getCommand();
            var jugador =  Jugador.from(command.getMembresia().jugadorId(), retrieveEvents(command.getMembresia().jugadorId().value()));

            jugador.crearMembresia(command.getMembresia());
            emit().onResponse(new ResponseEvents(jugador.getUncommittedChanges()));

            //var membresia = new Membresia(command.getMembresia().identity(), command.getMembresia().precio(), command.getMembresia().tipo(), command.getMembresia().jugadorId());
            //emit().onResponse(new ResponseEvents((List<DomainEvent>) membresia.jugadorId()));
        }
    }

