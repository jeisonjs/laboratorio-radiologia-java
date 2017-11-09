/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.Conexion;
import modelo.dto.MaterialDTO;
import resources.components.JOptionPaneMenssage;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UtilizaDAO {

    private static final String SQL_INSERT_UTILIZA = "INSERT INTO `utiliza`(`codMaterial`, `codEstudio`) VALUES (?,?)";
    private static final String SQL_READ = "SELECT materiales.nombre FROM `utiliza` INNER JOIN materiales "
                                     + "ON utiliza.codMaterial = materiales.codigo WHERE `codEstudio` = ?;";
    
    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;
    
     public boolean IngresarTablarealiza(Object codigoMaterial, Object codigoEstudio) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT_UTILIZA);
            pStatement.setInt(1, Integer.parseInt(codigoMaterial.toString()));
            pStatement.setInt(2, Integer.parseInt(codigoEstudio.toString()));

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

//                JOptionPaneMenssage.Message("Tipo de estudio registrado exitosamente",
//                        "Registro exitoso");

                return true;
            }
            pStatement.close();

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Tipo de estudio DAO: Ingresar \n" 
                            + "Error al Ingresar Tabla realiza. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }
     
    public List<MaterialDTO> ConsultarTablaRealiza(Object key) {

        ArrayList<MaterialDTO> materiales = new ArrayList<>();
        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {
                materiales.add(
                        new MaterialDTO(
                                resultados.getString(1)));
            }
            return materiales;
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Tipo de estudio DAO: Consultar \n" 
                            + "Error al intentar Consultar Tabla Realiza"
                            + "indicado. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return materiales;
    }
}
