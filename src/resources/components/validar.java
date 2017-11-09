package resources.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class validar {
	
	public void numeros(JTextField txt, KeyEvent e){
		Character c=new Character(e.getKeyChar());

		
		if(!EsValidoNum(c)){  
            String texto="";
            for(int i=0;i<txt.getText().length();i++){
               if(EsValidoNum(new Character(txt.getText().charAt(i) ))){
                   texto+=txt.getText().charAt(i);
                }
            }
            txt.setText(texto);
        }
		

	}
	
	public void letras(JTextField txt, KeyEvent e){
		Character c=new Character(e.getKeyChar());
		if(!EsValidoChar(c)){  
        	String texto="";
            for(int i=0;i<txt.getText().length();i++){
               if(EsValidoChar(new Character(txt.getText().charAt(i) ))){
                   texto+=txt.getText().charAt(i);
                }
            }
            txt.setText(texto);
        }
	}
	
    public boolean EsValidoChar(Character caracter){
        
        char c= caracter.charValue();
        if(!(Character.isLetter(c)||c==' '||c==8)){
            
            return false;
        }else{
                return true;
            }
    }
        
    //funcion para validar Numeros
    public boolean EsValidoNum(Character caracter){
        
        char c= caracter.charValue();
        if(!(Character.isDigit(c)||c==' '||c==8)){
            
            return false;
        }else{
            return true;
        }
    }

}
