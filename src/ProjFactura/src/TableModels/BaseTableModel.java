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
public class BaseTableModel<T> extends AbstractTableModel
{
    private List<T> listado;
    private Object[] columnas;

    public BaseTableModel(List<T> elems) 
    {
        super();
        this.listado = elems;
    }

    @Override
    public int getRowCount() {
        return listado.size();
    }

    @Override
    public int getColumnCount() {
        return listado.get(0)
                .getClass()
                .getFields().length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        T p = listado.get(i);
        int num = p.getClass().getDeclaredFields().length;
        this.columnas = new Object[num];
        
        return columnas[i1];
    }

    @Override
    public String getColumnName(int i) {
        return super.getColumnName(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
