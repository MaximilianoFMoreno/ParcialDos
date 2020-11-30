package edu.usal.negocio.dominio;

public class User {

	private String usuario;
	private String contraseña;
	private int dni;
	private String tipo_usuario;
	
	public User(String id_usuario, String usuario, String contraseña, int dni) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.dni = dni;
		this.tipo_usuario = "Chofer";
	}

	public User() {}

	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	
	
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + ", usuario=" + usuario + ", contraseña=" + contraseña + ", dni="
				+ dni + ", tipo_usuario=" + tipo_usuario + "]";
	}

	
	
	
}
