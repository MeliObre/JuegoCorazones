package ar.edu.unlu.corazones.modelo;
import java.util.ArrayList;
import java.util.List;
public class Ronda {
    private int numero;
    private List<Carta> cartasJugadas; // cartas jugadas durante la ronda, no definido
    private boolean intercambioRealizado;
    private Jugador jugadorInicial;

    public Ronda(int numero,  List<Jugador> jugadores) {
        this.numero = numero;
        this.cartasJugadas = new ArrayList<>();
        this.intercambioRealizado = false;
        this.jugadorInicial = encontrarJugadorInicial(jugadores);
    }
    private Jugador encontrarJugadorInicial(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            for (Carta carta : jugador.getMano()) {
                if (carta.getPalo() == Palo.TREBOLES && carta.getValor() == Valor.DOS) {
                    return jugador;
                }
            }
        }
        return null;
    }

    public void iniciarIntercambio(List<Jugador> jugadores) {
        if (intercambioRealizado || numero == 4) { // la roonda 4 no requiere intercambio
            System.out.println("El intercambio no se realiza en esta ronda.");
            return;
        }

        List<List<Carta>> cartasIntercambiadas = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            cartasIntercambiadas.add(new ArrayList<>());
        }

        // cada jugador selecciona tres cartas para intercambiar
        for (int i = 0; i < jugadores.size(); i++) {
            int destino = determinarDestino(i, jugadores.size());
            List<Carta> cartasSeleccionadas = jugadores.get(i).seleccionarCartasParaIntercambio(3);

            cartasIntercambiadas.get(destino).addAll(cartasSeleccionadas);
        }

        // asigno las cartas intercambiadas a cada jugador
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).recibirCartas(cartasIntercambiadas.get(i));
        }

        intercambioRealizado = true;
        System.out.println("Intercambio de tres cartas realizado para la ronda " + numero);
    }


    private int determinarDestino(int indiceActual, int totalJugadores) {
        switch (numero) {
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

    public void registrarCarta(Carta carta) {
        cartasJugadas.add(carta);
    }
     // calculo los puntajes de los jugadores al final de la ronda.
     public void calcularPuntajes(List<Jugador> jugadores) {
         for (Jugador jugador : jugadores) {
             int puntosRonda = 0;

             // Sumar puntos de las cartas jugadas en esta ronda
             for (Carta carta : cartasJugadas) {
                 if (carta.getPalo() == Palo.CORAZONES) {
                     puntosRonda += 1; // Cada corazón vale 1 punto
                 } else if (carta.getPalo() == Palo.PICAS && carta.getValor() == Valor.REINA) {
                     puntosRonda += 13; // La Reina de Picas vale 13 puntos
                 }
             }

             // sumo los puntos de esta ronda al total acumulado del jugador
             jugador.sumarPuntos(puntosRonda);

             // por el momento, imprimo el puntaje por ronda
             System.out.println("Jugador " + jugador.getNombre() + " sumó " + puntosRonda + " puntos en esta ronda. Total acumulado: " + jugador.getPuntaje());
         }

         // verifico si algún jugador ha alcanzado o superado los 100 puntos, y terminar la partida
         for (Jugador jugador : jugadores) {
             if (jugador.getPuntaje() >= 100) {
                 System.out.println("Termino la terminado " + jugador.getNombre() + " ha alcanzado los 100 puntos.");
             }
         }
     }

    public void finalizarRonda() {
        this.cartasJugadas.clear();
        this.intercambioRealizado = false;
        System.out.println("Ronda " + numero + " finalizada.");
    }

    public int getNumero () {
        return numero;
    }

    public boolean isIntercambioRealizado () {
        return intercambioRealizado;
    }

    public List<Carta> getCartasJugadas () {
        return cartasJugadas;
    }

}
