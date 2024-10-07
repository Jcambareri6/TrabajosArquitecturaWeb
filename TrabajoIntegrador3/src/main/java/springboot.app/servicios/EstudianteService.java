//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package springboot.app.servicios;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.EstudianteDTO;
import springboot.app.modelos.Estudiante;
import springboot.app.repositorios.EstudianteRepositorio;

@Service("EstudianteServicio")
public class EstudianteServicio implements BaseService<Estudiante> {
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    public EstudianteServicio() {
    }

    @Transactional
    public void delete(Estudiante e) throws Exception {
        try {
            if (this.estudianteRepositorio.findByLibretaUniversitaria(e.id)) {
                this.estudianteRepositorio.delete(e);
            }
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    public void add(Estudiante e){
        try {
            if (this.estudianteRepositoriofindByLibretaUniversitaria(e.id)) {
                this.estudianteRepositorio.add(e);
            }
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDTO> getOrderByEdad() throws Exception {
        List<Estudiante> resultado = this.estudianteRepositorio.getOrderByEdad();

        try {
            return (List)resultado.stream().map((estudiante) -> {
                return new EstudianteDTO( estudiante.getLibretaUniversitaria(),
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
    }

    @Transactional
    public List<Estudiante> GetAll() throws Exception {
        return this.estudianteRepositorio.GetAll();
    }

    @Transactional
    public Estudiante findByLibretaUniversitaria(int LibretaUniversitaria)) throws Exception {
        try {
            Optional<Estudiante> estudianteBuscado = this.estudianteRepositorio.findByLibretaUniversitaria(
            int LibretaUniversitaria);
            return (Estudiante) estudianteBuscado.get();
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDTO> getAllByGenero(String genero) throws Exception {
        List<Estudiante> resultado = this.estudianteRepositorio.getAllByGenero(genero);

        try {
            return (List)resultado.stream().map((estudiante) -> {
                return new EstudianteDTO( estudiante.getLibretaUniversitaria(),
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
    }
    @Transactional
    public List<EstudianteDTO>getEstudiantesByCarreraOrderByCiudad(String carrera, String Ciudad) throws Exception {
        List<Estudiante> resultado = this.estudianteRepositorio.getEstudiantesByCarreraOrderByCiudad(carrera,Ciudad);

        try {
            return (List)resultado.stream().map((estudiante) -> {
                return new EstudianteDTO( estudiante.getLibretaUniversitaria(),
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
    }
    @Transactional
    public Estudiante save(Estudiante entity) throws Exception {
        try {
            return (Estudiante)this.estudianteRepositorio.save(entity);
        } catch (Exception var3) {
            Exception e = var3;
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante update(int id, Estudiante entity) throws Exception {
        try {
            Optional<Estudiante> entityOpcional = this.estudianteRepositorio.findById(id);
            Estudiante e = (Estudiante)entityOpcional.get();
            e = (Estudiante)this.estudianteRepositorio.save(entity);
            return e;
        } catch (Exception var5) {
            Exception e = var5;
            throw new Exception(e.getMessage());
        }
    }
}