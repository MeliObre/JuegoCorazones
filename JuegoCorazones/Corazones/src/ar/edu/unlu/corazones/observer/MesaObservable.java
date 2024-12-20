package ar.edu.unlu.corazones.observer;

public interface MesaObservable {
    void agregarObservador(JugadorObserver observador);
    void eliminarObservador(JugadorObserver observador);
    void notificarObservadores(String mensaje);
}
