import java.io.File;
import java.io.FileWriter;

import ar.edu.POO2.robot.*;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("src/ar/edu/POO2/robot/comandos.txt");
        // escribir en el archivo de el siguiente string 1 1 N 10 5\nA9R1A2
        FileWriter fw = new FileWriter(file);
        fw.write("1 1 N 10 5\n");
        fw.write("A7R1A5");
        fw.close();
        ProcesadorDeDatos procesador = new ProcesadorDeDatos();
        procesador.procesarDatos("src/ar/edu/POO2/robot/comandos.txt");
    }
}
