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
    private void crearBaraja(){
        for (Palo palo : Palo.values()){
            for (int valor = 1; valor <=13; valor++){
                cartas.add(new Carta(palo,valor));
            }
        }
    }
    public void barajar(){
        Collections.shuffle(cartas);//mezclo las cartas
    }
    public List<List<Carta>> repartir (int cantidadJugadores){
        if (cantidadJugadores<= 0 || cantidadJugadores>cartas.size()){
            throw new IllegalArgumentException("Número de jugadores inválido.");
        }
        List<List<Carta>> manos = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            manos.add(new ArrayList<>());
        }
        //reparto las cartas equivalentemente
        int jugadorActual = 0;
        for (Carta carta : cartas) {
            manos.get(jugadorActual).add(carta);
            jugadorActual = (jugadorActual + 1) % cantidadJugadores;
        }

        // Vaciar la baraja después de repartir
        cartas.clear();

        return manos;
    }
    // Método para obtener el número de cartas restantes en la baraja."NO SERIA NECESARIO"
    public int getNumeroDeCartas() {
        return cartas.size();
    }

    // Método para obtener la baraja completa (útil para depuración o inspección).
    public List<Carta> getCartas() {
        return cartas;
    }

    // Representación textual de la baraja (útil para depuración).
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Baraja:\n");
        for (Carta carta : cartas) {
            sb.append(carta).append("\n");
        }
        return sb.toString();
    }

}
