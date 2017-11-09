package modelo.dao;

import interfaces.CRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.dto.Usuario;
import resources.components.JOptionPaneMenssage;

public class LoginDAO implements CRUD<Usuario> {

    private static final String SQL_INSERT = "";
    private static final String SQL_DELETE = "";
    private static final String SQL_UPDATE = "";
    private static final String SQL_READ   = "SELECT * FROM `login` WHERE `usuario` = ?;";
    private static final String SQL_READALL= "";

    private static final Conexion miConexion = Conexion.saberEstado();
    private PreparedStatement pStatement;
    private ResultSet resultados;

    @Override
    public boolean Ingresar(Usuario datos) {
        return false;
    }

    /**
     * Metodo para consultar un usuario segun el parametro que se le indique.
     *
     * @param key - Parametro para usar como condicion en la consulta SQL.
     * @return usuario - Retorna un objeto de tipo Usuario si encuentra algun
     * resultado. De lo contrario usuario sera null.
     */
    @Override
    public Usuario Consultar(Object key) {

        Usuario usuario = null;
        try {

            pStatement = miConexion.obtenerConexion().prepareStatement(SQL_READ);
            pStatement.setString(1, key.toString());

            resultados = pStatement.executeQuery();

            while (resultados.next()) {
                usuario
                        = new Usuario(resultados.getInt(1),
                                resultados.getString(2),resultados.getString(3));
            }
            return usuario;
        } catch (Exception e) {

            JOptionPaneMenssage.Exception_Message(
                    "Usuario DAO: Consultar \n" + "Error al intentar consultar el usuario. \n",
                    e.getMessage(), "SQLException");
        } finally {
            miConexion.Desconectar();
        }

        return usuario;
    }

    @Override
    public List<Usuario> ConsultarTodos() {
        List<Usuario> usuario = null;

        return usuario;
    }
    
    
    @Override
    public boolean Actualizar(Usuario datos) {
        return false;
    }

    @Override
    public boolean Eliminar(Object key) {
        return false;
    }

}
