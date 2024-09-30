package Repository;

import Entities.Dao.Estudiante;
import org.hibernate.tuple.entity.EntityTuplizer;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class EstudianteRepository extends RepositoryAbstract {
    private static EstudianteRepository Singleton = null;

    public EstudianteRepository() {
        this.emf = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();

    }
    public static EstudianteRepository getEstudianteRepository(){
        if(Singleton==null){
            Singleton = new EstudianteRepository();
        }
        return Singleton;
    }



    @Override
    public List<Estudiante> getAll() {
        List<Estudiante> Consulta = this.em.createQuery("SELECT e from Estudiante  e ",Estudiante.class).getResultList();
    return Consulta;
    }

    @Override
    public Estudiante getById(int id) {
        Estudiante estudiante = this.em.find(Estudiante.class,id);
        return estudiante;
    }

    @Override
    public Boolean delete(int id) {

            // Begin transaction
          em.getTransaction().begin();


            Estudiante estudiante =this.em.find(Estudiante.class, id);

            if (estudiante != null) {

                this.em.remove(estudiante);
                this.em.getTransaction().commit();
                return true;
            } else {
                this.em.getTransaction().rollback();
                return false;
            }


    }

    //matricular un estudiante en una carrera
    public void add(Estudiante estudiante) {
        // Obtenemos el objeto EntityTransaction del EntityManager
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();

    }




    //recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    public List<Estudiante> getAllOrderByEdad() {
        List<Estudiante> consulta = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.Edad", Estudiante.class)
                .getResultList();
        return consulta;
    }


    //recuperar todos los estudiantes, en base a su género.
    public List<Estudiante> getAllByGenero(String genero) {
        // Use parameterized query to prevent SQL injection
        List<Estudiante> consulta = em.createQuery("SELECT e FROM Estudiante e WHERE e.Genero = :genero", Estudiante.class)
                .setParameter("genero", genero)
                .getResultList();
        return consulta;
    }


    //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
    public List<Estudiante> getAllByCarreraAndCiudad(String carrera, String ciudad) {
        List<Estudiante> consulta = em.createQuery(
                        "SELECT e FROM Estudiante e " +
                                "INNER JOIN CarrerasCursadas cc ON e.libretaUniversitaria = cc.id.idEstudiante " +
                                "INNER JOIN Carrera c ON cc.id.idCarrera = c.idCarrera " +
                                "WHERE c.Nombre = :carrera AND e.CiudadResidencia = :ciudad", Estudiante.class)
                .setParameter("carrera", carrera)
                .setParameter("ciudad", ciudad)
                .getResultList();

        return consulta;
    }




}
