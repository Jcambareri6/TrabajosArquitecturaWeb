package Repository;

import Entities.Dao.Estudiante;
import org.hibernate.tuple.entity.EntityTuplizer;

import javax.persistence.EntityTransaction;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class EstudianteRepository extends RepositoryAbstract {

    public EstudianteRepository() {
        super();
        System.out.println(em);
    }


    @Override
    public List<Estudiante> getAll() {
        List<Estudiante> Consulta = this.em.createQuery("SELECT e from Estudiante  e ",Estudiante.class).getResultList();
    return Consulta;
    }

    @Override
    public Estudiante getById(int id) {
        Estudiante estudiante = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.libretaUniversitaria = :id", Estudiante.class)
                .setParameter("id", id)
                .getSingleResult();
        return estudiante;
    }

    @Override
    public Boolean delete(int id) {

            // Begin transaction



            Estudiante estudiante = em.find(Estudiante.class, id);

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
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();


            em.persist(estudiante);


            tx.commit();
        } catch (Exception e) {
            // Si ocurre un error, hacemos rollback
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
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
