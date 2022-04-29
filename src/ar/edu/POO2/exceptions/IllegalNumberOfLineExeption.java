package ar.edu.POO2.exceptions;

public class IllegalNumberOfLineExeption extends RuntimeException {
    
    public IllegalNumberOfLineExeption() {
        super("El archivo de entrada debe tener 2 lineas");
    }
    
    
}
