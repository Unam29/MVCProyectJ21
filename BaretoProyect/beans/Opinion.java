package beans;

public class Opinion {

	String  nombreUsuario;
	String  txt;
	
	public Opinion() {}
	
	public Opinion(String nombreUsuario, String txt) {
		this.nombreUsuario = nombreUsuario;
		this.txt = txt;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}

}
