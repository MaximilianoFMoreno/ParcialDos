package edu.usal.negocio.dominio;

public class User {

	private String usuario;
	private String contrase�a;
	private int dni;
	private String tipo_usuario;
	
	public User(String id_usuario, String usuario, String contrase�a, int dni) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
		return "Usuario [id_usuario=" + ", usuario=" + usuario + ", contrase�a=" + contrase�a + ", dni="
				+ dni + ", tipo_usuario=" + tipo_usuario + "]";
	}

	
	
	
}
