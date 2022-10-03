/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sbarr
 */ 
public class MetodosSQL {

    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultado;

    public boolean registrarUsuario(String Cedula, String Nombre, String Apellido, String Contrasena, String usuarioGeneradoAutomaticamente) {
        boolean registro = false;
        try {
            conexion = ConexionBD.conectar();
            String consulta = "INSERT INTO usuarios (Cedula,Nombre,Apellido,Contrasena,Usuario_generado_automaticamente) VALUES (?,?,?,?,?)";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, Cedula);              
            sentenciaPreparada.setString(2, Nombre);
            sentenciaPreparada.setString(3, Apellido);
            sentenciaPreparada.setString(4, Contrasena);
            sentenciaPreparada.setString(5, usuarioGeneradoAutomaticamente);

            int resultadoInsercion = sentenciaPreparada.executeUpdate();

            if (resultadoInsercion > 0) {
                registro = true; //el usuario se ha registrado
                System.out.println("Se hizo el alta del usuario");
            } else {
                registro = false; // el usuario no se ha registrado
                System.out.println("No se hizo el alta del usuario");
            }

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {

            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }

        System.out.println("Valor del registro: " + registro);
        return registro;

    }
    
    public boolean buscarUsuarioRepertidoBD(String Cedula){
        boolean usuarioRepetido =false;
            try {
                conexion = ConexionBD.conectar();
                String consulta = "SELECT Cedula From usuarios WHERE Cedula = ?";
                sentenciaPreparada = conexion.prepareStatement(consulta);
                sentenciaPreparada.setString(1, Cedula);
                resultado = sentenciaPreparada.executeQuery();
                
                if (resultado.next()) {
                    usuarioRepetido = true; //usuario registrado en la base de datos
                } else{}
                    usuarioRepetido = false; // usuario NO registrado en la base de datos
                conexion.close();
            } catch (SQLException e) {
                    System.out.println("Error: " + e);
            }finally {
                    try {
                        conexion.close();
                    } catch (SQLException e) {
                        System.out.println("Error: " + e);
                    }

                }
        System.out.println("El valor del usuario Repetido en el METODO es:"+ usuarioRepetido); 
        return usuarioRepetido;
    }
    
    public boolean buscarUsuarioIniciosesion(String usuario, String contrasena){
        boolean iniciarSesion = false;
        
        try {
            conexion = ConexionBD.conectar();
            String consulta = "SELECT Usuario_generado_automaticamente, Contrasena FROM usuarios WHERE Usuario_generado_automaticamente = ? AND Contrasena = ?";
            sentenciaPreparada=conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, usuario);
            sentenciaPreparada.setString(2, contrasena);
            resultado = sentenciaPreparada.executeQuery();
            
            if(resultado.next()) {
                iniciarSesion = true; //usuario puede iniciar sesion ya que esta registrado en la bd
            }else{
                iniciarSesion = false; //usuario NO puede iniciar sesion ya que NO esta registrado en la bd 
            }
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: "+ e );
            }
        }
        
        System.out.println("El valor de iniciarSesion en el metodo es:" +iniciarSesion);
        return iniciarSesion;

    }    

    public String buscarNombre(String usuario) {
        String nombre = null;
        try {
            conexion = ConexionBD.conectar();
            String consulta = "SELECT Nombre FROM usuarios WHERE Usuario_generado_automaticamente = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, usuario);
            resultado = sentenciaPreparada.executeQuery();
            
            if (resultado.next()){ //El usuario se encontro y obtiene el nombre
                nombre = resultado.getString("nombre");
            }else{
                nombre = null; //usuario no encontrado y no esta el nombre
            }
            conexion.close(); 
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: "+ e);
            }
        }
        
        System.out.println("El valor del nombre en los metodos SQL es: " + nombre);
        return nombre;
    }
}
