package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerpientesEscalerasTest {

    @Test
    void testPosicionInicial() {
        SerpientesEscaleras juego = new SerpientesEscaleras(2); // Prueba con 2 jugadores
        assertEquals(0, juego.posicionJugadores[0]); // Verificar si la posición del primer jugador se inicializa en 0
        assertEquals(0, juego.posicionJugadores[1]); // Verificar si la posición del segundo jugador se inicializa en 0
    }

    @Test
    public void testLanzarDado() {
        SerpientesEscaleras juego = new SerpientesEscaleras(2);
        for (int i = 0; i < 1000; i++) {
            int resultado = juego.LanzarDado();
            assertTrue(resultado >= 1 && resultado <= 6);
        }
    }

    @Test
    void testConstructor() {
        SerpientesEscaleras juego = new SerpientesEscaleras(4); // Prueba con 4 jugadores
        assertEquals(4, juego.posicionJugadores.length); // Verificar si se inicializa correctamente el arreglo de jugadores
    }

}