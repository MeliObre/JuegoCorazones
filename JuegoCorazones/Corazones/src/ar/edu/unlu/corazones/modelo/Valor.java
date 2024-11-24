package ar.edu.unlu.corazones.modelo;
import java.io.Serializable;
public enum Valor {
    AS("as"),DOS ("dos"), TRES("tres"), CUATRO("cuatro"), CINCO("cinco"), SEIS("seis"), SIETE("siete"), OCHO("ocho"), NUEVE("nueve"), DIEZ("diez"), JOTA("jota"), REINA("reina"), REY("rey");
    private final String nombre;
    Valor(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
