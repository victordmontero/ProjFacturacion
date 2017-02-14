/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Phenom
 */
public abstract class BaseTableModel<T> extends AbstractTableModel {

    private List<T> listado;
    private Object[] columnas;

    public BaseTableModel(List<T> elems) {
        super();
        this.listado = elems;
    }

    @Override
    public int getRowCount() {
        try {
            return listado.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            T p = listado.get(i);
            return p.getClass().getDeclaredFields()[i1].get(p);
        } catch (Exception e) {
            return new Object();
        }
    }

}
