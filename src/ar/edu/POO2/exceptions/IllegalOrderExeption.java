package ar.edu.POO2.exceptions;

public class IllegalOrderExeption extends RuntimeException{
    
    public IllegalOrderExeption() {
        super("La orden ingresada debe ser 'A' o 'R'");
    }
    
    
}
