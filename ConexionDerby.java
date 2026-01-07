/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conexionderby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDerby {

    private static final String URL =
            "jdbc:derby:MiDerbyDB;create=true";

    public static Connection conectar() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa a Apache Derby");
        } catch (SQLException e) {
            System.out.println("Error al conectar con Derby");
            e.printStackTrace();
        }
        return cn;
    }

    // MÉTODO MAIN PARA PROBAR
    public static void main(String[] args) {
        conectar();
    }
}

