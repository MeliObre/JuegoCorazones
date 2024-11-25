import ar.edu.unlu.corazones.vista.VistaGrafica;
import ar.edu.unlu.corazones.controlador.Controlador;
public class CorazonesAppGrafica {
    public static void main(String[] args) {
        // Inicializa la vista y el controlador
        VistaGrafica vista = new VistaGrafica();
        Controlador controlador = new Controlador(vista);
    }
}
