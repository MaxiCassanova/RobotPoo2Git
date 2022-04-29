package ar.edu.POO2.TestUnitarios;

import ar.edu.POO2.exceptions.ExceedsMaximumCommandsExeption;
import ar.edu.POO2.exceptions.IllegalOrderExeption;
import ar.edu.POO2.exceptions.IllegalOrientationExeption;
import ar.edu.POO2.robot.Comando;
import ar.edu.POO2.robot.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestComando {

    @Test
    public void verificarComandoCreadoCorrectamente(){
        var comando = new Comando('A', 10);
        assertNotNull(comando);
    }

    @Test
    public void verificarRobot(){
        var comando = new Comando('A', 10);
        assertInstanceOf(Comando.class, comando);
    }

    @Test
    public void verificarComandoGuardaAvanzarOrdenCorrectamente(){
        var comando = new Comando('A',10);
        assertEquals('A', comando.getOrden());
    }

    public void verificarComandoGuardaRotarOrdenCorrectamente(){
        var comando = new Comando('R', 10);
        assertEquals('R', comando.getOrden());
    }

    @Test
    public void verificarComandoGuardaParametroCorrectamente(){
        var comando = new Comando('A', 15);
        assertEquals(15, comando.getParametro());
    }

    @Test
    public void arrojaExepcionSiExcedeLaCantidadMaximaDeComandos(){
        boolean flag = false;
        Comando comando;
        try{
            for(int i = 0;i<300;i++)
                comando = new Comando('A',5);
        } catch (ExceedsMaximumCommandsExeption e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void arrojaIllegalOrderExceptionSiElCaracterNoEsValido(){
        boolean flag = false;
        try{
            var comando = new Comando('I',5);
        } catch (IllegalOrderExeption e){
            flag = true;
        }
        assertTrue(flag);
    }
}

