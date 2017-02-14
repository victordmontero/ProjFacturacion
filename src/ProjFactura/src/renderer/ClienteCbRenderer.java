/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import projfactura.Modelos.Cliente;

/**
 *
 * @author Phenom
 */
public class ClienteCbRenderer implements ListCellRenderer {

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
        try {
            JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(jlist, e, i, bln, bln1);
            Cliente c = (Cliente) e;

            renderer.setText(c.RNC + "-" + c.Nombre);

            return renderer;
        } catch (Exception ex) {
            JLabel jl = new JLabel();
            jl.setText("");
            return jl;
        }
    }

}
