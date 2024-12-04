package trabas;

import java.time.LocalDate;
import java.util.Scanner;


public class Empleade implements Comparable<Empleade>{
	// declaracion
	Scanner scanner = new Scanner(System.in);
	private final String NOMBRE_EMPRESA = "Electrica S.A";
	private String dni;
	private String nombre;
	private int mesEntrada;
	private int anioEntrada;
	private float porcentajeIncremento;
	private int sueldoBase;

	// constructor
	public void Empleado() {
		this.sueldoBase = 1000;
	}

	//
	public void setDatos(String dni) {
		this.dni = dni;
		System.out.println("Introduce el nombre");
		nombre = scanner.next();
		System.out.println("Introduce el mes de entrada");
		mesEntrada = scanner.nextInt();
		System.out.println("Introduce el año de entrada");
		anioEntrada = scanner.nextInt();
		System.out.println("Ingresa el porcentaje de incremento salarial");
		porcentajeIncremento = scanner.nextFloat();
	}

	//
	public String getDNI() {
		return dni;
	}

	public void setDNI(String dNI) {
		dni = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMesEntrada() {
		return mesEntrada;
	}

	public void setMesEntrada(int mesEntrada) {
		this.mesEntrada = mesEntrada;
	}

	public int getAnioEntrada() {
		return anioEntrada;
	}

	public void setAnioEntrada(int anioEntrada) {
		this.anioEntrada = anioEntrada;
	}

	public float getPorcentajeIncremento() {
		return porcentajeIncremento;
	}

	public void setPorcentajeIncremento(float porcentajeIncremento) {
		this.porcentajeIncremento = porcentajeIncremento;
	}

	//
	@Override
	public String toString() {
		return "Empleado [NOMBRE_EMPRESA=" + NOMBRE_EMPRESA + ", dni=" + dni + ", nombre=" + nombre + ", mesEntrada="
				+ mesEntrada + ", anioEntrada=" + anioEntrada + ", porcentajeIncremento=" + porcentajeIncremento
				+ ", sueldoBase=" + sueldoBase + " sueldo total " + sueldoTotal() + "]";
	}

	//
	public int antiguedadEmpleado() {
		int antiguedad = 0;
		antiguedad = LocalDate.now().getYear() - anioEntrada;
		if (antiguedad == 6 && LocalDate.now().getMonthValue() < mesEntrada) {
			antiguedad--;
		}
		return antiguedad;
	}

	public float sueldoTotal() {
		float sueldoTotal;
		float incremento;
		int bonus = 100;

		// Calculamos el incremento salarial
		incremento = sueldoBase * (porcentajeIncremento / 100);

		// Calculamos el sueldo total
		sueldoTotal = sueldoBase + incremento;

		// Si la antigüedad es mayor o igual a 6 años, se añade un bono
		if (antiguedadEmpleado() > 6) {

			sueldoTotal += bonus;
		}
		return sueldoTotal;
	}
	@Override
	public int compareTo(Empleade otroEmpleado) {
		return Integer.compare(this.anioEntrada, otroEmpleado.getAnioEntrada());
		// return this.nombre.compareTo(otroEmpleado.getNombre());
	}
}
