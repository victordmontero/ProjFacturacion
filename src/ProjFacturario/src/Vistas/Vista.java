/*
 * Clase de la cual todo JFrame debe heredar
 */
package Vistas;

import Controladores.Controlador;
import javax.swing.JFrame;
/**
 *
 * @author Phenom
 */
public abstract class Vista<C extends Controlador> extends JFrame{
    /**
     * Referencia al controlador a la cual esta vista
     * esta asociada.
     */
    private C controlador;

    public C getControlador() {
        return controlador;
    }

    public void setControlador(C controlador) {
        this.controlador = controlador;
    }
    
    
}
