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

}
