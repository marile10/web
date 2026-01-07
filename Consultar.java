/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conexionderby;

/**
 *
 * @author maria
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consultar {

    public static void main(String[] args) {
        try {
            Connection cn = ConexionDerby.conectar();
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM ESTUDIANTE");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("ID") + " | " +
                    rs.getString("NOMBRE") + " | " +
                    rs.getDate("FECHA_NACIMIENTO")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al consultar");
            e.printStackTrace();
        }
    }
}

