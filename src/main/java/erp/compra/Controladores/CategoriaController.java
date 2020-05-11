package erp.compra.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erp.compra.Entidades.*;
import erp.compra.Servicios.Service_Categoria;

@RestController
@RequestMapping(value = "/api/v1/")
public class CategoriaController {
    
    @Autowired
    private Service_Categoria repo;

    @GetMapping(value="categoria", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Categoria>> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "categoria/{id}", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Categoria> findBy(@PathVariable(value = "id", required = true) Long id) {
        return repo.findOne(id);
    }

    @PostMapping(value = "categoria", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Categoria save(@RequestBody Categoria categoria) {
        return repo.save(categoria);
    }

    @DeleteMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Categoria> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return repo.deleteById(id);
    }
}