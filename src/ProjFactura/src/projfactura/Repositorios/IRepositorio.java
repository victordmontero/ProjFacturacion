/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Repositorios;

import Modelos.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Phenom
 */
public interface IRepositorio<T> {
    
    ArrayList<T> Obtener();

    ArrayList<T> Obtener(Predicate<T> predicado);

    Cliente ObtenerUno(Predicate<T> predicado);

    void Agregar(T entidad);

    void Eliminar(T entidad);
}
