/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report.TipoEstudios;

import report.material.*;
import modelo.conexion.Conexion;
import java.io.File;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jeis
 */
public class reporteTipoEstudio {
    
    private static final Conexion miConexion = Conexion.saberEstado();
    
    String ruta;
    
    public void generarReporte() {

        try {

            File miDir = new File(".");
            try {
                System.out.println("Directorio actual: " + miDir.getCanonicalPath());
                this.ruta = miDir.getCanonicalPath()
                        +"/src/report/TipoEstudios/reportTipoEstudios.jrxml";
                System.out.println(this.ruta);
            } catch (Exception f) {
                f.printStackTrace();
            }
            
            JasperReport reporte = JasperCompileManager.compileReport(
                    this.ruta);
            JasperPrint jp = JasperFillManager.fillReport(reporte, null, miConexion.obtenerConexion());

            // Para que se vea el reporte.
            JasperViewer.viewReport(jp,false);

        } catch (Exception e1) {

            System.out.println("Error del reporte \n" + e1);
        }
    }
}
