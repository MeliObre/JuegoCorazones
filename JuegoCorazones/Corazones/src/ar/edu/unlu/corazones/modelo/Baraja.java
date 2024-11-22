package ar.edu.unlu.corazones.modelo;
import java.util.ArrayList;
import java.util.Collections;
public class Baraja {
    private ArrayList<Carta> cartas;
    public Baraja() {
        this.cartas = new ArrayList<>();
    }

    // Crear la baraja de cartas francesas
    public void crearBaraja() {
        this.cartas.clear();
        for (Palo palo : Palo.values()) {
            for (int valor = 1; valor <= 13; valor++) { // Valores del 1 al 13 (As a Rey)
                this.cartas.add(new Carta(palo, valor));
            }
        }
    }

    // Mezclar la baraja
    public void barajar() {
        Collections.shuffle(this.cartas);
    }

    // Repartir cartas
    public ArrayList<ArrayList<Carta>> repartir(int numeroDeJugadores) {
        if (numeroDeJugadores <= 0) {
            throw new IllegalArgumentException("El número de jugadores debe ser mayor que cero.");
        }

        // Inicializar las manos de los jugadores
        ArrayList<ArrayList<Carta>> manos = new ArrayList<>();
        for (int i = 0; i < numeroDeJugadores; i++) {
            manos.add(new ArrayList<>());
        }

        // Repartir cartas una por una a cada jugador
        int jugadorActual = 0;
        while (!cartas.isEmpty()) {
            Carta carta = cartas.remove(0); // Tomar la primera carta
            manos.get(jugadorActual).add(carta);
            jugadorActual = (jugadorActual + 1) % numeroDeJugadores; // Siguiente jugador
        }

        return manos;
    }

    // Obtener el tamaño de la baraja
    public int getCantidadCartas() {
        return this.cartas.size();
    }

    // Mostrar todas las cartas
    public void mostrarCartas() {
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

}
