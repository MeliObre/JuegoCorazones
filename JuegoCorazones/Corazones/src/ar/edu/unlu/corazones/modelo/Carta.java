package ar.edu.unlu.corazones.modelo;

public class Carta {
    private Palo palo;
    private int valor;

    public Carta(Palo palo, int valor){
        this.palo=palo;
        this.valor=valor;
    }
    public int getValor(){
        return valor;
    }
    //nombre del palo
    public String ontenerNombrePalo(){
        return palo.getNombre();
    }
    //valor de la carta
    public int obtenerValor(){
        return valor;
    }
    //verifico si la carta es un punto (corazon o reina de picas)
    public boolean esPunto(){
        return (this.palo == Palo.CORAZONES) || (this.palo == Palo.PICAS && this.valor == 12); // 12 es la reina
    }
    // Método para representar la carta en formato texto (para impresión)
   // @Override
    //public String toString() {
      //  String valorString;
        //switch (valor) {
          //  case 1: valorString = "As"; break;
            //case 11: valorString = "J"; break;
            //case 12: valorString = "Q"; break;
            //case 13: valorString = "K"; break;
            //default: valorString = String.valueOf(valor);
        //}
        //return valorString + " de " + palo.getNombre();
    @Override
    public String toString() {
        String nombreValor;
        switch (valor) {
            case 1:
                nombreValor = "As";
                break;
            case 11:
                nombreValor = "Jota";
                break;
            case 12:
                nombreValor = "Reina";
                break;
            case 13:
                nombreValor = "Rey";
                break;
            default:
                nombreValor = String.valueOf(valor);
        }
        return nombreValor + " de " + palo.getNombre();
    }
}
