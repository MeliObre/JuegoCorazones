package ar.edu.unlu.corazones.modelo;

import java.util.List;

// centralizo la logica del juego
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
                if (carta.getPalo() == Palo.PICAS && carta.getValor() == Valor.REINA) {
                    jugador.sumarPuntos(13);
                }
            }
        }
    }


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


    public static boolean verificarGanador(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() >= 100) {
                return true;
            }
        }
        return false;
    }

    public static void realizarIntercambio(List<Jugador> jugadores, int ronda) {
        for (int i = 0; i < jugadores.size(); i++) {
            int destino = determinarDestino(i, jugadores.size(), ronda);
        }
    }

    //  determina el destino de las cartas en base a la ronda actual
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
