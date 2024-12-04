package utilidades;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utilidades {

	public static String introducirCadena(String mensaje) {
		Scanner teclado = new Scanner(System.in);
		String cadena = null;

		System.out.println(mensaje);
		try {
			cadena = teclado.next();
		} catch (NoSuchElementException e) {
			System.out.println("Error al introducir la cadena");
		}
		return cadena;
	}

	public static String introducirCadenaNada() {
		String cadena = null;

		try {
			cadena = introducirCadena("");
		} catch (NoSuchElementException e) {
			System.out.println("Error al introducir la cadena");
		}

		return cadena;
	}

	public static int introduciNumero(String mensaje) {
		int numero = 0;
		String cadena;
		boolean correcto = true;

		do {
			cadena = introducirCadena(mensaje);
			try {
				numero = Integer.parseInt(cadena);
			} catch (NumberFormatException e) {
				System.out.println("Esto no es un número entero");
				correcto = false;
			}
		} while (!correcto);

		return numero;
	}

	public static float introduciFloat(String mensaje) {
		float numero = 0;
		String cadena;
		boolean correcto;

		do {
			correcto = true;
			cadena = introducirCadena(mensaje);
			try {
				numero = Integer.parseInt(cadena);
			} catch (NumberFormatException e) {
				System.out.println("Esto no es un número");
				correcto = false;
			}
		} while (!correcto);

		return numero;
	}

	public static LocalDate IntroFecha(String mensaje) {
		String fechacad = null;
		boolean correcto;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = null;
		do {
			correcto = true;
			fechacad = introducirCadena(mensaje);
			try {
				fecha = LocalDate.parse(fechacad, formateador);
			} catch (DateTimeParseException e) {
				System.out.println("Esto no es una fecha correcta");
				correcto = false;
			}
		} while (!correcto);

		return fecha;
	}

	public static boolean introduceboolean(String mensaje) {
		String respu;
		do {
			respu = introducirCadena(mensaje).toLowerCase();
		} while (!respu.equals("0") && !respu.equals("1") && !respu.equals("si") && !respu.equals("no")
				&& !respu.equals("s") && !respu.equals("n") && !respu.equals("true") && !respu.equals("false"));
		if (respu.equals("1") || respu.equals("si") || respu.equals("s") || respu.equals("true")) {
			return true;
		} else {
			return false;
		}

	}
	
	public static char leerChar(String mensaje){
		boolean error=false;
		String letra;
		
		do{
			error=false;
			letra=introducirCadena(mensaje).toUpperCase();
			if(letra.length()!=1){
				System.out.println("Error, introduce un car�ccter: ");
				error=true;
			}
			
		}while(error);
		return letra.charAt(0);
	}
}
