package Entities.Dao;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class CarrerasCursadasPk  implements Serializable {
    public CarrerasCursadasPk(int idCarrera, int idEstudiante) {
        this.idCarrera = idCarrera;
        this.idEstudiante = idEstudiante;
    }

    private int idCarrera;
    private int idEstudiante;


    public CarrerasCursadasPk() {

    }
}
