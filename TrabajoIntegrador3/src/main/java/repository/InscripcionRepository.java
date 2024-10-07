//package repository;
//
//
//import Entities.Dao.Inscripcion;
//import InterfacesRepository.RepositoryInscripcion;
//import Dto.InscripcionDto;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class InscripcionRepository implements RepositoryInscripcion {
//    private static InscripcionRepository Singleton = null;
//    private EntityManagerFactory emf;
//    private EntityManager em;
//
//    public InscripcionRepository() {
//        this.emf = Persistence.createEntityManagerFactory("Example");
//        this.em = emf.createEntityManager();
//    }
//    public static InscripcionRepository getCarrerasCursadasRepository(){
//        if(Singleton==null){
//            Singleton = new InscripcionRepository();
//        }
//        return Singleton;
//    }
//    private InscripcionDto convertToDto(Inscripcion inscripcion) { //?????
//        return new InscripcionDto(
//                inscripcion.getCarreraCursada(),
//                inscripcion.getEstudianteEnCurso()
//        );
//    }
//
//    @Override
//    public void add(Inscripcion inscripcion) {
//        em.getTransaction().begin();
//        em.merge(inscripcion);
//        em.getTransaction().commit();
//    }
//
//    @Override
//    public void delete(int id) {
//        Inscripcion inscripcion = this.em.find(Inscripcion.class,id);
//        this.em.remove(inscripcion);
//    }
//
//    @Override
//    public List<InscripcionDto> getAll() {
//        List<Inscripcion> consulta = em.createQuery("SELECT i FROM Inscripcion i", Inscripcion.class).getResultList();
//        return consulta.stream().map(this::convertToDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public Inscripcion getById(int id) {
//        return this.em.find(Inscripcion.class,id);
//    }
//
//}
//
//
//
//
//
//
//
//
