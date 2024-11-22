package ar.edu.unlu.corazones.modelo;
import java.io.Serializable;
public enum Palo implements Serializable {
    CORAZONES("corazones"),TREBOLES("treboles"),DIAMANTES("diamantes"),PICAS("picas");
    private final String nombre;

    Palo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
