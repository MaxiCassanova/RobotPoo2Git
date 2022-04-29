package ar.edu.POO2.TestUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.POO2.exceptions.IllegalOrderExeption;
import ar.edu.POO2.exceptions.IllegalOrientationExeption;
import ar.edu.POO2.exceptions.IllegalStartingPosition;
import ar.edu.POO2.exceptions.InvalidCommandExeption;
import ar.edu.POO2.robot.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRobot {

    private Cuadricula cuadricula;
    private Robot robot;

    @BeforeEach
    public void setUpBeforeEach(){
        cuadricula = new Cuadricula(10, 10);
        robot = new Robot(1,1,'N',cuadricula);
    }

    @Test
    public void verificarRobotCreadoCorrectamente(){
        assertNotNull(robot);
    }

    @Test
    public void verificarRobot(){
        assertInstanceOf(Robot.class, robot);
    }

    @Test
    public void verificarRotarValidoNoRotar(){
        var comando = new Comando('R',0);
        robot.procesarComando(comando);
        assertEquals('N', robot.getOrientacion());
    }

    @Test
    public void verificarRotarValidoEsteDesdeNorte(){
        var comando = new Comando('R',1);
        robot.procesarComando(comando);
        assertEquals('E', robot.getOrientacion());
    }

    @Test
    public void verificarRotarValidoSurDesdeNorte(){
        var comando = new Comando('R',2);
        robot.procesarComando(comando);
        assertEquals('S', robot.getOrientacion());
    }

    @Test
    public void verificarRotarValidoOesteDesdeNorte(){
        var comando = new Comando('R',3);
        robot.procesarComando(comando);
        assertEquals('O', robot.getOrientacion());
    }

    @Test
    public void verificarRotarValidoVueltaCompleta(){
        var comando = new Comando('R',4);
        robot.procesarComando(comando);
        assertEquals('N', robot.getOrientacion());
    }

    @Test
    public void verificarAvanzarValidoHaciaNorte(){
        var comando = new Comando('A',5);
        robot.procesarComando(comando);
        assertEquals(6, robot.getYFila());
    }

    @Test
    public void verificarAvanzarValidoHaciaEste(){
        var comandoRotar = new Comando('R',1);
        var comandoAvanzar = new Comando('A',5);
        robot.procesarComando(comandoRotar);
        robot.procesarComando(comandoAvanzar);
        assertEquals(6, robot.getXColumna());
    }

    @Test
    public void verificarAvanzarValidoHaciaSur(){
        var comando = new Comando('A',5);
        robot.procesarComando(comando);
        var comandoRotar = new Comando('R',2);
        var comandoAvanzar = new Comando('A',3);
        robot.procesarComando(comandoRotar);
        robot.procesarComando(comandoAvanzar);
        assertEquals(3, robot.getYFila());
    }

    @Test
    public void verificarAvanzarValidoHaciaOeste(){
        var comandoRotar = new Comando('R',1);
        var comando = new Comando('A',5);
        var comandoRotarOeste = new Comando('R',2);
        var comandoAvanzar = new Comando('A',3);
        robot.procesarComando(comandoRotar);
        robot.procesarComando(comando);
        robot.procesarComando(comandoRotarOeste);
        robot.procesarComando(comandoAvanzar);
        assertEquals(3, robot.getXColumna());
    }

    @Test
    public void arrojaIllegalStartingPositionExceptionConX0oMenor(){
        boolean flag = false;
        try{
            var r = new Robot(0,1,'N', cuadricula);
        } catch (IllegalStartingPosition e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void arrojaIllegalStartingPositionExceptionConY0oMenor(){
        boolean flag = false;
        try{
            var r = new Robot(1,-1,'N',cuadricula);
        } catch (IllegalStartingPosition e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void arrojaIllegalStartingPositionExceptionConXmayorAlMaximo(){
        boolean flag = false;
        try{
            var r = new Robot(11,1,'N',cuadricula);
        } catch (IllegalStartingPosition e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void arrojaIllegalStartingPositionExceptionConYmayorAlMaximo(){
        boolean flag = false;
        try{
            var r = new Robot(1,11,'N',cuadricula);
        } catch (IllegalStartingPosition e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void arrojaIllegalOrientationExeptionPorCaracterErroneo(){
        boolean flag = false;
        try{
            var r = new Robot(1,1,'I',cuadricula);
        } catch (IllegalOrientationExeption e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void noPasaElMaximoDeCuadriculaEnY(){
        robot.procesarComando(new Comando('A', 9));
        robot.procesarComando(new Comando('A', 9));
        assertEquals(10, robot.getYFila());
    }

    @Test
    public void noPasaElMaximoDeCuadriculaEnX(){
        robot.procesarComando(new Comando('R', 1));
        robot.procesarComando(new Comando('A', 9));
        robot.procesarComando(new Comando('A', 9));
        assertEquals(10, robot.getXColumna());
    }

    @Test
    public void noPasaElMinimoDeCuadriculaEnX(){
        robot.procesarComando(new Comando('R', 2));
        robot.procesarComando(new Comando('A', 9));
        robot.procesarComando(new Comando('A', 9));
        assertEquals(1, robot.getXColumna());
    }

    @Test
    public void noPasaElMinimoDeCuadriculaEnY(){
        robot.procesarComando(new Comando('R', 3));
        robot.procesarComando(new Comando('A', 9));
        robot.procesarComando(new Comando('A', 9));
        assertEquals(1, robot.getYFila());
    }

}
