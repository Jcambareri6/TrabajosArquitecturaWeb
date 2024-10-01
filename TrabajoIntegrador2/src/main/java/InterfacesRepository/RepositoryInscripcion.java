package InterfacesRepository;

import Entities.Dao.Inscripcion;

public interface RepositoryInscripcion {
    public void MatricularEstudiante(Inscripcion insc);
    public void deleteInscripcion(int id);
    public void getAll();
    public Inscripcion getById(int id);
}
