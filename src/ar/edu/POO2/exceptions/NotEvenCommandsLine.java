package ar.edu.POO2.exceptions;

public class NotEvenCommandsLine extends RuntimeException {

    public NotEvenCommandsLine() {
        super("La linea de comandos debe tener solo pares");
    }

}