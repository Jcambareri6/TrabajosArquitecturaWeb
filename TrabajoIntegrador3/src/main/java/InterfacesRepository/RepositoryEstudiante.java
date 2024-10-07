package InterfacesRepository;

import Dto.EstudianteDto;
import Entities.Dao.Estudiante;

import java.util.List;

public interface RepositoryEstudiante {

    public void delete(Estudiante e);
    public void add(Estudiante es);
    public List<EstudianteDto> getOrderByEdad();
    public List<EstudianteDto>GetAll();
    public Estudiante findByLibretaUniversitaria(int LibretaUniversitaria);
    public List<EstudianteDto>getAllByGenero(String genero);
    public List<EstudianteDto>getEstudiantesByCarreraOrderByCiudad(String carrera, String Ciudad);
}
