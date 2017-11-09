/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resources.utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MethodsJTable {

   /**
    * Recibe como parametro un JTable y determina la canatidad de columnas que
    * posee para proceder a eliminar su contenido.
    * @param table
    * @param defaultTableModel 
    */
    public static void cleanJTable(JTable table, DefaultTableModel defaultTableModel) {
        for (int i = 0; i < table.getRowCount(); i++) {
            defaultTableModel.removeRow(i);
            i -= 1;
        }
    }


}
