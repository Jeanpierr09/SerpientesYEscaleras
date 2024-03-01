package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerpientesEscalerasTest {

    @Test
    public void testJuego(){
        SerpientesEscaleras juego = new SerpientesEscaleras(2);
        juego.jugar();
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
    public void testJugadorGanaJuego() {
        SerpientesEscaleras juego = new SerpientesEscaleras(1); // Creamos un juego para un solo jugador
        juego.posicionJugadores[0] = 63; // Colocamos al jugador cerca de la casilla final
        juego.jugar(); // Ejecutamos el juego
        assertEquals(64, juego.posicionJugadores[0], "El jugador debería haber llegado a la casilla final");
    }
}