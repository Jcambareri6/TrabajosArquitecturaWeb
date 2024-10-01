package repository;

import Entities.Dao.Inscripcion;
import InterfacesRepository.RepositoryInscripcion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InscripcionRepository implements RepositoryInscripcion {
    private static InscripcionRepository Singleton = null;
    private EntityManagerFactory emf;
    private EntityManager em;

    public InscripcionRepository() {
        this.emf = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }
    public static InscripcionRepository getCarrerasCursadasRepository(){
        if(Singleton==null){
            Singleton = new InscripcionRepository();
        }
        return Singleton;
    }

    @Override
    public void MatricularEstudiante(Inscripcion insc) {
        em.getTransaction().begin();
        em.merge(insc);
        em.getTransaction().commit();
    }

    @Override
    public void deleteInscripcion(int id) {
        Inscripcion insc= this.em.find(Inscripcion.class,id);
        this.em.remove(insc);
    }

    @Override
    public void getAll() {

    }

    @Override
    public Inscripcion getById(int id) {
        return this.em.find(Inscripcion.class,id);
    }


    }








