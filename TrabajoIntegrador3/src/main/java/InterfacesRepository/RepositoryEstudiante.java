package InterfacesRepository;

import Dto.EstudianteDto;
import Entities.Dao.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryEstudiante extends JpaRepository<Estudiante,Integer> {

    public Estudiante findByLibretaUniversitaria(long libretaUniversitaria);

    @Query("select new Dto.EstudianteDto(e.libretaUniversitaria,e.Nombre,e.Edad,e.Genero,e.CiudadResidencia) " +
            "from Estudiante  e where e.Genero = :genero")
    public List<EstudianteDto>getEstudiantesByGenero(String genero);

    @Query("SELECT new Dto.EstudianteDto(e.libretaUniversitaria,e.Nombre,e.Edad,e.Genero,e.CiudadResidencia) FROM Estudiante e " +
            "JOIN e.carreras cc " +
            "JOIN cc.carreraCursada c " +
            "WHERE c.nombre = :carrera AND e.CiudadResidencia = :ciudad")
    public List<EstudianteDto>getEstudiantesByCarreraOrderByCiudad(String carrera, String Ciudad);

    @Query("select new Dto.EstudianteDto(e.libretaUniversitaria,e.Nombre,e.Edad,e.Genero,e.CiudadResidencia) " +
            "from Estudiante e ORDER BY e.Edad")
    public List<Estudiante> getOrderByEdad();
}
