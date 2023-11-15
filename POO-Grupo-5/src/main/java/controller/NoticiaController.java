package controller;

// NoticiaController.java
import modelo.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.NoticiaService;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    private final NoticiaService noticiaService;

    @Autowired
    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public List<Noticia> getAllNoticias() {
        return noticiaService.getAllNoticias();
    }

    @GetMapping("/{id}")
    public Noticia getNoticiaById(@PathVariable Long id) {
        return noticiaService.getNoticiaById(id);
    }

    @PostMapping
    public Noticia createNoticia(@RequestBody Noticia noticia) {
        return noticiaService.createNoticia(noticia);
    }

    @PutMapping("/{id}")
    public Noticia updateNoticia(@PathVariable Long id, @RequestBody Noticia noticia) {
        return noticiaService.updateNoticia(id, noticia);
    }

    @DeleteMapping("/{id}")
    public void deleteNoticia(@PathVariable Long id) {
        noticiaService.deleteNoticia(id);
    }
}
