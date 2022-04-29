package ar.edu.POO2.robot;

import ar.edu.POO2.exceptions.ExceedsMaximumCommandsExeption;
import ar.edu.POO2.exceptions.IllegalOrderExeption;

public class Comando {

    private char orden;
    private int parametro;
    private static int contador = 0;
    public static final int MAX_COMANDOS = 125;

    {
        if(contador == MAX_COMANDOS) throw new ExceedsMaximumCommandsExeption();
    }

    private Comando(){
        Comando.contador++;
    }

    public Comando(char orden, int parametro) {
        this();
        if(!(orden == 'A' || orden == 'R')) throw new IllegalOrderExeption();
        this.orden = orden;
        this.parametro = parametro;
    }

    public static int getContador() {
        return contador;
    }

    public char getOrden() {
        return orden;
    }

    public int getParametro() {
        return parametro;
    }


    
    
}
