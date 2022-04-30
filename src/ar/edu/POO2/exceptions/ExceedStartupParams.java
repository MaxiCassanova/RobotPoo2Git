package ar.edu.POO2.exceptions;

public class ExceedStartupParams extends RuntimeException{

    public ExceedStartupParams(){
        super("La primera linea tiene datos innecesarios");
    }
}
