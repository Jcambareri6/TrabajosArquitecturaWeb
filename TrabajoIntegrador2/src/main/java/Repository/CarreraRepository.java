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
        Carrera c = this.em.createQuery("SELECT c FROM Carrera c WHERE c.idCarrera = :id", Carrera.class)
                .setParameter("id", id)
                .getSingleResult();
        return c;
    }

    @Override
    public Boolean delete(int id) {

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


}

