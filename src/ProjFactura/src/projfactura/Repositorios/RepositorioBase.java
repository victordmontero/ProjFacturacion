/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Repositorios;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author VDMontero
 */
public abstract class RepositorioBase<T> implements IRepositorio<T>{
    Connection conn;

    public RepositorioBase() {
        try {
            String url = "jdbc:derby://localhost:1527/ProjFacturacion";
            String name = "app";
            String pwd = "app";
            conn = DriverManager.getConnection(url, name, pwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
