/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import java.util.List;
import projfactura.Modelos.Producto;

/**
 *
 * @author VDMontero
 */
public class ProductoTableModel extends BaseTableModel<Producto> {

    public ProductoTableModel(List<Producto> elems) {
        super(elems);
    }

    @Override
    public int getColumnCount() {
        try {
            return Class.forName("projfactura.Modelos.Producto")
                    .getDeclaredFields().length;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String getColumnName(int column) {
        try {
            return Class.forName("projfactura.Modelos.Producto")
                    .getDeclaredFields()[column].getName();
        } catch (Exception e) {
            return "";
        }
    }
    
    
}
