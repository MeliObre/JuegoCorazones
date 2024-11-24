package ar.edu.unlu.corazones.modelo;

public class Carta {
    private Palo palo;
    private int valor;
    public Carta (Palo palo,int valor){
        if (valor < 1 || valor >13){
            throw new IndexOutOfBoundsException("El valor de la carta debe ser entre 1 y 13");
        }
        this.palo=palo;
        this.valor=valor;
    }
    public Palo getPalo(){
        return palo;
    }
    public int getValor(){
        return valor;
    }
    //Metodo que va a devolver el valor en puntos segun las reglas
    //public int obtenerValor(){
      //  if (palo==Palo.CORAZONES){
        //    return 1;
        //}else if (palo==Palo.PICAS && valor ==12){
          //  return 13;
        //}
        //return 0; //las otras cartas no suman puntos
    //}
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
        return nombreValor + " de " + palo.toString().toLowerCase();
    }

    // Compara si dos cartas son iguales (mismo palo y valor)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carta carta = (Carta) obj;
        return valor == carta.valor && palo == carta.palo;
    }

    // Generar un hashcode único basado en el palo y el valor
    @Override
    public int hashCode() {
        int result = palo.hashCode();
        result = 31 * result + valor;
        return result;
    }
}

