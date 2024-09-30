package Repository;

import Entities.Dao.CarrerasCursadas;
import Entities.Dao.Estudiante;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class CarrerasCursadasRepository extends  RepositoryAbstract {
    public CarrerasCursadasRepository() {
        this.emf = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }
    public static CarrerasCursadasRepository getCarrerasCursadasRepository(){
        if(Singleton==null){
            Singleton = new CarrerasCursadasRepository();
        }
        return Singleton;
    }

    @Override
    public List<CarrerasCursadas> getAll() {
        return null;
    }

    @Override
    public CarrerasCursadas getById(int id) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }

    public void  add (CarrerasCursadas cr){
        em.getTransaction().begin();

        em.persist(cr);
        em.getTransaction().commit();

    }
    }








