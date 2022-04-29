package ar.edu.POO2.exceptions;

import ar.edu.POO2.robot.Cuadricula;

public class ExceedsTheMaximumGrid extends RuntimeException {

    public ExceedsTheMaximumGrid() {
        super("La columna y fila inicial deben ser mayor a 0 y menor a " + Cuadricula.getMAX_ARGUMENT_GRID());
    }

}