package modelo.dao;

import interfaces.CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;
import modelo.dto.SolicitudEstudio;
import resources.components.JOptionPaneMenssage;

public class SolicitudEstudioDAO implements CRUD<SolicitudEstudio> {

    private static final String SQL_INSERT = "INSERT INTO `realiza`(`cedula`,`codEstudio`,`tipoPago`, `costoFinal`,`fecha`) \n" +
                                             "VALUES (?,?,?,?,?);";
    private static final String SQL_DELETE = "";
    private static final String SQL_UPDATE = "";
    private static final String SQL_READ   = "";
    private static final String SQL_READALL= "";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;

    @Override
    public boolean Ingresar(SolicitudEstudio datos) {

        try {

            // Los numeros representan mis signos de interrogacion.
            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_INSERT);
            pStatement.setInt(    1, datos.getCedula());
            pStatement.setInt(    2, datos.getCodigoEstudio());
            pStatement.setString( 3, datos.getTipoPago());
            pStatement.setInt(    4, datos.getCosto());
            pStatement.setString( 5, datos.getFecha());

            // Retornar el valor boolean si esto se ejecuto.
            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("Solicitud de estudio registrado exitosamente",
                        "Registro exitoso");

                return true;
            }

            pStatement.close();

        } catch (SQLException e) {
            JOptionPaneMenssage.Exception_Message(
                    "SolicitudEstudio DAO: Ingresar \n" + "Error al registrar "
                            + "una nueva solicitud de estudio. \n",
                    e.getMessage(), "SQLException");

        } finally {

            miConexion.Desconectar();
        }

        return false;
    }
    
    @Override
    public SolicitudEstudio Consultar(Object key) {return new SolicitudEstudio();}

    @Override
    public boolean Actualizar(SolicitudEstudio datos) {return false;}

    @Override
    public boolean Eliminar(Object key) {

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_DELETE);
            pStatement.setString(1, key.toString());

            if (pStatement.executeUpdate() > 0) {

                JOptionPaneMenssage.Message("SolicitudEstudio eliminado exitosamente",
                        "Borrado exitoso");
                return true;
            }
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "SolicitudEstudio DAO: Eliminar \n" + "Error al intentar borrar el paciente. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }

        return false;
    }

    @Override
    public List<SolicitudEstudio> ConsultarTodos() {

        ArrayList<SolicitudEstudio> pacientes = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READALL);

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

//                pacientes.add(new SolicitudEstudio(resultados.getInt(1), resultados.getInt(2),
//                        resultados.getString(3),resultados.getString(4),resultados.getString(5),
//                        resultados.getString(6),resultados.getString(7),resultados.getString(8),
//                        resultados.getBoolean(9), resultados.getBoolean(10)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "SolicitudEstudio DAO: ConsultarTodos \n" + "Error al intentar consultar todos los pacientes. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return pacientes;
    }

}
