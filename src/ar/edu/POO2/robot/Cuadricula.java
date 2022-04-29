package ar.edu.POO2.robot;

public class Cuadricula {

    private int xColumnaMax;
    private int yFilaMax;
    private static final int MAX_ARGUMENT_GRID = 100;

    public Cuadricula(int xColumnaMax, int yFilaMax) {
        if (xColumnaMax <= 0 || yFilaMax <= 0) {
            throw new IllegalArgumentException("La columna y fila inicial deben ser mayor a 0");
        }
        if (xColumnaMax >= MAX_ARGUMENT_GRID || yFilaMax >= MAX_ARGUMENT_GRID) {
            throw new IllegalArgumentException("La columna y fila inicial deben ser menor a " + MAX_ARGUMENT_GRID);
        }
        this.xColumnaMax = xColumnaMax;
        this.yFilaMax = yFilaMax;
    }

    public int getxColumnaMax() {
        return xColumnaMax;
    }

    public void setxColumnaMax(int xColumnaMax) {
        this.xColumnaMax = xColumnaMax;
    }

    public int getyFilaMax() {
        return yFilaMax;
    }

    public void setyFilaMax(int yFilaMax) {
        this.yFilaMax = yFilaMax;
    }

    public static int getMAX_ARGUMENT_GRID() {
        return MAX_ARGUMENT_GRID;
    }
    
    
}
