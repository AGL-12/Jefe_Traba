package trabas;

public class Jefe extends Empleade {
	private int plus;
	private String nombreDepartamento;

	public Jefe() {
		super();
		this.plus = 250;
	}

	public void setDatos() {
		super.setDatos(nombreDepartamento);
		System.out.println("Introduce el nombre del departamento");
		nombreDepartamento = scanner.next();
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public int getPlus() {
		return plus;
	}

	@Override
	public String toString() {
		return super.toString() + "Jefe [plus=" + plus + ", nombreDepartamento=" + nombreDepartamento + "]"
				+ " sueldo total " + sueldoTotal() + "] ";
	}

	public float sueldoTotalJefe() {
		float sueldoTotalJefe;
		sueldoTotalJefe = super.sueldoTotal() + plus;
		return sueldoTotalJefe;
	}
}