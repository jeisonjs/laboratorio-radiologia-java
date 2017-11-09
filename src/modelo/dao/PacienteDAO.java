package modelo.dao;

import interfaces.CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.dto.Paciente;
import resources.components.JOptionPaneMenssage;

public class PacienteDAO implements CRUD<Paciente> {

    private static final String SQL_INSERT = "INSERT INTO `paciente`(`cedula`, `nombre`, `apellido`, `fechaNac`, `telefono`, \n" +
                                             "`correo`, `genero`, `embarazo`, `alergias`) \n" +
                                             "VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String SQL_DELETE = "DELETE FROM `paciente` WHERE `cedula` = ?;";
    private static final String SQL_UPDATE = "UPDATE `paciente` SET `cedula`=?,`nombre`=?,`apellido`=?,`fechaNac`=?,`telefono`=?,\n" +
                                              "`correo`=?,`genero`=?,`embarazo`=?,`alergias`=?,`update_at`=NOW() \n" +
                                              "WHERE `nHistoria` = ?;";
    private static final String SQL_READ   = "SELECT `nHistoria`, `cedula`, `nombre`, `apellido`, `fechaNac`, YEAR(CURDATE()) - "+ 
                                             "YEAR(`paciente`.`fechaNac`) + IF(\n" +
                                             "DATE_FORMAT(CURDATE(), '%m-%d') > DATE_FORMAT(`paciente`.`fechaNac`, '%m-%d'),\n" +
                                             "0,-1) AS Edad,`telefono`, `correo`, "+
                                             "`genero`, `embarazo`,`alergias` FROM `paciente` WHERE cedula = ?;";
    private static final String SQL_READALL= "SELECT `nHistoria`, `cedula`, `nombre`, `apellido`, `fechaNac`, YEAR(CURDATE()) - "+ 
                                             "YEAR(`paciente`.`fechaNac`) + IF(\n" +
                                             "DATE_FORMAT(CURDATE(), '%m-%d') > DATE_FORMAT(`paciente`.`fechaNac`, '%m-%d'),\n" +
                                             "0,-1) AS Edad,`telefono`, `correo`, "+
                                             "`genero`, `embarazo`, `alergias` FROM `paciente` WHERE `is_active` = TRUE;";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;

    @Override
    public boolean Ingresar(Paciente datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setInt(    1, datos.getCedula());
            pStatement.setString( 2, datos.getNombre());
            pStatement.setString( 3, datos.getApellido());
            pStatement.setString( 4, datos.getFechaNac());
            pStatement.setString( 5, datos.getTelefono());
            pStatement.setString( 6, datos.getCorreo());
            pStatement.setString( 7, datos.getGenero());
            pStatement.setBoolean(8,datos.isEmbarazo());
            pStatement.setBoolean(9,datos.isAlergias());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("Paciente registrado exitosamente",
                        "Registro exitoso");

                return true;
            }

            pStatement.close();

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Paciente DAO: Ingresar \n" + "Error al registrar un nuevo paciente. \n",
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
     * @return paciente - Retorna un objeto de tipo Paciente si encuentra algun
     * resultado. De lo contrario paciente sera null.
     */
    @Override
    public Paciente Consultar(Object key) {

        Paciente paciente = null;
        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {
                paciente
                        = new Paciente(resultados.getInt(1), resultados.getInt(2),
                                resultados.getString(3),resultados.getString(4),
                                resultados.getString(5),resultados.getInt(6), 
                                resultados.getString(7),resultados.getString(8),
                                resultados.getString(9),resultados.getBoolean(10),
                                resultados.getBoolean(11)
                        );
            }
            return paciente;
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Paciente DAO: Consultar \n" + "Error al intentar consultar el paciente. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }

        return paciente;
    }

    @Override
    public boolean Actualizar(Paciente datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_UPDATE);
            pStatement.setInt(    1, datos.getCedula());
            pStatement.setString( 2, datos.getNombre());
            pStatement.setString( 3, datos.getApellido());
            pStatement.setString( 4, datos.getFechaNac());
            pStatement.setString( 5, datos.getTelefono());
            pStatement.setString( 6, datos.getCorreo());
            pStatement.setString( 7, datos.getGenero());
            pStatement.setBoolean(8, datos.isEmbarazo());
            pStatement.setBoolean(9, datos.isAlergias());
            pStatement.setInt(    10,datos.getnHistoria());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("El paciente ha sido actualizado exitosamente",
                        "Actualizacion exitosa");
                return true;
            }

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "Paciente DAO: Actualizar \n" + "Error al intentar actualizar el paciente. \n",
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

                JOptionPaneMenssage.Message("Paciente eliminado exitosamente",
                        "Borrado exitoso");
                return true;
            }
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Paciente DAO: Eliminar \n" + "Error al intentar borrar el paciente. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }

        return false;
    }

    @Override
    public List<Paciente> ConsultarTodos() {

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL);

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                pacientes.add(new Paciente(resultados.getInt(1), resultados.getInt(2),
                                resultados.getString(3),resultados.getString(4),
                                resultados.getString(5),resultados.getInt(6), 
                                resultados.getString(7),resultados.getString(8),
                                resultados.getString(9),resultados.getBoolean(10),
                                resultados.getBoolean(11)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Paciente DAO: ConsultarTodos \n" + "Error al intentar consultar todos los pacientes. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return pacientes;
    }

}
