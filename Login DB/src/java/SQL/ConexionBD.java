/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sbarr
 */
public class ConexionBD {
    
   private static String url = "jdbc:mysql://127.0.0.1:3307/db_login"; //puedes poner tambien "localhost" en la sección de 127.0.0.1
   private static String usuario = "root";
   private static String contrasena = "admin";
    
//   private static Connection conexion;
//   private static PreparedStatement sentenciaPreparada;
//   private static ResultSet resultado;

    public static Connection conectar () {
       Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e);
        }
        
        return conexion;
    }
    
//    public static void main(String[] args) {
//        
//        try {
//            conexion = conectar ();
//            String consulta = "INSERT INTO usuarios(Cedula, Nombre, Apellido, Contrasena, Usuario_generado_automaticamente) VALUES('111111','sebastian','barrios','123','abc@hotmail.com')";
//            sentenciaPreparada = conexion.prepareStatement(consulta);
//            int i = sentenciaPreparada.executeUpdate();
//            
//            if(i > 0) {
//                System.out.println("Se guardaron los datos exitósamente.");            
//            }else {
//                System.out.println("Error, no se guardaron los datos.");
//            }
//            
//            conexion.close(); 
//        }catch (SQLException e) {
//            System.out.println("Error" + e);
//        }
//    }
}
