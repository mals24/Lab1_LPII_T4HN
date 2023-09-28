package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Empleado;

public class EmpleadoController {

public String createEmpleado(String nombres, String apellidos, int edad, String sexo, String salario) {
		
		SessionFactory sessionFactory = new Configuration().configure("cl1.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		try {
			Empleado empleado = new Empleado(nombres,apellidos,edad,sexo,salario);
			
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado creado";
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al registrar empleado";
	}
	
	public String deleteEmpleado(int idempleado) {
		
		SessionFactory sessionFactory = new Configuration().configure("cl1.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();;

		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			session.delete(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado eliminado correctamente";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Error al eliminar usuario";
	}
	
	public String updateEmpleado(int idempleado, String nombres) {
		
		SessionFactory sessionFactory = new Configuration().configure("cl1.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			Empleado empleado = session.get(Empleado.class, idempleado);
			empleado.setNombres(nombres);
			session.update(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Empleado actualizado correctamente";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar empleado";
	}
	
	public String getEmpleado(int idempleado) {
		
		SessionFactory sessionFactory = new Configuration().configure("cl1.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado encontrado";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Empleado no encontrado";
		
	}
}
