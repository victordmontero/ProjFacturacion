/**
 * Aplicacion MVC.
 * Por cada controlador se debe crear una vista
 * y pasar la vista al controlador y luego pasar el controlador
 * a la vista
 */

import Controladores.PrincipalControlador;
import Vistas.FrmPrincipal;
import Vistas.Vista;

public class Aplicacion {

    public void InicioSistema() {
        
        PrincipalControlador micontrolador = new PrincipalControlador();
        
        Vista mi_vista = new FrmPrincipal();
        
        mi_vista.setControlador(micontrolador);

        micontrolador.setVista(mi_vista);
        
        mi_vista.setVisible(true);

    }
}
