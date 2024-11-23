package ar.edu.unlu.corazones.modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Jugador {
    private static final long serialVersionUID = 1L;
    private int id;
    public String nombre;
    private int puntaje;
    private ArrayList<Carta>mano;
    private String creado;

    public Jugador(String nombre, int id) {
        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase(); //Cambiar a mayuscula la primera letra
        this.setNombre(nombre);
        this.id = id;
        this.mano = new ArrayList<Carta>();
        this.puntaje = 0;
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.creado = fechaHoraActual.format(formato);
    }
   public void tomarCarta (Carta c){
        mano.add(c);
   }
   public Carta jugarCarta (int i){
        if (i < 0 || i>= mano.size()){
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        return mano.remove(i);
   }
   public Carta getCarta(int i){
        return mano.get(i);
   }
   public void sumarPuntos (int puntos){
        this.puntaje+=puntos;
   }
   public void reiniciarMano(){
        this.mano=new ArrayList<>();
   }
   public boolean esGanador (int puntajeMinimo){
        return this.puntaje==puntajeMinimo;
   }
   public int getPuntaje(){
        return this.puntaje;
   }
   public String getNombre(){
        return this.nombre;
   }
   public void setNombre(String nombre){
        this.nombre=nombre;
   }
   public int getCantidadCartas(){
        return this.mano.size();
   }
   public void recibirCartas (ArrayList<Carta> cartas){
        this.mano.addAll(cartas);
   }
   public String getCreado(){
        return this.creado;
   }
}
