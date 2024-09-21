package org.example;

import Entities.Dao.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //dar de alta un estudiante

        //matricular un estudiante en una carrera
        Estudiante estudiante = new Estudiante("Joaquin","BosteroCambareri",22,"Masculino");
        em.persist(estudiante);
        Estudiante ES = new Estudiante("Valentino","Malassisi",21,"Masculino");
        em.persist(estudiante);
        Estudiante ES2 = new Estudiante("Paula","Manzalini",50,"Femenino");
        em.persist(estudiante);
        Estudiante ES3 = new Estudiante("Neymar","Jr",32,"Masculino");
        em.persist(estudiante);
        Estudiante ES4 = new Estudiante();
        em.persist(ES4);


        //recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
        @SuppressWarnings("unchecked")
        List<Object[]> Consulta3 = em.createQuery("SELECT e.Nombre, e.Apellido, e.Edad, e.Genero " +
                "FROM Estudiante e ORDER BY e.Edad").getResultList();
        Consulta3.forEach(d -> System.out.println(Arrays.toString(d)));

        //recuperar un estudiante, en base a su número de libreta universitaria.
        Estudiante e = em.find(Estudiante.class, 1);
        System.out.println(e);

        //recuperar todos los estudiantes, en base a su género.
        @SuppressWarnings("unchecked")
        List<Object[]> Consulta5 = em.createQuery("SELECT e.Nombre, e.Apellido, e.Edad, e.Genero " +
                "FROM Estudiante e WHERE e.Genero='Masculino'").getResultList();
        Consulta5.forEach(d -> System.out.println(Arrays.toString(d)));

        //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        @SuppressWarnings("unchecked")
        List<Object[]> Consulta6 = em.createQuery("SELECT c.Nombre, c.Anios FROM Carrera c " +
                "WHERE c.Estudiantes.size()>0 ORDER BY Estudiantes.size()").getResultList();
        Consulta6.forEach(d -> System.out.println(Arrays.toString(d)));
        em.getTransaction().commit();

        //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
        @SuppressWarnings("unchecked")
        List<Object[]> Consulta7 = em.createQuery("SELECT e FROM Estudiante e JOIN e.Carreras c " +
                "WHERE c.carrera='Ingenieria' AND e.CiudadResidencia='Necochea'").getResultList();
        Consulta7.forEach(d -> System.out.println(Arrays.toString(d)));

        //Generar un reporte de las carreras, que para cada carrera incluya información de los
        //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        //los años de manera cronológica.
        em.close();
        emf.close();
    }
}

