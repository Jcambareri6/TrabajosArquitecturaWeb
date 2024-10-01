package InterfacesRepository;

import Entities.Dao.Inscripcion;
import Dto.InscripcionDto;
import java.util.List;

public interface RepositoryInscripcion {
    public void add(Inscripcion insc);
    public void delete(int id);
    public List<InscripcionDto> getAll();
    public Inscripcion getById(int id);
}
