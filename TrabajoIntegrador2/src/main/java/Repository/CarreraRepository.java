package Repository;

import Entities.Dao.Carrera;
import Entities.Dao.Estudiante;

import javax.persistence.EntityTransaction;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class CarreraRepository extends RepositoryAbstract {
    public CarreraRepository (){
        super();
    }

    @Override
    public List<Carrera> getAll() {
        List<Carrera> carrerasDisponibles= this.em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
        return carrerasDisponibles;
    }

    @Override
    public Carrera getById(int id) {
        Carrera c = this.em.find(Carrera.class,id);
        return c;
    }

    @Override
    public Boolean delete(int id) {
        em.getTransaction().begin();
        Carrera c = em.find(Carrera.class, id);

        if (c != null) {

            this.em.remove(c);
            this.em.getTransaction().commit();
            return true;
        } else {
            this.em.getTransaction().rollback();
            return false;
        }
    }

    public void add (Carrera c){
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();


            em.persist(c);


            tx.commit();
        } catch (Exception e) {
            // Si ocurre un error, hacemos rollback
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Carrera> getCarrerasOrderByInscriptos() {
        List<Carrera> carrerasInscriptos = em.createQuery("SELECT c FROM Carrera c " +
                "WHERE size(c.estudiante) > 0 " +
                "ORDER BY size(c.estudiante) DESC", Carrera.class).getResultList();
        return carrerasInscriptos;
    }

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

