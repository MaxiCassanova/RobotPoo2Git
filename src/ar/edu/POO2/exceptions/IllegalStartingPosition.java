package ar.edu.POO2.exceptions;

public class IllegalStartingPosition extends RuntimeException{

    public IllegalStartingPosition() {
        super("La posicion inicial debe ser mayor a 0 y menor a el maximo de la cuadricula");
    }
    
    
}
