package interfaces;

import java.util.List;

public interface CRUD <cualquierCosa> {

	
	public	boolean Ingresar(cualquierCosa datos);
		
	public  boolean Actualizar(cualquierCosa datos);
	
	public  boolean Eliminar(Object key);
	
	

	public  cualquierCosa Consultar(Object key);

	public 	List<cualquierCosa> ConsultarTodos();
	
}
