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

import erp.compra.Entidades.Categoria;
import erp.compra.Servicios.Service_Categoria;

@RestController
@RequestMapping(value = "/api/v1/")
public class CategoriaController {
    
    @Autowired
    private Service_Categoria categoria;
  

    @GetMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> findAll() {
        return categoria.findAll();
    }

    @GetMapping(value = "categoria/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<Categoria> empresa(@PathVariable(value = "id", required = true) Long id) {
        return categoria.findOne(id);
    }

    @PostMapping(value = "categoria", produces = "application/json; charset=utf-8", consumes = "application/json")
    public Categoria save(@RequestBody Categoria inventarioo) {
        return categoria.save(inventarioo);
    }

    @DeleteMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return categoria.deleteById(id);
    }
}