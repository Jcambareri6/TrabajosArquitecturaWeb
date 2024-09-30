package Repository;

import Entities.Dao.CarrerasCursadas;
import Entities.Dao.Estudiante;

import javax.persistence.EntityTransaction;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class CarrerasCursadasRepository extends  RepositoryAbstract {
    public CarrerasCursadasRepository() {
        super();
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

            // Obtenemos el objeto EntityTransaction del EntityManager


            try {



                em.persist(cr);


                em.getTransaction().commit();
            } catch (Exception e) {
                // Si ocurre un error, hacemos rollback

                e.printStackTrace();
            }
        }
    }








