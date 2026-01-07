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
import java.sql.PreparedStatement;
import java.sql.Date;

public class Insertar {

    public static void main(String[] args) {
        try {
            Connection cn = ConexionDerby.conectar();

            String sql =
                "INSERT INTO ESTUDIANTE (ID, NOMBRE, FECHA_NACIMIENTO) VALUES (?, ?, ?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, 232177);
            ps.setString(2, "Mariafe");
            ps.setDate(3, Date.valueOf("2005-12-10"));

            ps.executeUpdate();
            System.out.println("✅ Registro insertado");

        } catch (Exception e) {
            System.out.println("❌ Error al insertar");
            e.printStackTrace();
        }
    }
}


