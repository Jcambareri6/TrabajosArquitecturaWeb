//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Services;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Dto.EstudianteDto;
import Entities.Dao.Estudiante;
import InterfacesRepository.RepositoryEstudiante;

@Service("EstudianteServicio")
public class EstudianteServicio implements BaseService<Estudiante> {
    @Autowired
    private RepositoryEstudiante estudianteRepositorio;

    public EstudianteServicio() {
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (this.estudianteRepositorio.findByLibretaUniversitaria(id) != null) {
                int intId = Math.toIntExact(id);
                this.estudianteRepositorio.deleteById(intId);
                return true;
            }
            return false;
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    public EstudianteDto findByNombre(String nombre) throws Exception {
        try {
            Optional<EstudianteDto> estudianteBuscado = this.estudianteRepositorio.findByNombre(nombre);
            return (EstudianteDto) estudianteBuscado.get();
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    public void add(Estudiante e) throws Exception {
        try {
            if ( this.estudianteRepositorio.findByLibretaUniversitaria(e.getLibretaUniversitaria()) == null) {
                this.estudianteRepositorio.save(e);
            }
        } catch (Exception var3) {
            Exception ex = var3;
            throw new Exception(ex.getMessage());
        }
    }


    

    /* @Transactional
    public List<EstudianteDto> getOrderByEdad() throws Exception {
        List<Estudiante> resultado = this.estudianteRepositorio.getOrderByEdad();

        try {
            return (List)resultado.stream().map((estudiante) -> {
                return new EstudianteDto(estudiante.getLibretaUniversitaria(),
                        estudiante.getNombre(),
                        estudiante.getApellido(),
                        estudiante.getEdad(),
                        estudiante.getGenero(),
                        estudiante.getCiudadResidencia())
            }).collect(Collectors.toList());
        } catch (Exception var4) {
            Exception e = var4;
            throw new Exception(e.getMessage());
        }
        
    } */

    /* 
    @Transactional
    public List<EstudianteDto> getOrderByEdad() throws Exception {
        List<Estudiante> resultado = this.estudianteRepositorio.getOrderByEdad();

        try {
            return (List)resultado.stream().collect(Collectors.toList());
        } catch (Exception var4) {
            Exception e = var4;
            throw new Exception(e.getMessage());
        }
    }
 */

    @Transactional
    public List<Estudiante> findAll() throws Exception {
        return this.estudianteRepositorio.findAll();
    }

    /* @Transactional
    public Estudiante findByLibretaUniversitaria(int LibretaUniversitaria) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.estudianteRepositorio
                    .findByLibretaUniversitaria(LibretaUniversitaria);
            return (Estudiante) estudianteBuscado.get();
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    } */

    /* @Transactional
    public List<EstudianteDto> getAllByGenero(String genero) throws Exception {
        List<Estudiante> resultado = this.estudianteRepositorio.getAllByGenero(genero);

        try {
            return (List)resultado.stream().map((estudiante) -> {
                return new EstudianteDto(estudiante.getLibretaUniversitaria(),
                        estudiante.getNombre(),
                        estudiante.getApellido(),
                        estudiante.getEdad(),
                        estudiante.getGenero(),
                        estudiante.getCiudadResidencia()
            }).collect(Collectors.toList());
        } catch (Exception var4) {
            Exception e = var4;
            throw new Exception(e.getMessage());
        }
    } */

    /* @Transactional
    public List<EstudianteDto>getEstudiantesByCarreraOrderByCiudad(String carrera, String Ciudad) throws Exception {
        List<Estudiante> resultado = this.estudianteRepositorio.getEstudiantesByCarreraOrderByCiudad(carrera,Ciudad);

        try {
            return (List)resultado.stream().map((estudiante) -> {
                return new EstudianteDto( estudiante.getLibretaUniversitaria(),
                        estudiante.getNombre(),
                        estudiante.getApellido(),
                        estudiante.getEdad(),
                        estudiante.getGenero(),
                        estudiante.getCiudadResidencia();
            }).collect(Collectors.toList());
        } catch (Exception var4) {
            Exception e = var4;
            throw new Exception(e.getMessage());
        }
    } */

    @Transactional
    public Estudiante save(Estudiante entity) throws Exception {
        try {
            return (Estudiante) this.estudianteRepositorio.save(entity);
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante update(int id, Estudiante entity) throws Exception {
        try {
            Optional<Estudiante> entityOpcional = this.estudianteRepositorio.findById(id);
            Estudiante e = (Estudiante) entityOpcional.get();
            e = (Estudiante) this.estudianteRepositorio.save(entity);
            return e;
        } catch (Exception var5) {
            Exception e = var5;
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Estudiante findById(Long id) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.estudianteRepositorio.findById(Math.toIntExact(id));
            return (Estudiante) estudianteBuscado.get();
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}