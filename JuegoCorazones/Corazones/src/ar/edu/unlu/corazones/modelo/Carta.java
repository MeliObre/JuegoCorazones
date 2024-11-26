package ar.edu.unlu.corazones.modelo;

public class Carta {
    private Palo palo;
    private Valor valor;
    public Carta (Palo palo,Valor valor){
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
            return true; //la carta reina de picas suma 13 puntos
        }
        return false;
    }

}

