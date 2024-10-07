package InterfacesRepository;

import Entities.Dao.Inscripcion;
import Dto.InscripcionDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryInscripcion extends JpaRepository<Inscripcion, Long> {
    public void add(Inscripcion insc);
    public void delete(int id);
    public List<InscripcionDto> getAll();
    public Inscripcion getById(int id);
}
