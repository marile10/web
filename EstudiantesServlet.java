import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/estudiantes")
public class EstudiantesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            Connection cn = ConexionDerby.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ESTUDIANTE");

            String json = "[";
            while (rs.next()) {
                json += String.format(
                    "{\"id\":%d,\"nombre\":\"%s\",\"fechaNacimiento\":\"%s\"},",
                    rs.getInt("ID"),
                    rs.getString("NOMBRE"),
                    rs.getDate("FECHA_NACIMIENTO")
                );
            }

            if (json.endsWith(",")) {
                json = json.substring(0, json.length() - 1);
            }
            json += "]";

            out.print(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
