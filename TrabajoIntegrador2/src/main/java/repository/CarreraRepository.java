package repository;

import Dto.CarreraDto;
import Dto.CarreraReporteDto;
import Dto.EstudianteDto;
import Entities.Dao.Carrera;
import Entities.Dao.Estudiante;
import InterfacesRepository.RepositoryCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

public class CarreraRepository implements RepositoryCarrera {
    private static CarreraRepository Singleton= null;
    private EntityManagerFactory emf;
    private EntityManager em;

    public CarreraRepository (){
        this.emf = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }
    public static CarreraRepository getCarreraRepository(){
        if(Singleton==null){
            Singleton = new CarreraRepository();
        }
        return Singleton;
    }
    private CarreraDto convertToDto(Carrera carrera) {
        return new CarreraDto(
                carrera.getIdCarrera(),
                carrera.getNombre(),
                carrera.getAnios()
        );
    }
//    private CarreraReporteDto convertReporteDto(Carrera carrera) {
//        return new CarreraReporteDto(
//                carrera.getIdCarrera(),
//                carrera.getNombre(),
//                carrera.getAnios()
//        );
//    }

    @Override
    public void add(Carrera carrera) {
        em.getTransaction().begin();
        em.persist(carrera);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Carrera carrera) {
        this.em.remove(carrera);
    }

    @Override
    public List<CarreraDto> getAll() {
        List<Carrera> consulta = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
         return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Carrera findBy(int id) {
        Carrera carrera =this.em.find(Carrera.class,id);
        return carrera;
    }
    @Override
    public List<CarreraDto> getCarrerasOrderByCantidadInscriptos() {
        List<Carrera> consulta = em.createQuery(
                "SELECT c FROM Carrera c " +
                "WHERE size(c.estudiante) > 0 " +
               "ORDER BY size(c.estudiante) DESC", Carrera.class).getResultList();
        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }

//    public List<CarreraReporteDto> getReporte(){
//        List<Carrera> consulta = em.createQuery(
//                "SELECT c.Nombre, " +
//               "YEAR(i.Fecha_Inscripcion) AS Anio, " +
//                "COUNT(CASE WHEN i.Fecha_Inscripcion IS NOT NULL THEN 1 END) AS Inscriptos, " +
//                "COUNT(CASE WHEN i.Fecha_graduacion IS NOT NULL THEN 1 END) AS Egresados " +
//                "FROM Inscripcion i " +
//                "JOIN Carrera c ON i.id.idCarrera = c.idCarrera " +
//                "LEFT JOIN " +
//                "Estudiante e ON i.id.idEstudiante = e.libreta_universitaria " +
//                "GROUP BY " +
//                "c.Nombre_Carrera, YEAR(i.Fecha_Inscripcion), YEAR(i.Fecha_graduacion) " +
//                "ORDER BY " +
//                "c.Nombre_Carrera ASC," +
//                "Anio ASC").getResultList();
//
//        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
//    }

}

