package ar.edu.unlu.corazones.modelo;

import java.util.List;

// centralizo la lógica que define cómo deben jugarse las rondas y cómo se calculan los puntos,
// intercambios y ganadores, separando esta lógica del resto del juego.
public class Reglas {
    // calcula los puntos de los jugadores al final de una ronda.
    public static void calcularPuntos(List<Jugador> jugadores, List<Carta> cartasJugadas) {
        for (Jugador jugador : jugadores) {
            for (Carta carta : cartasJugadas) {
                // Si la carta es de corazón, sumar 1 punto
                if (carta.getPalo() == Palo.CORAZONES) {
                    jugador.sumarPuntos(1);
                }

                // Si la carta es la dama de picas, sumar 13 puntos
                if (carta.getPalo() == Palo.PICAS && carta.getValor() == 12) {
                    jugador.sumarPuntos(13);
                }
            }
        }
    }

    // metodo que calcula el ganador de la partida.
    public static Jugador calcularGanador(List<Jugador> jugadores) {
        Jugador ganador = jugadores.get(0);

        // El jugador con el menor puntaje es el ganador
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() < ganador.getPuntaje()) {
                ganador = jugador;
            }
        }
        return ganador;
    }

    // verifico si un jugador cumple con la condición de haber ganado la partida
    public static boolean verificarGanador(List<Jugador> jugadores) {
        // Por ejemplo, el primer jugador en llegar a 50 puntos es el perdedor, y por lo tanto el otro jugador gana
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() >= 50) {
                return true;  // Un jugador ha llegado a 50 puntos
            }
        }
        return false;
    }

    // Método que puede ser utilizado para controlar el intercambio de cartas en base a las reglas de la ronda.
    public static void realizarIntercambio(List<Jugador> jugadores, int ronda) {
        for (int i = 0; i < jugadores.size(); i++) {
            int destino = determinarDestino(i, jugadores.size(), ronda);
            // lógica para seleccionar las cartas para el intercambio según las reglas
            // método ya implementado en Ronda (iniciarIntercambio)
        }
    }

    //  determina el destino de las cartas en base a la ronda actual.
    private static int determinarDestino(int indiceActual, int totalJugadores, int numeroRonda) {
        switch (numeroRonda) {
            case 1: // Jugador de la izquierda
                return (indiceActual + 1) % totalJugadores;
            case 2: // Jugador de la derecha
                return (indiceActual - 1 + totalJugadores) % totalJugadores;
            case 3: // Jugador opuesto
                return (indiceActual + totalJugadores / 2) % totalJugadores;
            default: // Ronda 4: Sin intercambio
                return indiceActual;
        }
    }
}
