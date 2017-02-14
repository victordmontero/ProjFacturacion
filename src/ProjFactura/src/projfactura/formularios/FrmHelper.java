/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.formularios;

import java.util.function.Predicate;
import javax.swing.JFrame;

/**
 *
 * @author VDMontero
 */
public abstract class FrmHelper<T> extends JFrame{
    public abstract void Cargar();
    public abstract void Cargar(Predicate<T> pre);
}
