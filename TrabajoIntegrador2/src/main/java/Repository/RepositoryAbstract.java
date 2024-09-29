package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public  abstract  class RepositoryAbstract<T>  {
    protected EntityManager em;
    protected EntityManagerFactory emf;

    public RepositoryAbstract (){
        this.emf = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();

    }

    public abstract List<T> getAll();
    public abstract T getById(int id);
    public abstract Boolean delete (int id);


}
