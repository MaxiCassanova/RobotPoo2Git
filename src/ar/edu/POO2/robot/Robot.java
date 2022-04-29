package ar.edu.POO2.robot;

public class Robot {

    private int xColumna;
    private int yFila;
    private char orientacion;
    private Cuadricula cuadricula;

    public Robot(int xColumna, int yFila, char orientacion, Cuadricula cuadricula) {
        if(xColumna <= 0 || yFila <= 0) throw new IllegalArgumentException("La columna y fila inicial deben ser mayor a 0");
        if(xColumna > cuadricula.getxColumnaMax()) throw new RuntimeException("La columna inicial no puede ser mayor a al maximo de columnas de la cuadricula: " + cuadricula.getxColumnaMax());
        if(yFila > cuadricula.getyFilaMax()) throw new RuntimeException("La fila inicial no puede ser mayor a al maximo de filas de la cuadricula: " + cuadricula.getyFilaMax());
        this.cuadricula = cuadricula;
        this.xColumna = xColumna;
        this.yFila = yFila;
        if(!(orientacion == 'N' || orientacion == 'S' || orientacion == 'E' || orientacion == 'O')) throw new IllegalArgumentException("La orientacion debe ser N, S, E o O");
        this.orientacion = orientacion;
    }

    public int getXColumna() {
        return xColumna;
    }

    public void setXColumna(int xColumna) {
        this.xColumna = xColumna;
    }

    public int getYFila() {
        return yFila;
    }

    public void setYFila(int yFila) {
        this.yFila = yFila;
    }

    public char getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(char orientacion) {
        this.orientacion = orientacion;
    }

    public Cuadricula getCuadricula() {
        return cuadricula;
    }

    public void setCuadricula(Cuadricula cuadricula) {
        this.cuadricula = cuadricula;
    }

    public void procesarComando(Comando comando) {
        if(comando.getOrden() == 'A') avanzar(comando.getParametro());
        else if(comando.getOrden() == 'R') rotar(comando.getParametro());
        else throw new RuntimeException("El comando no es valido");
    }

    private void avanzar(int posiciones){
        if (posiciones == 0) return;
        switch(this.orientacion){
            case 'N':
                if(this.yFila + posiciones > cuadricula.getyFilaMax()) this.yFila = cuadricula.getyFilaMax();
                else this.yFila += posiciones;
                break;
            case 'S':
                if(this.yFila - posiciones < 1) this.yFila = 1;
                else this.yFila -= posiciones;
                break;
            case 'E':
                if(this.xColumna + posiciones > cuadricula.getxColumnaMax()) this.xColumna = cuadricula.getxColumnaMax();
                else this.xColumna += posiciones;
                break;
            case 'O':
                if(this.xColumna - posiciones < 1) this.xColumna = 1;
                else this.xColumna -= posiciones;
                break;
        }
    }

    private void rotar(int parametro){
        //El parametro debe ser del 0 al 9, cada valor indica 90 grados de rotacion en sentido a las agujas del reloj
        if(parametro < 0 || parametro > 9) throw new IllegalArgumentException("El parametro debe ser del 0 al 9");
        for(int i = 0; i < parametro; i++){
            switch(this.orientacion){
                case 'N':
                    this.orientacion = 'E';
                    break;
                case 'E':
                    this.orientacion = 'S';
                    break;
                case 'S':
                    this.orientacion = 'O';
                    break;
                case 'O':
                    this.orientacion = 'N';
                    break;
            }
        }

    }
}
