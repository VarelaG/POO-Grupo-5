package repositorio;

// NoticiaRepository.java
import modelo.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    // Puedes agregar métodos personalizados aquí si necesitas consultas específicas
}
