/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeison Perez
 */
public class Conexion {
    
    private static Conexion instancia;
    //Indicando que use el Driver de MySQL. "dir"
    private final static String direccion = "com.mysql.jdbc.Driver";
    //Colocando el nombre de la BD a conectar. "bd"
    private final static String miBasedDatos = "proyecto_radiodiagnostico";
    // Direccion en donde se encuentra la BD. Usar la misma Variable de Arriba 
    // "miBasedDatos".
    private final static String url = "jdbc:mysql://localhost:3306/"+miBasedDatos;
    private final static String user = "root";
    private final static String pass = "0000";
    // ct
    private Connection miConnection = null;
    
    /*
    * Metodo para saber si ya esta creada una instancia de conexion,
    * si esta creada la utiliza, si no es asi, crea un nuevo objeto de 
    * tipo Conexion.
    * 
    * synchronized: Si se estan realizando muchas peticiones se pondran 
    * en espera.
    */
    public synchronized static Conexion saberEstado(){
        
        if (instancia == null) {
            
            instancia = new Conexion();
        }
        return instancia;
    }
    
    /*
     * El patron DAO me pide que mi constructor Conexion sea de tipo  
     * privado, para que no se puedan crear instancias de tipo conexion 
     * desde afuera.
     */
    private Conexion(){
    
        try{
        
            Class.forName(direccion).newInstance();
             //haga la conexion
            miConnection = DriverManager.getConnection(url,user,pass);
        
            if (miConnection != null){
            	
            	System.out.println("Se ha conectado a la base de datos con exito. :D \n");
            }
            
        }
        catch(Exception e){
           
            System.out.println("No se ha podido conectar a la base de datos. D: \n"+e);
        }
    }
    
    public void Desconectar(){
    
        instancia = null;
        System.out.println("Desconectando de la base de datos... \n");    
    }
    
    // Obtener la conexion creada.
    // Crear los Statement
    public Connection obtenerConexion(){
        return miConnection;
    }
    
    public static void main(String[] args) {
		
    	Conexion c = new Conexion();
	}
}
