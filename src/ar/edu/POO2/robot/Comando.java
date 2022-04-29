package ar.edu.POO2.robot;

public class Comando {

    private char orden;
    private int parametro;
    private static int contador = 0;
    private static final int MAX_COMANDOS = 125;

    {
        if(contador == MAX_COMANDOS) throw new RuntimeException("No se puede crear mas de " + MAX_COMANDOS + " comandos");
    }

    private Comando(){
        Comando.contador++;
    }

    public Comando(char orden, int parametro) {
        this();
        if(!(orden == 'A' || orden == 'R')) throw new IllegalArgumentException("La orden debe ser A(Avanzar) o R(Rotar)");
        this.orden = orden;
        this.parametro = parametro;
    }

    public char getOrden() {
        return orden;
    }

    public int getParametro() {
        return parametro;
    }

    
    
}
