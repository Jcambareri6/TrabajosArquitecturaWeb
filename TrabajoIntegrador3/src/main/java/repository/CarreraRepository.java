package repository;

import Dto.CarreraDto;
import Dto.CarreraReporteDto;
import Dto.EstudianteDto;
import Entities.Dao.Carrera;
import Entities.Dao.Estudiante;
import InterfacesRepository.RepositoryCarrera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarreraRepository implements RepositoryCarrera {
    private static CarreraRepository Singleton= null;
    private EntityManagerFactory emf;
    private EntityManager em;

    public CarreraRepository (){
        this.emf = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }
    public static CarreraRepository getCarreraRepository(){
        if(Singleton==null){
            Singleton = new CarreraRepository();
        }
        return Singleton;
    }
    private CarreraDto convertToDto(Carrera carrera) {
        return new CarreraDto(
                carrera.getIdCarrera(),
                carrera.getNombre(),
                carrera.getAnios(),
                carrera.GetCantInscriptos()
        );
    }
    private CarreraReporteDto convertReporteDto(Carrera carrera, int cantInscriptos,int cantEgresados) {
        return new CarreraReporteDto(
                carrera.getIdCarrera(),
                carrera.getNombre(),
                carrera.getAnios(),
                cantInscriptos,
                cantEgresados
        );
    }

    @Override
    public void add(Carrera carrera) {
        em.getTransaction().begin();
        em.persist(carrera);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Carrera carrera) {
        this.em.remove(carrera);
    }

    @Override
    public List<CarreraDto> getAll() {
        List<Carrera> consulta = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
         return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Carrera findBy(int id) {
        Carrera carrera =this.em.find(Carrera.class,id);
        return carrera;
    }
    @Override
    public List<CarreraDto> getCarrerasOrderByCantidadInscriptos() {
        List<Carrera> consulta = em.createQuery(
                "SELECT c FROM Carrera c " +
                "WHERE size(c.estudiante) > 0 " +
               "ORDER BY size(c.estudiante) DESC", Carrera.class).getResultList();
        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<CarreraReporteDto> getReporte() {
        String sql = "SELECT c.idCarrera, " +
                "c.nombre, " +
                "YEAR(i.Fecha_inscripcion) AS anio, " +
                "COUNT(i.Fecha_inscripcion) AS inscriptos, " +
                "COUNT(i.fecha_Graduacion) AS egresados " +
                "FROM Carrera c " +  // Cambié el orden para hacer el LEFT JOIN
                "LEFT JOIN Inscripcion i ON i.idCarrera = c.idCarrera " +  // Cambiado a LEFT JOIN
                "GROUP BY c.idCarrera, c.nombre, YEAR(i.Fecha_inscripcion) " +
                "ORDER BY c.nombre ASC, anio ASC";
        List<Object[]> consulta = em.createNativeQuery(sql).getResultList();
        List<CarreraReporteDto> reporteDeCarreras = new ArrayList<>();

        for (Object[] c : consulta) {

            int idCarrera = (c[0] != null) ? ((Number) c[0]).intValue() : 0;
            String nombre = (String) c[1];
            Integer anio = (c[2] != null) ? ((Number) c[2]).intValue() : 0;
            int inscriptos = (c[3] != null) ? ((Number) c[3]).intValue() : 0;
            int egresados = (c[4] != null) ? ((Number) c[4]).intValue() : 0;
            CarreraReporteDto dto = new CarreraReporteDto(idCarrera,nombre,anio,inscriptos,egresados);


            reporteDeCarreras.add(dto);
        }

        return reporteDeCarreras;
    }


}

