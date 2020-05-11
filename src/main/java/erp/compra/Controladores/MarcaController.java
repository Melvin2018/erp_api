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
import erp.compra.Servicios.Service_Marca;

@RestController
@RequestMapping(value = "/api/v1/")
public class MarcaController {
    @Autowired
    private Service_Marca repo_marca;
  

    @GetMapping(value="marca", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Marca> findAll() {
        return repo_marca.findAll();
    }

    @GetMapping(value = "marca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Marca> findBy(@PathVariable(value = "id", required = true) Long id) {
        return repo_marca.findOne(id);
    }

    @PostMapping(value = "marca", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Marca save(@RequestBody Marca marca) {
        return repo_marca.save(marca);
    }

    @DeleteMapping(value="marca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Marca> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return repo_marca.deleteById(id);
    }
}