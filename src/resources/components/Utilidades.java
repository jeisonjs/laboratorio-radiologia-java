/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resources.components;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Utilidades {

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public static Date enviarFecha(String fecha) throws ParseException {
    
        Date dates = null;
         /**
         * Obteniendo la fecha que recibo como parametro de la consulta SQL y
         * usando SimpleDateFormat para convertir al formato de fecha que acepta
         * el JDateChooser. Luego envio la fecha formateada como un dato de tipo
         * Date al JDateChooser.
         *
         * Respuesta encontrada en San Google
         *
         * @web https://goo.gl/2AU8ww
         */
       
            Date date = new SimpleDateFormat("yyy-MM-dd").parse(fecha);
        return date;
    }
    
    /**
     * Validate given email with regular expression.
     * 
     * @param email
     *            email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validateEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
    
    public static boolean verificarFecha(JDateChooser fechaElegida){
        Date fechaActual=new Date();//Instancia la fecha del sistema
        if(fechaElegida.getDate().getTime()<=fechaActual.getTime()){//Compara si la fecha seleccionada es mayor o igual a la fecha actual
            return true;
        }
        return false;
    }
}
