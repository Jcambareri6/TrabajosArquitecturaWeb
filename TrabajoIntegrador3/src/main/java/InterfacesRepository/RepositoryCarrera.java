package InterfacesRepository;

import Dto.CarreraReporteDto;
import Entities.Dao.Carrera;
import Dto.CarreraDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("repositoryCarrera")
public interface RepositoryCarrera extends JpaRepository<Carrera,Integer> {


    Carrera findByNombre(String nombre);
    @Query("SELECT new Dto.CarreraDto(c.idCarrera, c.nombre, c.Anios ,c.estudiante.size) FROM Carrera c ORDER BY SIZE(c.estudiante) DESC")
    public List<CarreraDto> getCarrerasOrderByCantidadInscriptos();
    @Query("SELECT new Dto.CarreraReporteDto(c.idCarrera, c.nombre, FUNCTION('YEAR', i.Fecha_inscripcion), COUNT(i.Fecha_inscripcion) , COUNT(i.fecha_Graduacion) )" +
            "FROM Carrera c " +
            "LEFT JOIN Inscripcion i ON i.carreraCursada.idCarrera = c.idCarrera " +
            "GROUP BY c.idCarrera, c.nombre, FUNCTION('YEAR', i.Fecha_inscripcion) " +
            "ORDER BY c.nombre ASC, FUNCTION('YEAR', i.Fecha_inscripcion) ASC")

    public List<CarreraReporteDto> getReporte();


}
