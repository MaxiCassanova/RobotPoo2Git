package ar.edu.POO2.exceptions;

public class InvalidCommandExeption extends RuntimeException{

    public InvalidCommandExeption() {
        super("El comando ingresado no es valido");
    }
    
    
}
