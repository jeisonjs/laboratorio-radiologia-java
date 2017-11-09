package modelo.dto;

public class UsuarioDTO {

	private int    idUsuario;
	private String nombre;
	private String contrasena;
	
	private int    idTipoUsuario;
	private String tipo_de_Usuario;
	
	
	public UsuarioDTO(int idUsuario) {
		
		this.idUsuario = idUsuario;
	}


	public UsuarioDTO(String nombre) {
		
		this.nombre = nombre;
	}

	public UsuarioDTO(int idTipoUsuario, String tipo_de_Usuario) {
		
		this.idTipoUsuario = idTipoUsuario;
		this.tipo_de_Usuario = tipo_de_Usuario;
	}

	public UsuarioDTO(String nombre, String tipo_de_Usuario) {
		
		this.nombre = nombre;
		this.tipo_de_Usuario = tipo_de_Usuario;
	}

	public UsuarioDTO(int idUsuario, String nombre, String contrasena) {
		
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public UsuarioDTO(String nombre, String contrasena, String tipo_de_Usuario) {
		
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.tipo_de_Usuario = tipo_de_Usuario;
	}
	
	public UsuarioDTO(String nombre, String contrasena, int idTipoUsuario) {
		
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.idTipoUsuario = idTipoUsuario;
	}

	public UsuarioDTO(int idUsuario, String nombre, String contrasena, String tipo_de_Usuario) {
		
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.tipo_de_Usuario = tipo_de_Usuario;
	}

	public final Object[] toArray(){
        Object[] datos = new Object[5];
        
        //datos[0] = this.idUsuario;
        datos[0] = this.nombre;
        datos[1] = this.tipo_de_Usuario;
        
        return datos;
    }

	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipo_de_Usuario() {
		return tipo_de_Usuario;
	}

	public void setTipo_de_Usuario(String tipo_de_Usuario) {
		this.tipo_de_Usuario = tipo_de_Usuario;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
}
