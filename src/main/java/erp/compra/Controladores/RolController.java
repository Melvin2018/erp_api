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

import erp.compra.Entidades.Rol;
import erp.compra.Servicios.Service_Rol;

@RestController
@RequestMapping(value = "/api/v1/")
public class RolController {
    @Autowired
    private Service_Rol rol;
  

    @GetMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rol> findAll() {
        return rol.findAll();
    }

    @GetMapping(value = "categoria/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<Rol> empresa(@PathVariable(value = "id", required = true) Long id) {
        return rol.findOne(id);
    }

    @PostMapping(value = "categoria", produces = "application/json; charset=utf-8", consumes = "application/json")
    public Rol save(@RequestBody Rol inventarioo) {
        return rol.save(inventarioo);
    }

    @DeleteMapping(value="categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rol> deleteById(@PathVariable(value = "id", required = true) Long id) {
        return rol.deleteById(id);
    }
}