package org.example;

import Dto.CarreraDto;
import Dto.EstudianteDto;
import Entities.Dao.Carrera;

import Entities.Dao.Estudiante;
import Entities.Dao.Inscripcion;

import repository.CarreraRepository;
import repository.InscripcionRepository;
import repository.EstudianteRepository;

import java.util.List;


public class App {
    public static void main(String[] args) {

        CarreraRepository carreraRepository = new CarreraRepository();
        EstudianteRepository estudianteRepository = new EstudianteRepository();
        InscripcionRepository inscripcionRepository = new InscripcionRepository();

        Carrera carrera1 = new Carrera(1, "dentista", 5);
        Carrera carrera2 = new Carrera(2, "ingeniero", 6);

//        carreraRepository.add(carrera1);
//        carreraRepository.add(carrera2);


        System.out.println("2.a) dar de alta un estudiante");

        Estudiante estudiantePrueba = new Estudiante(1,"Prueba", "Apellido",43,"Masculino","Tandil");
//        estudianteRepository.add(estudiantePrueba);
        Estudiante estudiantePrueba2 = new Estudiante(2,"JOAQUITO","CAMBARERI",64,"MASCULINO","NECOCITY");
//        estudianteRepository.add(estudiantePrueba2);
        Estudiante estudiante1 = estudianteRepository.findByLibretaUniversitaria(1);
        Estudiante estudiante2 = estudianteRepository.findByLibretaUniversitaria(2);


        System.out.println("2.b) matricular un estudiante en una carrera");

        System.out.println("antes de instanciar carrerasCursadas" );
        Carrera carrera = carreraRepository.findBy(2);
        Inscripcion inscripcion1 = new Inscripcion(carrera,estudiante1);
        Inscripcion inscripcion2 = new Inscripcion(carrera,estudiante2);

//        inscripcionRepository.add(inscripcion1);
//        inscripcionRepository.add(inscripcion2);

//        carrerasCursadaRepo.add(cr2);
//        carrerasCursadaRepo.add(cr3);

        System.out.println("ejercicio 2.c) recuperar todos los estudiantes y especificar un criterio de ordenamiento");
      List<EstudianteDto> estudiantesPorEdad = estudianteRepository.getOrderByEdad();
        for (EstudianteDto e : estudiantesPorEdad){
            System.out.println(e.toString());
      }

        System.out.println(" 2.d) recuperar un estudiante en base a su numero de libreta");
       Estudiante  estudianteNroLibreta = estudianteRepository.findByLibretaUniversitaria(1);
       System.out.println("recuperar estudiante en base a su numero de libreta" +  estudianteNroLibreta.toString());

        System.out.println("2.e)recuperar todos los estudiantes en base a su genero");
       List<EstudianteDto> estudiantesPorGenero = estudianteRepository.getAllByGenero("masculino");
       System.out.println("Estudiantes genero Masculino");
               for (EstudianteDto e : estudiantesPorGenero){
                  System.out.println(e.toString());
                }
        System.out.println("2.f) recuperar las carreras con estudiantes inscriptos y ordenar por cantidad de inscriptos ");
        List<CarreraDto> carreras = carreraRepository.getCarrerasOrderByCantidadInscriptos();
                for (CarreraDto c : carreras) {
                    System.out.println("probando 2.f");
                   System.out.println(c.toString());
                 }

        System.out.println("2.g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia");
            List<EstudianteDto> Estudiantes_Carrera_CiudadResidencia = estudianteRepository.getAllByCarreraAndCiudad("ingeniero","Tandil");
            for (EstudianteDto e : Estudiantes_Carrera_CiudadResidencia){
                System.out.println(e.toString());
            }

    }
}

