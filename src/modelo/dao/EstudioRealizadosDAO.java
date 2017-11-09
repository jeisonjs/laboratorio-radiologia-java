package modelo.dao;

import interfaces.CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;
import modelo.dto.EstudiosRealizadosDTO;
import resources.components.JOptionPaneMenssage;

public class EstudioRealizadosDAO implements CRUD<EstudiosRealizadosDTO> {

    private static final String SQL_READ_X_PAC  = "SELECT realiza.codigo,`fecha`,paciente.nombre,estudio.nombre,`costoFinal`\n" +
                                                  "FROM( `realiza`LEFT JOIN paciente ON realiza.cedula = paciente.cedula)\n" +
                                                  "LEFT JOIN estudio ON realiza.codEstudio = estudio.codigo\n" +
                                                  "WHERE paciente.cedula = ? ORDER BY realiza.fecha desc";
    /*private static final String SQL_READ_X_EST  = "SELECT `fecha`,paciente.nombre,estudio.nombre,`costoFinal`\n" +
                                                  "FROM( `realiza`LEFT JOIN paciente ON realiza.cedula = paciente.cedula)\n" +
                                                  "LEFT JOIN estudio ON realiza.codEstudio = estudio.codigo\n" +
                                                  "WHERE codEstudio = ?\n" +
                                                  "ORDER BY realiza.fecha desc";*/
    private static final String SQL_READ_X_DATE = "SELECT `fecha`, paciente.nombre, estudio.nombre,`costoFinal` \n" +
                                                  "FROM `realiza` \n" +
                                                  "INNER JOIN paciente USING(`cedula`)\n" +
                                                  "INNER JOIN estudio  USING(codigo)\n" +
                                                  "WHERE fecha >= ? AND fecha <= ?;";
    private static final String SQL_READ_X_ALL  = "SELECT `fecha`,paciente.nombre,estudio.nombre,`costoFinal`\n" +
                                                  "FROM( `realiza`LEFT JOIN paciente ON realiza.cedula = paciente.cedula)\n" +
                                                  "LEFT JOIN estudio ON realiza.codEstudio = estudio.codigo\n" +
                                                  "ORDER BY realiza.fecha desc";
    private static final String SQL_READ_X_EST  = "SELECT `fecha`, estudio.nombre,COUNT(`codEstudio`), SUM(`costoFinal`)\n" +
                                                  "FROM( `realiza`LEFT JOIN paciente ON realiza.cedula = paciente.cedula)\n" +
                                                  "LEFT JOIN estudio ON realiza.codEstudio = estudio.codigo\n" +
                                                  "WHERE estudio.codigo = ?\n" +
                                                  "ORDER BY realiza.fecha desc";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;
    
    
    @Override
    public List<EstudiosRealizadosDTO> ConsultarTodos() {

        ArrayList<EstudiosRealizadosDTO> estudiosRealizados = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ_X_ALL);

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                estudiosRealizados.add(new EstudiosRealizadosDTO(
                                resultados.getString(1),resultados.getString(2),
                                resultados.getString(3),resultados.getInt(4)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "EstudiosRealizados DAO: ConsultarTodos \n" + "Error al intentar consultar todos los estudiosRealizadoss. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return estudiosRealizados;
    }
    
    public List<EstudiosRealizadosDTO> ConsultarTodosXPaciente(Object key) {

        ArrayList<EstudiosRealizadosDTO> estudiosRealizados = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ_X_PAC);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                estudiosRealizados.add(new EstudiosRealizadosDTO(
                                resultados.getInt(1),   resultados.getString(2),
                                resultados.getString(3),resultados.getString(4),
                                resultados.getInt(5)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "EstudiosRealizados DAO: ConsultarTodos \n" + "Error al intentar consultar todos los estudiosRealizadoss. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return estudiosRealizados;
    }

    public List<EstudiosRealizadosDTO> ConsultarTodosXEstudio(Object key) {

        ArrayList<EstudiosRealizadosDTO> estudiosRealizados = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ_X_EST);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                estudiosRealizados.add(new EstudiosRealizadosDTO(
                                resultados.getString(1),resultados.getString(2),
                                resultados.getInt(3),resultados.getInt(4)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "EstudiosRealizados DAO: ConsultarTodos \n" + "Error al intentar consultar todos los estudiosRealizadoss. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return estudiosRealizados;
    }
    
    public List<EstudiosRealizadosDTO> ConsultarTodosXFechas(String fechaINI, String fechaFIN) {

        ArrayList<EstudiosRealizadosDTO> estudiosRealizados = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(
                        SQL_READ_X_DATE);
            pStatement.setString(1, fechaINI.toString());
            pStatement.setString(2, fechaFIN.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                estudiosRealizados.add(new EstudiosRealizadosDTO(
                                resultados.getString(1),resultados.getString(2),
                                resultados.getString(3),resultados.getInt(4)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "EstudiosRealizados DAO: ConsultarTodos \n" + "Error al intentar consultar todos los estudiosRealizadoss. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return estudiosRealizados;
    }
    
    public List<EstudiosRealizadosDTO> ConsultarTodos(Object key) {

        ArrayList<EstudiosRealizadosDTO> estudiosRealizados = new ArrayList<>();

        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ_X_PAC);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {

                estudiosRealizados.add(new EstudiosRealizadosDTO(
                                resultados.getString(1),resultados.getString(2),
                                resultados.getString(3),resultados.getInt(4)));
            }

        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "EstudiosRealizados DAO: ConsultarTodos \n" + "Error al intentar consultar todos los estudiosRealizadoss. \n",
                    e.getMessage(), "SQLException");
        } finally {

            miConexion.Desconectar();
        }

        return estudiosRealizados;
    }
   
    
    @Override
    public boolean Ingresar(EstudiosRealizadosDTO datos) {return false;}
    
    @Override
    public boolean Actualizar(EstudiosRealizadosDTO datos) {return false;}
    
    @Override
    public EstudiosRealizadosDTO Consultar(Object key) {return new EstudiosRealizadosDTO();}

    @Override
    public boolean Eliminar(Object key) { return false;}
}
