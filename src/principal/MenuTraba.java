package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import trabas.Empleade;
import trabas.Jefe;
import utilidades.Utilidades;

public class MenuTraba {

	public static void main(String[] args) {
		// declaraciones
		Scanner scanner = new Scanner(System.in);
		//Empleade[] empleado = new Empleade[3];
		ArrayList<Empleade> empleado = new ArrayList<>();
			

		int opcion;

		do {
			menu();
			opcion = Utilidades.introduciNumero("Que quiere hacer?");
//			scanner.nextLine(); // Limpiar el buffer del scanner

			if (empleado == null && opcion > 1 && opcion < 7) {
				System.out.println("No hay naves registradas.");
			} else {
				switch (opcion) {
				case 0: 
					aniadirEmpleades(empleado, scanner);
				
				case 1:
					visualizarEmpleadeJefe(empleado, scanner);
					break;
				case 2:
					visualizarJefes(empleado, scanner);
					break;
				case 3:
					buscarPorDepartamento(empleado, scanner);
					break;
				case 4:
					buscarNombre(empleado, scanner);
					break;
				case 5:
					buscarPorSalario(empleado, scanner);
					break;
				case 6:
					introducirAniosJefes(empleado, scanner);
					break;
				case 7:
					darBajaEmpleade(empleado, scanner);
					break;
				case 8:
					ordenarAlfabeticamente(empleado,scanner);
					break;
					
				case 9:
				ordenarRaquelAlfabeticamente(empleado,scanner);
				break;
				
				case 10:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opción inválida. Intenta de nuevo.");
				}
			}
		} while (opcion != 10);
	}

	private static void ordenarRaquelAlfabeticamente(ArrayList<Empleade> empleado, Scanner scanner) {

		Collections.sort(empleado);
		
		visualizarEmpleadeJefe(empleado, scanner);
	}

	private static void ordenarAlfabeticamente(ArrayList<Empleade> empleado, Scanner scanner) {
		 // Lista para almacenar los nombres de los departamentos
	    ArrayList<String> departamentos = new ArrayList<>();

	    // Recorrer la lista de empleados y obtener los departamentos de los jefes
	    for (Empleade emple : empleado) {
	        if (emple instanceof Jefe) {
	            Jefe jefe = (Jefe) emple;
	            if (!departamentos.contains(jefe.getNombreDepartamento())) {
	                departamentos.add(jefe.getNombreDepartamento()); // Agregar departamento sin duplicados
	            }
	        }
	    }

	    // Ordenar la lista alfabéticamente
	    Collections.sort(departamentos);

	    // Imprimir los departamentos y contar cuántos jefes tiene cada uno
	    System.out.println("************* Estadística por Departamento *************");
	    for (String departamento : departamentos) {
	        int contadorJefes = 0;
	        for (Empleade emple : empleado) {
	            if (emple instanceof Jefe) {
	                Jefe jefe = (Jefe) emple;
	                if (jefe.getNombreDepartamento().equalsIgnoreCase(departamento)) {
	                    contadorJefes++;
	                }
	            }
	        }
	        System.out.println("Departamento: " + departamento + ", Número de Jefes: " + contadorJefes);
	    }
	}

	private static void darBajaEmpleade(ArrayList<Empleade> empleado, Scanner scanner) {
		String dniPropo;
    	boolean encontrado = false;
    	int posicionEmpleade = 0;
    	
        System.out.print("Introduce el dni del empleado que deseas eliminar: ");
        dniPropo = scanner.next();
        
        
     	
    	for (int i=0; i<empleado.size(); i++) {
			if (empleado.get(i).getDNI().equalsIgnoreCase(dniPropo)) {
				  System.out.println("Empleade eliminado " + empleado.get(i).getNombre()); 
				  empleado.remove(posicionEmpleade);
				  encontrado = true;
		          
			}
			
		}
        
      if (!encontrado) {
            System.out.println("No se encontró ningun empleado con ese nombre.");
        }

    }

	private static void introducirAniosJefes(ArrayList<Empleade> empleado, Scanner scanner) {
		int numeroAnios;
		boolean hayEmpleades = false;
		
		
		System.out.println("Introduce el numero de años");
		numeroAnios = scanner.nextInt();
		for (int i=0; i<empleado.size(); i++) {
			if (empleado.get(i) != null && empleado.get(i).antiguedadEmpleado() > numeroAnios && empleado.get(i) instanceof Jefe) {
				System.out.println("El jefe tiene una antiguedad mayor " + empleado.get(i).getNombre());
			}
			
		}
		if (!hayEmpleades) {
			System.out.println("No hay jefes con una antiguedad inferior");
		}
	}
	
	private static void buscarPorSalario(ArrayList<Empleade> empleado, Scanner scanner) {
		float saldoComparar;
		boolean hayEmpleades = false;
		
		
		System.out.println("Introduce el saldo a comparar");
		saldoComparar = scanner.nextFloat();
		for (int i=0; i<empleado.size(); i++) {
			if (empleado.get(i) != null && empleado.get(i).sueldoTotal() > saldoComparar && !(empleado.get(i) instanceof Jefe)) {
				hayEmpleades = true;
				System.out.println("El empleado tiene un saldo mayor " + empleado.get(i).getNombre() + " y un salario de " + empleado.get(i).sueldoTotal());
			}else {
		        System.out.println(empleado.get(i).getNombre() + " es jefe y tiene un salario de " + empleado.get(i).sueldoTotal());
			}
			
		}
		if (!hayEmpleades) {
			System.out.println("No hay empleados con un saldo superior");
		}
	}
	
