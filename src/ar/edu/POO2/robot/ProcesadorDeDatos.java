package ar.edu.POO2.robot;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.POO2.exceptions.*;

public class ProcesadorDeDatos {

    public ProcesadorDeDatos() {
    }

    public void procesarDatos(String pathInput) {
        BufferedReader br = null;
        Robot robot = null;
        Cuadricula cuadricula = null;
        List<Comando> comandos = null;


        try {
            br = new BufferedReader(new FileReader(new File(pathInput)));

            String linea;
            
            int contador = 1;
            while ((linea = br.readLine()) != null) {

                if (contador == 1) {
                    try {
                        String[] datos = linea.split(" ");
                        if(datos.length > 5) throw new ExceedStartupParams();
                        int xColumna = Integer.parseInt(datos[0]);
                        int yFila = Integer.parseInt(datos[1]);
                        if (datos[2].length() != 1)
                            throw new DoubleOrientationCharacterException();
                        char orientacion = datos[2].charAt(0);
                        int xColumnaMax = Integer.parseInt(datos[3]);
                        int yFilaMax = Integer.parseInt(datos[4]);
                        cuadricula = new Cuadricula(xColumnaMax, yFilaMax);
                        robot = new Robot(xColumna, yFila, orientacion, cuadricula);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Error en el archivo de entrada: Los datos de columnas o filas deben ser numéricos");
                        throw e;
                    } catch (DoubleOrientationCharacterException e) {
                        System.out.println("Error en el archivo de entrada");
                        throw e;
                    } catch (ExceedsTheMaximumGrid e) {
                        System.out.println("La columna y fila inicial deben ser mayor a 0 y menor a " + Cuadricula.getMAX_ARGUMENT_GRID());
                        throw e;
                    } catch (IllegalStartingPosition e) {
                        System.out.println("La posicion inicial debe ser mayor a 0 y menor a el maximo de la cuadricula");
                        throw e;
                    } catch (IllegalOrientationExeption e) {
                        System.out.println("La orientacion debe ser 'N', 'S', 'E' o 'O'");
                        throw e;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Faltan datos en el archivo de entrada");
                        throw e;
                    }
                }

                if (contador == 2) {
                    try {
                        if (linea.length() % 2 != 0)
                            throw new NotEvenCommandsLine();
                        comandos = new ArrayList<Comando>(linea.length() / 2);
                        for (int i = 0; i < linea.length(); i += 2) {
                            char orden = linea.charAt(i);
                            int parametro = Integer.parseInt(linea.substring(i + 1, i + 2));
                            comandos.add(new Comando(orden, parametro));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error en el archivo de entrada: Los datos de comandos deben ser numéricos");
                        throw e;
                    } catch (ExceedsMaximumCommandsExeption e) {
                        System.out.println("Error en el archivo de entrada: Los comandos no pueden exceder el máximo de " + Comando.MAX_COMANDOS);
                        throw e;
                    } catch(NotEvenCommandsLine e) {
                        System.out.println("Error en el archivo de entrada: Los comandos deben ser pares");
                        throw e;
                    } catch (IllegalOrderExeption e) {
                        System.out.println("Error en el archivo de entrada: Los comandos deben ser A o R");
                        throw e;
                    }
                }
                if (contador > 2){
                    System.out.println("El archivo de entrada debe tener 2 lineas");
                    throw new IllegalNumberOfLineExeption();
                }

                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            throw new RuntimeException("Error al leer el archivo");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo");
                    throw new RuntimeException("Error al cerrar el archivo");
                }
            } 
        }
        this.procesarRobot(robot, comandos);
        this.crearArchivoSalida(robot);
    }

    private void procesarRobot(Robot robot, List<Comando> comandos) {
        if(robot == null || comandos == null)
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
        for (Comando comando : comandos) {
            robot.procesarComando(comando);
        }
    }

    private void crearArchivoSalida(Robot robot){
        // el archivo de salida debe ser un archivo .txt, donde debe tener el siguiente formato:
        // columna fila
        // separadas entre si por un espacio

        File file = new File("Robot.out");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo de salida");
            throw new RuntimeException(e);
        }
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(robot.getXColumna() + " " + robot.getYFila());
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de salida");
            throw new RuntimeException(e);
        }
    }

}
