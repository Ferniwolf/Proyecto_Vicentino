package Herramientas;




import java.sql.*;
import javax.swing.*;
/**
 *
 * @author luis
 */
public class conectar {
    Connection conect = null;
    public Connection conexion(){
        try {
            // Conectamos el driver con SQL 
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/albergue_sanvicente?useSSL=false","root","");
           // JOptionPane.showMessageDialog(null, "Conectado!");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la operación de conexión con Base de Datos"+ e);
        }
    return conect;
    }
    
}
