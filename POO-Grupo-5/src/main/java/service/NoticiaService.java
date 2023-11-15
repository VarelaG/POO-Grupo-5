package service;

// NoticiaService.java
import modelo.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.NoticiaRepository;

import java.util.List;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    @Autowired
    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    // Métodos para realizar operaciones CRUD con noticiaRepository
    public List<Noticia> getAllNoticias() {
        return noticiaRepository.findAll();
    }

    public Noticia getNoticiaById(Long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    public Noticia createNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public Noticia updateNoticia(Long id, Noticia noticia) {
        if (noticiaRepository.existsById(id)) {
            noticia.setId(id);
            return noticiaRepository.save(noticia);
        }
        return null; // Manejar la situación en la que la noticia no existe
    }

    public void deleteNoticia(Long id) {
        noticiaRepository.deleteById(id);
    }
}
