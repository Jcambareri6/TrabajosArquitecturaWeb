package org.example;

import Entities.Dao.Carrera;
import Entities.Dao.CarrerasCursadas;
import Entities.Dao.CarrerasCursadasPk;

import Entities.Dao.Estudiante;
import Repository.CarreraRepository;
import Repository.CarrerasCursadasRepository;
import Repository.EstudianteRepository;


import java.util.Date;
import java.util.List;


public class App {
    public static void main(String[] args) {


        CarreraRepository cr = new CarreraRepository();
        EstudianteRepository repo = new EstudianteRepository();
        CarrerasCursadasRepository carrerasCursadaRepo = new CarrerasCursadasRepository();

        Estudiante estudiante2 = new Estudiante(7, "Valentino", "Malassisi", 21, "Masculino", "Buenos Aires");
        repo.add(estudiante2);

        Estudiante estudiante3 = new Estudiante(8, "Paula", "Manzalini", 50, "Femenino", "Cordoba");
        repo.add(estudiante3);

        Estudiante estudiante4 = new Estudiante(9, "Neymar", "Jr", 32, "Masculino", "Rio de Janeiro");
        repo.add(estudiante4);

        Carrera carrera1 = new Carrera(1, "dentista", 5);
        Carrera carrera2 = new Carrera(2, "ingeniero", 6);

        cr.add(carrera1);
        cr.add(carrera2);


        //dar de alta un estudiante
        Estudiante estudiantePrueba = new Estudiante(12,"Prueba", "Apellido",43,"Masculino","Tandil");
        repo.add(estudiantePrueba);
        repo.delete(estudiantePrueba.getLibretaUniversitaria());


        //matricular un estudiante en una carrera
        CarrerasCursadas cr1 = new CarrerasCursadas(new CarrerasCursadasPk(1, 2), false, new Date());
        CarrerasCursadas cr2 = new CarrerasCursadas(new CarrerasCursadasPk(2, 3), false, new Date());
        CarrerasCursadas cr3 = new CarrerasCursadas(new CarrerasCursadasPk(1, 4), false, new Date());
        carrerasCursadaRepo.add(cr1);
        carrerasCursadaRepo.add(cr2);
        carrerasCursadaRepo.add(cr3);

//      recuperar todos los estudiantes y especificar un criterio de ordenamiento
//      List<Estudiante> estudiantesPorEdad = repo.getAllOrderByEdad();
//        for (Estudiante e : estudiantesPorEdad){
//            System.out.println(e.toString());
//      }

//
//       recuperar un estudiante en base a su numero de libreta
//       Estudiante  estudianteNroLibreta = repo.getById(7);
//       System.out.println("recuperar estudiante en base a su numero de libreta" +  estudianteNroLibreta.toString());
//
//       recuperar todos los estudiantes en base a su genero
//       List<Estudiante>estudiantesPorGenero = repo.getAllByGenero("masculino");
//       System.out.println("Estudiantes genero Masculino");
//               for (Estudiante e : estudiantesPorGenero){
//                  System.out.println(e.toString());
//                }

//       recuperar las carreras con estudiantes inscriptos y ordenar por cantidad de inscriptos
//        List<Carrera> carreras = cr.getCarrerasOrderByInscriptos();
//                for (Carrera c : carreras) {
//                   System.out.println(c.toString());
//                 }

//        //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
//            List<Estudiante>Estudiantes_Carrera_CiudadResidencia = repo.getAllByCarreraAndCiudad("ingenieria","Necochea");


//
    }
}

