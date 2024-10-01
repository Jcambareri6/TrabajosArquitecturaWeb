package org.example;

import Entities.Dao.Carrera;

import Entities.Dao.Estudiante;
import Entities.Dao.Inscripcion;
import repository.CarreraRepository;
import repository.InscripcionRepository;
import repository.EstudianteRepository;


public class App {
    public static void main(String[] args) {


        CarreraRepository cr = new CarreraRepository();
        EstudianteRepository repo = new EstudianteRepository();
        InscripcionRepository carrerasCursadaRepo = new InscripcionRepository();


        Carrera carrera1 = new Carrera(1, "dentista", 5);
        Carrera carrera2 = new Carrera(2, "ingeniero", 6);

        cr.add(carrera1);
        cr.add(carrera2);


        //dar de alta un estudiante
        Estudiante estudiantePrueba = new Estudiante(1,"Prueba", "Apellido",43,"Masculino","Tandil");
        repo.AddEstudiante(estudiantePrueba);
        Estudiante estudiantePrueba2 = new Estudiante(2,"JOAQUITO","CAMBARERI",64,"MASCULINO","NECOCITY");
        repo.AddEstudiante(estudiantePrueba2);
        Carrera c = cr.findBy(2);
        Estudiante es = repo.findByLibretaUniversitaria(1);
        Estudiante es1 = repo.findByLibretaUniversitaria(2);




        //matricular un estudiante en una carrera
        System.out.println("antes de instanciar carrerasCursadas" );
        Inscripcion cr1 = new Inscripcion(c,es,false);
        Inscripcion cr2 = new Inscripcion(c,es1,true);


        carrerasCursadaRepo.MatricularEstudiante(cr1);
        carrerasCursadaRepo.MatricularEstudiante(cr2);

//        carrerasCursadaRepo.add(cr2);
//        carrerasCursadaRepo.add(cr3);

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

