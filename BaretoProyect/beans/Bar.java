package beans;

public class Bar {

	int id;
	String nombre;
	String direccion;
	int tipo;
	int telefono;

	public Bar() {
	}

	public Bar(int id, String nombre, String direccion, int tipo, int telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion=direccion;
		this.tipo = tipo;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		
			return this.nombre + " || " + this.direccion + " || " + this.tipo + " || " + "Telefono:"+this.telefono;
				}

}
