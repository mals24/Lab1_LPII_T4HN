package views;

import controllers.EmpleadoController;

public class EmpleadoView {

public static void main(String[] args) {
		
		//String empleado = new EmpleadoController().createEmpleado("Marcelo","Liendo",18,"Masculino","S/7500");
		
		String empleado = new EmpleadoController().deleteEmpleado(1);
		
		//String empleado = new EmpleadoController().updateEmpleado(2,"Rocio");
		
		//String empleado = new EmpleadoController().getEmpleado(3);

		System.out.println(empleado);
	}
	
}
