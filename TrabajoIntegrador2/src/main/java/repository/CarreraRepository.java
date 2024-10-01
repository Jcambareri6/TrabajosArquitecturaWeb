package repository;

import Dto.CarreraDto;
import Entities.Dao.Carrera;
import InterfacesRepository.RepositoryCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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

    @Override
    public void add(Carrera c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Carrera c) {
        this.em.remove(c);
    }

    @Override
    public List<Carrera> getAll() {
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
         return carreras;

    }

    @Override
    public Carrera findBy(int id) {
        return this.em.find(Carrera.class,id);
    }

    @Override
    public List<CarreraDto> getCarrerasOrderByCantidadInscriptos() {
        return null;
    }

//    @Override
//    public List<Carrera> getAll() {
//        List<Carrera> carrerasDisponibles= this.em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
//        return carrerasDisponibles;
//    }
//
//    @Override
//    public Carrera getById(int id) {
//       return this.em.find(Carrera.class,id);
//    }
//
//    @Override
//    public Boolean delete(int id) {
//        em.getTransaction().begin();
//        Carrera c = em.find(Carrera.class, id);
//
//        if (c != null) {
//
//            this.em.remove(c);
//            this.em.getTransaction().commit();
//            return true;
//        } else {
//            this.em.getTransaction().rollback();
//            return false;
//        }
//    }
//
//    public void add (Carrera c){
//        em.getTransaction().begin();
//        em.persist(c);
//        em.getTransaction().commit();
//
//    }
//    public List<Carrera> getCarrerasOrderByInscriptos() {
//        List<Carrera> carrerasInscriptos = em.createQuery("SELECT c FROM Carrera c " +
//                "WHERE size(c.estudiante) > 0 " +
//                "ORDER BY size(c.estudiante) DESC", Carrera.class).getResultList();
//        return carrerasInscriptos;
//    }

//    public getReporte(){
//        List<Object> Consulta = em.createQuery(
//        "SELECT c.Nombre, " +
//        "YEAR(cc.Fecha_Inscripcion) AS Anio, " +
//        "COUNT(CASE WHEN cc.Fecha_Inscripcion IS NOT NULL THEN 1 END) AS Inscriptos, " +
//        "COUNT(CASE WHEN cc.Fecha_graduacion IS NOT NULL THEN 1 END) AS Egresados " +
//        "FROM CarrerasCursadas cc " +
//        "JOIN Carrera c ON cc.id.idCarrera = c.idCarrera " +
//        "LEFT JOIN " +
//        "Estudiante e ON cc.id.idEstudiante = e.libreta_universitaria " +
//        "GROUP BY " +
//        "c.Nombre_Carrera, YEAR(cc.Fecha_Inscripcion), YEAR(cc.Fecha_graduacion) " +
//        "ORDER BY " +
//        "c.Nombre_Carrera ASC," +
//        "Anio ASC").getResultList();
//
//        //instanciar con el dto
//
//        returnConsulta;
//    }

}

