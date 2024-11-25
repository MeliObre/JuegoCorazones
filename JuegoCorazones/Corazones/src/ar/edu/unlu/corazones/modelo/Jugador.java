package ar.edu.unlu.corazones.modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
   public void recibirCartas (List<Carta> cartas){
        this.mano.addAll(cartas);
   }
   public String getCreado(){
        return this.creado;
   }

    public List<Carta> seleccionarCartasParaIntercambio(int cantidad) { //cantidad son 3, pero lo podria pone como  final int CANTIDAD_A_SELECCIONAR = 3
        if (cantidad > mano.size()) {
            throw new IllegalArgumentException("El jugador no tiene suficientes cartas para intercambiar.");
        }
        //con 4 jugadores no seria necesario verificar la cantidad de cartas, pero si habria mas jugadores si
        List<Carta> cartasSeleccionadas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jugador " + nombre + ", selecciona " + cantidad + " cartas para intercambiar:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Mano actual: ");
            for (int j = 0; j < mano.size(); j++) {
                System.out.println(j + ": " + mano.get(j));
            }
            System.out.print("Elige el índice de la carta " + (i + 1) + ": ");
            int indice = scanner.nextInt();

            if (indice < 0 || indice >= mano.size()) {
                System.out.println("Índice inválido, intenta de nuevo.");
                i--;
            } else {
                cartasSeleccionadas.add(mano.remove(indice));
            }
        }

        return cartasSeleccionadas;

    }

    public List<Carta> getMano() {
        return mano;
    }
}
