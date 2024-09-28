package org.example;

import Entities.Dao.Carrera;
import Entities.Dao.CarrerasCursadas;
import Entities.Dao.CarrerasCursadasPk;
import Entities.Dao.Estudiante;
import Repository.CarreraRepository;
import Repository.CarrerasCursadasRepository;
import Repository.EstudianteRepository;

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


        //dar de alta un estudiante
        CarreraRepository cr = new CarreraRepository();
        EstudianteRepository repo = new EstudianteRepository();
        CarrerasCursadasRepository carrerasCursadaRepo = new CarrerasCursadasRepository();






         //matricular un estudiante en una carrera
        CarrerasCursadas cr1 = new CarrerasCursadas(new CarrerasCursadasPk(1,2),false,6);
        CarrerasCursadas cr2 = new CarrerasCursadas(new CarrerasCursadasPk(2,3),false,4);
        CarrerasCursadas cr3 = new CarrerasCursadas(new CarrerasCursadasPk(1,4),false,4);
         carrerasCursadaRepo.add(cr1);
         carrerasCursadaRepo.add(cr2);
        carrerasCursadaRepo.add(cr3);

        List<Carrera> carreras = cr.getCarrerasOrderByInscriptos();

        for (Carrera c : carreras){

            System.out.println(c.toString());
        }

//        Estudiante estudiante = new Estudiante(6,"Joaquin","cambareri",18,"masculino","necochea");
//
////        repo.add(estudiante);
//
//        Estudiante estudiante2 = new Estudiante(7, "Valentino", "Malassisi", 21, "Masculino", "Buenos Aires");
////        repo.add(estudiante2);
//
//        Estudiante estudiante3 = new Estudiante(8, "Paula", "Manzalini", 50, "Femenino", "Cordoba");
////        repo.add(estudiante3);
//
//        Estudiante estudiante4 = new Estudiante(9, "Neymar", "Jr", 32, "Masculino", "Rio de Janeiro");
////        repo.add(estudiante4);
//
//        // recuperar todos los estudiantes y especificar un criterio de ordenamiento
//         List<Estudiante> estudiantesPorEdad = repo.getAllOrderByEdad();
//         for (Estudiante e : estudiantesPorEdad){
//             System.out.println(e.toString());
//         }
//
//         //recuperar un estudiante en base a su numero de libreta
//         Estudiante  estudianteNroLibreta = repo.getById(7);
//         System.out.println("recuperar estudiante en base a su numero de libreta" +  estudianteNroLibreta.toString());
//
//        // recuperar todos los estudiantes en base a su genero
//         List<Estudiante>estudiantesPorGenero = repo.getAllByGenero("masculino");
//            System.out.println("Estudiantes genero Masculino");
//                for (Estudiante e : estudiantesPorGenero){
//                    System.out.println(e.toString());
//                }
//
//        //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
//
//             List<Estudiante>Estudiantes_Carrera_CiudadResidencia = repo.getAllByCarreraAndCiudad("ingenieria","Necochea");
//
  }
}

