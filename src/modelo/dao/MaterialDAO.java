package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.CRUD;
import modelo.conexion.Conexion;
import modelo.dto.MaterialDTO;
import resources.components.JOptionPaneMenssage;

public class MaterialDAO implements CRUD<MaterialDTO> {

    private static final String SQL_INSERT = "INSERT INTO `materiales`(`nombre`) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM `materiales` WHERE `codigo` = ?;";
    private static final String SQL_UPDATE = "UPDATE `materiales` SET `nombre` = ?, `update_at` = NOW() WHERE `codigo` = ?;";
    private static final String SQL_READ   = "SELECT `codigo`, `nombre` FROM `materiales` WHERE `nombre` = ?;";
    private static final String SQL_READALL= "SELECT `codigo`, `nombre` FROM `materiales` WHERE `is_active` = TRUE;";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;

    @Override
    public boolean Ingresar(MaterialDTO datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setString( 1, datos.getNombre());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("Material registrado exitosamente",
                        "Registro exitoso");

                return true;
            }
            pStatement.close();

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Material DAO: Ingresar \n" 
                            + "Error al registrar un nuevo material. \n",
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
     * @return paciente - Retorna un objeto de tipo Material si encuentra algun
     * resultado. De lo contrario paciente sera null.
     */
    @Override
    public MaterialDTO Consultar(Object key) {

        MaterialDTO paciente = null;
        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {
                paciente
                        = new MaterialDTO(
                                resultados.getInt(1),resultados.getString(2));
            }
            return paciente;
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Material DAO: Consultar \n" 
                            + "Error al intentar consultar el material. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return paciente;
    }

    @Override
    public boolean Actualizar(MaterialDTO datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_UPDATE);
            pStatement.setString(1, datos.getNombre());
            pStatement.setInt(   2, datos.getId());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("El material ha sido actualizado exitosamente",
                        "Actualizacion exitosa");
                return true;
            }

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Material DAO: Actualizar \n" 
                            + "Error al intentar actualizar el material. \n",
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

                JOptionPaneMenssage.Message("Material eliminado exitosamente",
                        "Borrado exitoso");
                return true;
            }
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Material DAO: Eliminar \n" 
                            + "Error al intentar borrar el material. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return false;
    }

    @Override
    public List<MaterialDTO> ConsultarTodos() {

        ArrayList<MaterialDTO> materiales = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL);

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                materiales.add(new MaterialDTO(resultados.getInt(1), resultados.getString(2)));
            }
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Material DAO: ConsultarTodos \n" 
                            + "Error al intentar consultar todos los materiales. \n",
                                e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }
        return materiales;
    }

}
