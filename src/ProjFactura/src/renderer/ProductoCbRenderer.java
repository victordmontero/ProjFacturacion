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
import projfactura.Modelos.Producto;

/**
 *
 * @author Phenom
 */
public class ProductoCbRenderer implements ListCellRenderer {

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    public ProductoCbRenderer() {
    }

    @Override
    public Component getListCellRendererComponent(JList jlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        try {
            JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(jlist, value, index, isSelected, isSelected);
            Producto p = (Producto) value;
            renderer.setText(p.Descripcion + "-" + p.Precio);
            return renderer;
        } catch (Exception ex) {
            JLabel jl = new JLabel();
            jl.setText("");
            return jl;
        }
    }

}
