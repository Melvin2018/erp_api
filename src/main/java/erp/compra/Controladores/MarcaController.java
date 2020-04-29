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

import erp.compra.Entidades.Marca;
import erp.compra.Servicios.Service_Marca;

@RestController
@RequestMapping(value = "/api/v1/")
public class MarcaController {
    @Autowired
    private Service_Marca marca;
  

    @GetMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Marca> findAll() {
        return marca.findAll();
    }

    @GetMapping(value = "categoria/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<Marca> empresa(@PathVariable(value = "id", required = true) Long id) {
        return marca.findOne(id);
    }

    @PostMapping(value = "categoria", produces = "application/json; charset=utf-8", consumes = "application/json")
    public Marca save(@RequestBody Marca inventarioo) {
        return marca.save(inventarioo);
    }

    @DeleteMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Marca> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return marca.deleteById(id);
    }
}