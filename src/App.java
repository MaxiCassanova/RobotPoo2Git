import java.io.File;
import java.io.FileWriter;

import ar.edu.POO2.robot.*;

public class App {
    public static void main(String[] args) throws Exception {
        var procesador = new ProcesadorDeDatos();
        procesador.procesarDatos("robot.in");
    }
}
