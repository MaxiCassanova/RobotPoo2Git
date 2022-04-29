package ar.edu.POO2.TestUnitarios;

import ar.edu.POO2.exceptions.ExceedsTheMaximumGrid;
import ar.edu.POO2.robot.Cuadricula;
import ar.edu.POO2.robot.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCuadricula {
    Cuadricula cuadricula;

    @BeforeEach
    public void setUpBeforeEach(){
        cuadricula = new Cuadricula(10,10);
    }
    @Test
    public void verificarCuadriculaCreadoCorrectamente() {
        assertNotNull(cuadricula);
    }

    @Test
    public void verificarCuadricula(){
        assertInstanceOf(Cuadricula.class, cuadricula);
    }

    @Test
    public void verificarCuadriculaXCorrecta(){
        assertEquals(10, cuadricula.getxColumnaMax());
    }

    @Test
    public void verificarCuadriculaYCorrecta(){
        assertEquals(10, cuadricula.getyFilaMax());
    }

    @Test
    public void arrojaExceedsTheMaximumGridCuandoExcedeX(){
        boolean flag = false;
        try{
            var cuadricula = new Cuadricula(1000,20);
        } catch (ExceedsTheMaximumGrid e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void arrojaExceedsTheMaximumGridCuandoExcedeY(){
        boolean flag = false;
        try{
            var cuadricula = new Cuadricula(20,200);
        } catch (ExceedsTheMaximumGrid e){
            flag = true;
        }
        assertTrue(flag);
    }
}
