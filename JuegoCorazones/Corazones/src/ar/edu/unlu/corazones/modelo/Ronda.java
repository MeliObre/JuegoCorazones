package ar.edu.unlu.corazones.modelo;
import java.util.ArrayList;
import java.util.List;
public class Ronda {
    private int numero; // numero de la ronda
    private List<Carta> cartasJugadas; // cartas jugadas durante la ronda
    private boolean intercambioRealizado;

    public Ronda(int numero) {
        this.numero = numero;
        this.cartasJugadas = new ArrayList<>();
        this.intercambioRealizado = false;
    }

    public void iniciarIntercambio(List<Jugador> jugadores) {
        if (intercambioRealizado || numero == 4) { // Ronda 4 no requiere intercambio
            System.out.println("El intercambio no se realiza en esta ronda.");
            return;
        }

        // creo una lista para almacenar las cartas que se intercambiarán
        List<List<Carta>> cartasIntercambiadas = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            cartasIntercambiadas.add(new ArrayList<>()); // Lista vacía para cada jugador
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
        System.out.println("Intercambio de tres cartas realizado para la ronda " + numero + ".");
    }

    //determino el indice(jugador) a quien se le pasara las cartas
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
            int puntos = 0;

            for (Carta carta : cartasJugadas) {
                if (carta.getPalo() == Palo.CORAZONES) {
                    puntos += 1; // Cada corazón vale 1 punto
                } else if (carta.getPalo() == Palo.PICAS && carta.getValor() == 12) {
                    puntos += 13; // La dama de picas vale 13 puntos
                }
            }

            jugador.sumarPuntos(puntos);
            System.out.println("Jugador " + jugador.getNombre() + " sumó " + puntos + " puntos. Total: " + jugador.getPuntaje());
        }
    }

    public void finalizarRonda() {
        this.cartasJugadas.clear();
        this.intercambioRealizado = false;
        System.out.println("Ronda " + numero + " finalizada.");
    }

    public int getNumero() {
        return numero;
    }

    public boolean isIntercambioRealizado() {
        return intercambioRealizado;
    }

    public List<Carta> getCartasJugadas() {
        return cartasJugadas;
    }

}
