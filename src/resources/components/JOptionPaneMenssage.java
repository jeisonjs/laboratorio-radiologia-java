package resources.components;

import javax.swing.JOptionPane;

public class JOptionPaneMenssage {

  public static void Exception_Message(
      String ubicacionMASmensaje, String excepcion, String titulo) {

    System.out.println(ubicacionMASmensaje + excepcion);
    JOptionPane.showMessageDialog(
        null, ubicacionMASmensaje, titulo, JOptionPane.ERROR_MESSAGE);
  }
  
  public static void Message(
      String messageForTheUser, String titulo) {

    System.out.println(messageForTheUser);
    JOptionPane.showMessageDialog(
        null, messageForTheUser, titulo, JOptionPane.INFORMATION_MESSAGE);
  }
}
