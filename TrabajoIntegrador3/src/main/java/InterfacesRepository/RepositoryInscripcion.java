package InterfacesRepository;

import Entities.Dao.Inscripcion;
import Dto.InscripcionDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryInscripcion extends JpaRepository<Inscripcion, Integer> {


}
