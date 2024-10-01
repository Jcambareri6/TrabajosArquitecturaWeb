package repository;

import Dto.EstudianteDto;
import Entities.Dao.Estudiante;
import InterfacesRepository.RepositoryEstudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EstudianteRepository implements RepositoryEstudiante {
    private static EstudianteRepository Singleton = null;
    private EntityManagerFactory emf;
    private EntityManager em;
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
    public void AddEstudiante(Estudiante es) {
        em.getTransaction().begin();
        em.persist(es);
        em.getTransaction().commit();
    }

    @Override
    public List<Estudiante> getOrderByEdad() {
        List<Estudiante> consulta = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.Edad", Estudiante.class)
                .getResultList();
        return consulta;
    }

    @Override
    public List<Estudiante> GetAll() {
        List<Estudiante> Consulta = this.em.createQuery("SELECT e from Estudiante  e ",Estudiante.class).getResultList();
        return Consulta;
    }

    @Override
    public Estudiante findByLibretaUniversitaria(int LibretaUniversitaria) {
        return this.em.find(Estudiante.class,LibretaUniversitaria);
    }

    @Override
    public List<Estudiante> getAllByGenero(String genero) {

        List<Estudiante> resultados = em.createQuery("SELECT e " +
                        "FROM Estudiante e WHERE e.Genero = :genero", Estudiante.class)
                .setParameter("genero", genero)
                .getResultList();
        return resultados;

    }


    @Override
    //actual tiene que devolver dto
    public List<EstudianteDto> getEstudiantesByCarreraOrderByCiudad(String carrera, String Ciudad) {
        List<Estudiante> consulta = em.createQuery(
                        "SELECT e FROM Estudiante e " +
                                "INNER JOIN Inscripcion cc ON e.libretaUniversitaria = cc.id.idEstudiante " +
                                "INNER JOIN Carrera c ON cc.id.idCarrera = c.idCarrera " +
                                "WHERE c.Nombre = :carrera AND e.CiudadResidencia = :ciudad", Estudiante.class)
                .setParameter("carrera", carrera)
                .setParameter("ciudad", Ciudad)
                .getResultList();
        return null;

    }


    //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia (anterior)
    public List<Estudiante> getAllByCarreraAndCiudad(String carrera, String ciudad) {
        List<Estudiante> consulta = em.createQuery(
                        "SELECT e FROM Estudiante e " +
                                "INNER JOIN Inscripcion cc ON e.libretaUniversitaria = cc.id.idEstudiante " +
                                "INNER JOIN Carrera c ON cc.id.idCarrera = c.idCarrera " +
                                "WHERE c.Nombre = :carrera AND e.CiudadResidencia = :ciudad", Estudiante.class)
                .setParameter("carrera", carrera)
                .setParameter("ciudad", ciudad)
                .getResultList();

        return consulta;
    }

}
