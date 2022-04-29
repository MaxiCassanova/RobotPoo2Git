package ar.edu.POO2.exceptions;

public class DoubleOrientationCharacterException extends RuntimeException {

    public DoubleOrientationCharacterException() {
        super("El caracter de orientacion no puede ser repetido");
    }

}
