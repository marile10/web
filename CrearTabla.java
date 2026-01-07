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
import java.sql.Statement;

public class CrearTabla {

    public static void main(String[] args) {
        try {
            Connection cn = ConexionDerby.conectar();
            Statement st = cn.createStatement();

            try {
                st.executeUpdate("DROP TABLE ESTUDIANTE");
            } catch (Exception e) {
                // Si no existe, no pasa nada
            }

            String sql = """
                CREATE TABLE ESTUDIANTE (
                    ID INT PRIMARY KEY,
                    NOMBRE VARCHAR(50),
                    FECHA_NACIMIENTO DATE
                )
            """;

            st.executeUpdate(sql);
            System.out.println("✅ Tabla ESTUDIANTE creada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