	private static void buscarNombre(ArrayList<Empleade> empleado, Scanner scanner) {
		// TODO Auto-generated method stub
		String nombreTitu;
		boolean encuentra = false;
		System.out.println("Introduce el empleado que quieres buscar");
		nombreTitu = scanner.next();
		for (int i=0; i<empleado.size(); i++) {
			if( empleado.get(i) !=  null && empleado.get(i).getNombre().contains(nombreTitu)) {
		System.out.println("El empleado es  " + empleado.get(i).getNombre() + empleado.get(i).getDNI() + empleado.get(i).antiguedadEmpleado());
			encuentra = true;
			}
		}
		if (!encuentra) {
			System.out.println("No ha encontrado a nadie con esa nombre");
		}
	}
	
	private static void buscarPorDepartamento(ArrayList<Empleade> empleado, Scanner scanner) {
		// TODO Auto-generated method stub
		String departamentoPropo;
	    System.out.println("Elige el departamento que deseas buscar");
	    departamentoPropo = scanner.next(); 
	    if (empleado.size() == 0) {
	        System.out.println("No se han introducido empleados.");
	      
	    }

	    boolean empleadoEncontrado = false; 

	    for (int i = 0; i < empleado.size(); i++) {
	        if (empleado.get(i) instanceof Jefe) {
	            Jefe jefe = (Jefe) empleado.get(i); 
	            if (jefe.getNombreDepartamento().equalsIgnoreCase(departamentoPropo)) { 
	                System.out.println(jefe.toString()); 
	                empleadoEncontrado = true;
	            }
	        }
	    }

	   
	    if (!empleadoEncontrado) {
	        System.out.println("No hay ningún empleado en este departamento");
	    }
	}

	private static void visualizarJefes(ArrayList<Empleade> empleado, Scanner scanner) {
		// TODO Auto-generated method stub
		boolean existeJefe = false;
		for (int i=0; i<empleado.size(); i++) {
			if (empleado.get(i) instanceof Jefe) {
            System.out.println(empleado.get(i).toString());
            existeJefe = true;
			}
        }
		if (!existeJefe) {
			System.out.println("No hay jefes en el sistema");
		}
	}
	
	private static void visualizarEmpleadeJefe(ArrayList<Empleade> empleado, Scanner scanner) {
		// TODO Auto-generated method stub
		//Hacer con foreach el resto a ver si funciona
		
		for(Empleade emp:empleado) {
			System.out.println(emp.toString());
		}
		
		/*for (int i=0; i<empleado.size(); i++) {
            System.out.println(empleado.get(i).toString());
        }/*/
	}
	
	private static void aniadirEmpleades(ArrayList<Empleade> empleado, Scanner scanner) {
		// TODO Auto-generated method stub
		String dni;
		Empleade emple;
		boolean seguir = true;
		int posicionEmpleade;
		String esJefe;

		for (; seguir;) {
			System.out.print("Introduce el DNI del empleado: ");
			dni = scanner.next().trim();

			
			posicionEmpleade = buscarEmpleadePorDni(empleado, dni);

			if (posicionEmpleade == -1) {
			     /* emple = new Empleade();
			      Empleade.setDatos(dni);
			      empleado.add(emple);*/
			      
				System.out.println("El empleado es jefe (si o no): ");
		            esJefe = scanner.next().trim();
		            
		           
		            if (esJefe.equalsIgnoreCase("si")) {
		                emple = new Jefe(); // Crear un Jefe
		            } else {
		                emple = new Empleade(); // Crear un Empleade regular
		            }
		           
		            emple.setDatos(dni);
		            empleado.add(emple);
		           
		            System.out.println("Empleade añadido exitosamente.");
		        } else {
		            System.out.println("Ya existe un empleado con ese DNI.");
		        }
			System.out.println("Quieres seguir introduciendo empleados?");
			seguir=scanner.next().equalsIgnoreCase("SI");
		}

	
	
		
	}

	private static int buscarEmpleadePorDni(ArrayList<Empleade> empleado, String DNI) {
		// TODO Auto-generated method stub
		for (int i = 0; i < empleado.size(); i++) {
			   if (empleado.get(i) != null && empleado.get(i).getDNI().equalsIgnoreCase(DNI)) {
				  
		            return i;
			   }
		}
		return -1;
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("""
    0. Introducir datos de empleade/s y/o jefe/s comprobando que no existan ya (a partir de su DNI). Mensaje de error en caso de que se quiera dar de alta a alguien ya existente.
    1. Visualizar todos los datos (con sueldo final) de todes les empleades (les jefes son empleades)
    2. Visualizar les jefes
    3. Visualizar les jefe/s de un departamento concreto: se introduce el departamento y se mostrará el nombre/s de les jefe/s (1 departamento puede tener más de un jefe). Usar como cabecera: "Jefe/s del departamento XXXXXXX".  Si no hay aún ningún jefe para ese departamento, se indicará y no saldrá la cabecera tampoco.
    4. Introducir nombre o al menos un grupo de caracteres del nombre  y visualizar el DNI/s y los años que lleva/n en la empresa indicando si es/son o no jefe. Mensaje de error si no se encuentra.
    5. Introducir un salario y mostrar aquelles empleades cuyo salario final es igual o superior al introducido. Indicar también cuáles de elles son jefe/s. Mensaje de aviso si no se encuentran.
    6. Introducir un nº de años y mostrar les jefes que lleven en la empresa esos o más años.
    7. Dar de baja a un empleade/jefe a partir de su DNI, mensaje de error si no existe.
    8. Estadística ordenada alfabéticamente por departamento de los diferentes departamentos que tienen jefe/s indicando: departamento y nº jefe/s. Vamos a suponer que puede haber 20 departamentos como máximo.
    9. Salir.
				""");
	}

}
