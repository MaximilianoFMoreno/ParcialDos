package edu.usal.negocio.dominio;


public class Chofer {
	
	private String nombre;
	private String apellido;
	private int dni;
	private String fehca_nacimiento;
	private String nro_telefono;
	private String user_chofer;
	private String contraseña_chofer;
	private String categoria;
	
	public Chofer(String id_chofer, String nombre, String apellido, int dni, String fehca_nacimiento,
			String nro_telefono, String usuario_chofer, String contraseña_chofer, String categoria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fehca_nacimiento = fehca_nacimiento;
		this.nro_telefono = nro_telefono;
		this.user_chofer = usuario_chofer;
		this.contraseña_chofer = contraseña_chofer;
		this.categoria = categoria;
	}

	public Chofer() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getFehca_nacimiento() {
		return fehca_nacimiento;
	}

	public void setFehca_nacimiento(String fehca_nacimiento) {
		this.fehca_nacimiento = fehca_nacimiento;
	}

	public String getNro_telefono() {
		return nro_telefono;
	}

	public void setNro_telefono(String nro_telefono) {
		this.nro_telefono = nro_telefono;
	}

	public String getUsuario_chofer() {
		return user_chofer;
	}

	public void setUsuario_chofer(String usuario_chofer) {
		this.user_chofer = usuario_chofer;
	}

	public String getContraseña_chofer() {
		return contraseña_chofer;
	}

	public void setContraseña_chofer(String contraseña_chofer) {
		this.contraseña_chofer = contraseña_chofer;
	}

	
	public String getId_categoria() {
		return categoria;
	}

	public void setId_categoria(String id_categoria) {
		this.categoria = id_categoria;
		
	}

	
	
	@Override
	public String toString() {
		return "Chofer [id_chofer=" + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fehca_nacimiento=" + fehca_nacimiento + ", nro_telefono=" + nro_telefono + ", usuario_chofer="
				+ user_chofer + ", contraseña_chofer=" + contraseña_chofer	 + "]";
	}

	
	
	
	
}
