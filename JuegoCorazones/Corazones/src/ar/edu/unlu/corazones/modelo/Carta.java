package ar.edu.unlu.corazones.modelo;

public class Carta {
    private Palo palo;
    private Valor valor;
    public Carta (Palo palo,Valor valor){
        //if (valor < 1 || valor >13){
          //  throw new IndexOutOfBoundsException("El valor de la carta debe ser entre 1 y 13");
        //}
        this.palo=palo;
        this.valor=valor;
    }
    public Palo getPalo(){
        return palo;
    }
    public Valor getValor(){
        return valor;
    }
    public boolean esPunto() {
        if (palo == Palo.CORAZONES) {
            return true; // las cartas de corazones siempre valen 1 punto
        }
        if (palo == Palo.PICAS && valor == Valor.REINA) {
            return true; //la carta "Q de picas" (dama de picas) suma 13 puntos
        }
        return false;
    }

}

