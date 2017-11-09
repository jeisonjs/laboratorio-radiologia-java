package controlador.login;

import vista.VistaPrincipal;
import vista.login.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.LoginDAO;
import modelo.dto.Usuario;

/**
 * Created by jeis on 24/05/17.
 */
public class ControladorLogin implements ActionListener {

    private Login login;
    private VistaPrincipal vistaPrincipal;
    private LoginDAO loginDAO;

    public ControladorLogin(Login login) {
        this.login = login;
        this.loginDAO = new LoginDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getBTNAseptar()) {
            /**
             * Metodo 2: Ejecutas tu consulta enviandole el nombre de usuario
             * como parametro al metodo consultar.
             */
            // Ejecutando la consulta y almacenando su resultado en una variable de tipo UsuarioDTO.
            Usuario resultado = loginDAO.Consultar(this.login.obtenerDatos().getNombre());

            /**
             * Si el nombre de usuario que envias como parametro al metodo
             * consultar no existe te devolvera un "null" (ver metodo Consultar
             * en UsuarioDAO).
             */
            if (resultado != null) {

                if (this.login.obtenerDatos().getNombre().equals(resultado.getNombre()) && 
                        this.login.obtenerDatos().getPassword().equals(resultado.getPassword())) {

                    /**
                     * # Si las dos condiciones son verdaderas muestra el
                     * mensaje de Bienvenida.
                     */
                    JOptionPane.showMessageDialog(null, "Bienvenido " + 
                            this.login.obtenerDatos().getNombre());

                    this.login.dispose();
                    this.vistaPrincipal = new VistaPrincipal();
                    this.vistaPrincipal.setVisible(true);
                } else {

                    /**
                     * # De lo contrario si alguna de las dos condiciones no se
                     * cumple muestra el mensaje de Incorrecto.
                     */
                    JOptionPane.showMessageDialog(null, "Usuario o Contrasena incorrecto");
                }
            } else {

                /**
                 * Si resultado == null, mostrar esto...
                 */
                JOptionPane.showMessageDialog(null, "Usuario no existe. Verifique!");
            }

        }

        if (e.getSource() == this.login.getBtnSalir()) {
            System.exit(0);
        }
    }
}
