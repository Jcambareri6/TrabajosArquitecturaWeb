package InterfacesRepository;

import Entities.Dao.Carrera;
import Dto.CarreraDto;

import java.util.List;

public interface RepositoryCarrera  {

    public void add (Carrera c );
    public  void delete(Carrera c);
    public List<CarreraDto> getAll();
    public Carrera findBy(int id);
    public List<CarreraDto> getCarrerasOrderByCantidadInscriptos();

}
