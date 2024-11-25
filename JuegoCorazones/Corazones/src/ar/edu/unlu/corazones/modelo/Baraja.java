package ar.edu.unlu.corazones.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private ArrayList<Carta> cartas;
    public Baraja(){
        this.cartas=new ArrayList<>();
        this.crearBaraja();
    }
    //creo la baraja completa con las cartas
    private void crearBaraja() {
        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values()) {
                cartas.add(new Carta(palo, valor));
            }
        }
    }
    public void barajar(){
        Collections.shuffle(cartas);
    }
    public List<List<Carta>> repartir (int cantidadJugadores){
        if (cantidadJugadores<= 0 || cantidadJugadores>cartas.size()){
            throw new IllegalArgumentException("Numero de jugadores invalido.");
        }
        List<List<Carta>> manos = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            manos.add(new ArrayList<>());
        }
        //reparto
        int jugadorActual = 0;
        for (Carta carta : cartas) {
            manos.get(jugadorActual).add(carta);
            jugadorActual = (jugadorActual + 1) % cantidadJugadores;
        }

        // Vaciar la baraja
        cartas.clear();

        return manos;
    }

    public int getNumeroDeCartas() {
        return cartas.size();
    }


    public List<Carta> getCartas() {
        return cartas;
    }


}
