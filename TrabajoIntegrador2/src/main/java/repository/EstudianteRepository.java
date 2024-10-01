package repository;

import Dto.EstudianteDto;
import Entities.Dao.Estudiante;
import InterfacesRepository.RepositoryEstudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

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

    private EstudianteDto convertToDto(Estudiante estudiante) {
        return new EstudianteDto(
                estudiante.getLibretaUniversitaria(),
                estudiante.getNombre(),
                estudiante.getEdad(),
                estudiante.getGenero(),
                estudiante.getCiudadResidencia()
        );
    }

    @Override
    public void delete(Estudiante e){
        this.em.remove(e);
    }

    @Override
    public void add(Estudiante es) {
        em.getTransaction().begin();
        em.persist(es);
        em.getTransaction().commit();
    }

    @Override
    public List<EstudianteDto> getOrderByEdad() {
        List<Estudiante> consulta = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.Edad", Estudiante.class)
                .getResultList();
        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<EstudianteDto> GetAll() {
        List<Estudiante> consulta = this.em.createQuery("SELECT e from Estudiante  e ",Estudiante.class).getResultList();
        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Estudiante findByLibretaUniversitaria(int LibretaUniversitaria) {
        return this.em.find(Estudiante.class,LibretaUniversitaria);
    }
    @Override
    public List<EstudianteDto> getAllByGenero(String genero) {
        List<Estudiante> consulta = em.createQuery("SELECT e " +
                        "FROM Estudiante e WHERE e.Genero = :genero", Estudiante.class)
                .setParameter("genero", genero)
                .getResultList();
        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
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
        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia (anterior)
    public List<EstudianteDto> getAllByCarreraAndCiudad(String carrera, String ciudad) {
        List<Estudiante> consulta = em.createQuery(
                        "SELECT e FROM Estudiante e " +
                                "INNER JOIN Inscripcion cc ON e.libretaUniversitaria = cc.id.idEstudiante " +
                                "INNER JOIN Carrera c ON cc.id.idCarrera = c.idCarrera " +
                                "WHERE c.Nombre = :carrera AND e.CiudadResidencia = :ciudad", Estudiante.class)
                .setParameter("carrera", carrera)
                .setParameter("ciudad", ciudad)
                .getResultList();
        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
