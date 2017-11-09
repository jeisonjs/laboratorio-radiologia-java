package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.EstudiosRealizados;
import vista.Materiales;
import vista.PacientesRegistrados;
import vista.RegistrarPaciente;
import vista.RegistrarTipoEstudio;
import vista.SolicitarEstudio;
import vista.VistaPrincipal;

/**
 * Created by jeis on 22/05/17.
 */
public class Controlador implements ActionListener {

    private VistaPrincipal VP;
    private RegistrarPaciente RP;
    private SolicitarEstudio SE;
    private Materiales panelMateriales;
    //private RegistroDeEstudios registroDeEstudios;
    private RegistrarTipoEstudio registrarTipoEstudio;
    private EstudiosRealizados estudiosRealizados;
    private PacientesRegistrados pacientesRegistrados;
    private String msj = "Controlador";
    public static boolean ventOpen=false;

    public Controlador(VistaPrincipal VP) {
        this.VP = VP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.VP.getItemRegPaciente()){

            //System.out.println("\u001B[31mControlador: "+"\u001B[34mItem Registrar paciente");
            System.out.println("Item Registrar paciente");

            if (this.RP != null) {//si existe una venta, la cierra.
                this.RP.dispose();
            }
                this.RP = new RegistrarPaciente();
                this.RP.setVisible(true);
        }

        if (e.getSource() == this.VP.getItemSolEstudio()){

            //System.err.print("Controlador: "); System.out.print("Item Solicitar estudio \n");
            System.out.println("Item Solicitar estudio");

            if (this.SE != null) {//si existe una venta, la cierra.
                this.SE.dispose();
            }
                this.SE = new SolicitarEstudio();
                this.SE.setVisible(true);
        }

        if (e.getSource() == this.VP.getItemRegTipoEstudio()){

            //System.err.print("Controlador: "); System.out.print("Item Tipo de estudio \n");
            System.out.println("Item Tipo de estudio");

            if (this.registrarTipoEstudio != null) {//si existe una venta, la cierra.
                this.registrarTipoEstudio.dispose();
            }
            this.registrarTipoEstudio = new RegistrarTipoEstudio();
            this.registrarTipoEstudio.setVisible(true);
        }

        if (e.getSource() == this.VP.getItemMateriales()){

            //System.err.print("Controlador: "); System.out.print("Item Materiales \n");
            System.out.println("Item Materiales");

            if (this.panelMateriales != null) {//si existe una venta, la cierra.
                this.panelMateriales.dispose();
            }
            this.panelMateriales = new Materiales();
            this.panelMateriales.setVisible(true);
        }

        if (e.getSource() == this.VP.getItemHisClientes()){

            //System.err.print("Controlador: "); System.out.print("Item Historial clientes \n");
            System.out.println("Item Historial clientes");

            if (this.pacientesRegistrados != null) {//si existe una venta, la cierra.
                this.pacientesRegistrados.dispose();
            }
            this.pacientesRegistrados = new PacientesRegistrados();
            this.pacientesRegistrados.setVisible(true);
        }

        if (e.getSource() == this.VP.getItemEstRealizados()){

            //System.err.print("Controlador: "); System.out.print("Item Estudios realizados \n");
            System.out.println("Item Estudios realizados");

            if (this.estudiosRealizados != null) {//si existe una venta, la cierra.
                this.estudiosRealizados.dispose();
            }
            this.estudiosRealizados = new EstudiosRealizados();
            this.estudiosRealizados.setVisible(true);
        }

        if (e.getSource() == this.VP.getBtnRegistrar()){

            //System.err.print("Controlador: "); System.out.println("Boton Registrar");
            System.out.println("Boton Registrar");

            if (this.RP != null) {//si existe una venta, la cierra.
                this.RP.dispose();
            }
            this.RP = new RegistrarPaciente();
            this.RP.setVisible(true);
        }

        if (e.getSource() == this.VP.getBtnSolicitar()){

            //System.err.print("Controlador: "); System.out.println("Boton Solicitar");
            System.out.println("Boton Solicitar");

            if (this.SE != null) {//si existe una venta, la cierra.
                this.SE.dispose();
            }
            this.SE = new SolicitarEstudio();
            this.SE.setVisible(true);
        }

        if (e.getSource() == this.VP.getBtnEstudiosRealizados()){

            //System.err.print("Controlador: "); System.out.println("Boton Estudios realizados");
            System.out.println("Boton Estudios realizados");

            if (this.estudiosRealizados != null) {//si existe una venta, la cierra.
                this.estudiosRealizados.dispose();
            }
            this.estudiosRealizados = new EstudiosRealizados();
            this.estudiosRealizados.setVisible(true);
        }
    }

}
