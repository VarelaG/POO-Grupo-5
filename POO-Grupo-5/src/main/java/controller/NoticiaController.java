package controller;

// NoticiaController.java
import modelo.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.NoticiaService;

import java.net.URI;
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
    public ResponseEntity<Noticia> getNoticiaById(@PathVariable Long id) {
        Noticia noticia = noticiaService.getNoticiaById(id);
        return ResponseEntity.ok().body(noticia);
    }

    @PostMapping
    public ResponseEntity<Noticia> createNoticia(@Valid @RequestBody Noticia noticia) {
        Noticia nuevaNoticia = noticiaService.createNoticia(noticia);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(nuevaNoticia.getId()).toUri();
        return ResponseEntity.created(location).body(nuevaNoticia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> updateNoticia(@PathVariable Long id, @Valid @RequestBody Noticia noticia) {
        Noticia noticiaActualizada = noticiaService.updateNoticia(id, noticia);
        return ResponseEntity.ok().body(noticiaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoticia(@PathVariable Long id) {
        noticiaService.deleteNoticia(id);
        return ResponseEntity.noContent().build();
    }
}
