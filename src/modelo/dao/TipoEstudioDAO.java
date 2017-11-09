package modelo.dao;

import interfaces.CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.dto.TipoDeEstudio;
import resources.components.JOptionPaneMenssage;

public class TipoEstudioDAO implements CRUD<TipoDeEstudio> {

    private static final String SQL_INSERT = "INSERT INTO `estudio`(`nombre`, `costo`) VALUES (?,?);";
    private static final String SQL_DELETE = "DELETE FROM `estudio` WHERE `codigo` = ?;";
    private static final String SQL_UPDATE = "UPDATE `estudio` SET `nombre` = ?,`costo`= ?,`update_at`= NOW() WHERE `codigo` = ?;";
    private static final String SQL_READ   = "SELECT `codigo`, `nombre`, `costo` FROM `estudio` WHERE `nombre` = ?;";
    private static final String SQL_READALL= "SELECT `codigo`, `nombre`, `costo` FROM `estudio` WHERE `is_active` = TRUE;";
    
    private static final String SQL_READLAST  = "SELECT codigo FROM estudio ORDER BY codigo DESC LIMIT 1";
    
    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;

    @Override
    public boolean Ingresar(TipoDeEstudio datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setString( 1, datos.getNombre());
            pStatement.setInt(    2, datos.getCosto());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("Tipo de estudio registrado exitosamente",
                        "Registro exitoso");

                return true;
            }
            pStatement.close();

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Tipo de estudio DAO: Ingresar \n" 
                            + "Error al registrar un nuevo paciente. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    /**
     * Metodo para consultar un paciente segun el parametro que se le indique.
     *
     * @param key - Parametro para usar como condicion en la consulta SQL.
     * @return paciente - Retorna un objeto de tipo Tipo de estudio si encuentra algun
     * resultado. De lo contrario paciente sera null.
     */
    @Override
    public TipoDeEstudio Consultar(Object key) {

        TipoDeEstudio paciente = null;
        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {
                paciente
                        = new TipoDeEstudio(
                                resultados.getInt(1),resultados.getString(2),
                                resultados.getInt(3));
            }
            return paciente;
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Tipo de estudio DAO: Consultar \n" 
                            + "Error al intentar consultar el tipo de estudio"
                            + "indicado. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return paciente;
    }

    @Override
    public boolean Actualizar(TipoDeEstudio datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_UPDATE);
            pStatement.setString(1, datos.getNombre());
            pStatement.setInt(   2, datos.getCosto());
            pStatement.setInt(   3, datos.getId());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("El tipo de estudio ha sido actualizado "
                        + "exitosamente",
                        "Actualizacion exitosa");
                return true;
            }

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Tipo de estudio DAO: Actualizar \n" 
                            + "Error al intentar actualizar el tipo de estudio. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Object key) {
        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_DELETE);
            pStatement.setString(1, key.toString());

            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("Tipo de estudio eliminado exitosamente",
                        "Borrado exitoso");
                return true;
            }
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Tipo de estudio DAO: Eliminar \n" 
                            + "Error al intentar borrar el estudio. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    @Override
    public List<TipoDeEstudio> ConsultarTodos() {

        ArrayList<TipoDeEstudio> estudios = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL);

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                estudios.add(
                        new TipoDeEstudio(resultados.getInt(1), resultados.getString(2),
                        resultados.getInt(3)));
            }
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Tipo de estudio DAO: ConsultarTodos \n" 
                            + "Error al intentar consultar todos los estudios. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return estudios;
    }
    
    public int obtenerUltimaAsig() {

        int ultimaAsig = 0;

        try {
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READLAST);
            resultados = pStatement.executeQuery();

            while (resultados.next()) {
                ultimaAsig = resultados.getInt(1);
            }
            return ultimaAsig;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al intentar consultar la ultima asignacion. \n" + e, 
                        null, JOptionPane.INFORMATION_MESSAGE);
        } finally {
            miConexion.Desconectar();
        }
        return ultimaAsig;
    }
    
    
}
