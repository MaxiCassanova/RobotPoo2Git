package ar.edu.POO2.exceptions;
import ar.edu.POO2.robot.Comando;

public class ExceedsMaximumCommandsExeption extends RuntimeException {
    
    public ExceedsMaximumCommandsExeption() {
        super("No se puede crear mas de " + Comando.MAX_COMANDOS + " comandos");
    }
    
}
