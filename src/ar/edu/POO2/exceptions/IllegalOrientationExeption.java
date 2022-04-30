package ar.edu.POO2.exceptions;

public class IllegalOrientationExeption extends RuntimeException{

    public IllegalOrientationExeption(){
        super("La orientacion debe ser 'N', 'S', 'E' o 'O'");
    }
}
