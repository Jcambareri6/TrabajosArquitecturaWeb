package InterfacesRepository;

import Dto.EstudianteDto;
import Entities.Dao.Estudiante;

import java.util.List;

public interface RepositoryEstudiante {
    public void AddEstudiante(Estudiante es);
    public List<Estudiante> getOrderByEdad();
    public List<Estudiante>GetAll();
    public Estudiante findByLibretaUniversitaria(int LibretaUniversitaria);
    public List<Estudiante>getAllByGenero(String genero);
    public List<EstudianteDto>getEstudiantesByCarreraOrderByCiudad(String carrera, String Ciudad);
}
